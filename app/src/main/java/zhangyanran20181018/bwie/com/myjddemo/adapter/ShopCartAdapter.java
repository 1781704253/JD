package zhangyanran20181018.bwie.com.myjddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import io.reactivex.annotations.NonNull;
import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.bean.CarBean;
import zhangyanran20181018.bwie.com.myjddemo.even.OnResfreshListener;
import zhangyanran20181018.bwie.com.myjddemo.fragment.Fragment_Four;
import zhangyanran20181018.bwie.com.myjddemo.holder.ShopCartHolder;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartHolder> {

    Context context;
    List<CarBean.DataBean.ListBean> data;

    public ShopCartAdapter(Context context, List<CarBean.DataBean.ListBean> data) {
        this.context = context;
        this.data = data;
    }


    @NonNull
    @Override
    public ShopCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShopCartHolder(LayoutInflater.from(context).inflate(R.layout.shop_cart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShopCartHolder holder, final int position) {
        Glide.with(context).load(data.get(position).getImages().split("\\|")[0]).into(holder.ivShopCartClothPic);
        holder.tvShopCartShopName.setText(data.get(position).getShopName());
        holder.tvShopCartClothPrice.setText("¥" + data.get(position).getPrice());
        holder.etShopCartClothNum.setText(data.get(position).getNum() + "");



        /* 商品数量加 */
        holder.ivShopCartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setNum(data.get(position).getNum() + 1);
                notifyDataSetChanged();
            }
        });

        /* 商品数量减 */
        holder.ivShopCartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).getNum() > 1) {
                    data.get(position).setNum(data.get(position).getNum() - 1);
                    notifyDataSetChanged();
                }
            }
        });

        /* 删除操作 */
        holder.ivShopCartClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.remove(position);
                //重新排序，标记所有商品不同商铺第一个的商品位置
                Fragment_Four.isSelectFirst(data);
                notifyDataSetChanged();
            }
        });

        /* 显示前面的选中状态 */
        if (data.get(position).getSelected() == 0) {
            holder.ivShopCartClothSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        } else {
            holder.ivShopCartClothSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        if (data.get(position).getSelected() == 0) {
            holder.ivShopCartShopSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        } else {
            holder.ivShopCartShopSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

         /* 判断是否显示商铺 */
        if (position > 0) {
            /* 判断是否是同一个商铺的商品 */
            if (data.get(position).getSellerid() == data.get(position - 1).getSellerid()) {
                holder.llShopCartHeader.setVisibility(View.GONE);
            } else {
                holder.llShopCartHeader.setVisibility(View.VISIBLE);
            }
        } else {
            holder.llShopCartHeader.setVisibility(View.VISIBLE);
        }

        // 计算逻辑 与操作
        /* 判断是否全选并计算 */
        if (mOnResfreshListener != null) {
            boolean isSelect = false;
            for (int i = 0; i < data.size(); i++) {
                if (data.get(i).getSelected() == 1) {
                    isSelect = false;
                    break;
                } else {
                    isSelect = true;
                }
            }
            mOnResfreshListener.onResfresh(isSelect);
        }

        /* 单个商品 选中状态 */
        holder.ivShopCartClothSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setSelected(data.get(position).getSelected() == 0 ? 1 : 0);
                //通过循环找出不同商铺的第一个商品的位置
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).isFirst()) {
                        //遍历去找出同一家商铺的所有商品的勾选情况
                        for (int j = 0; j < data.size(); j++) {
                            //如果是同一家商铺的商品，并且其中一个商品是未选中，那么商铺的全选勾选取消
                            if (data.get(j).getSellerid() == data.get(i).getSellerid() && data.get(j).getSelected() == 1) {
                                data.get(i).setShopSelect(false);
                                break;
                            } else {
                                //如果是同一家商铺的商品，并且所有商品是选中，那么商铺的选中全选勾选
                                data.get(i).setShopSelect(true);
                            }
                        }
                    }

                }
                notifyDataSetChanged();
            }
        });

        /* 商铺选中状态 */
        holder.ivShopCartShopSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (data.get(position).isFirst()) {
                    // 商铺选中状态执反
                    data.get(position).setShopSelect(!data.get(position).isShopSelect());
                    // 改变商品的选中状态和商铺一样
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).getSellerid() == data.get(position).getSellerid()) {
                            data.get(i).setSelected(data.get(position).isShopSelect() ? 0 : 1);
                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return data.size();
    }


    // 刷新的接口
    private OnResfreshListener mOnResfreshListener;

    public void setOnResfreshListener(OnResfreshListener mOnResfreshListener) {
        this.mOnResfreshListener = mOnResfreshListener;
    }
}
