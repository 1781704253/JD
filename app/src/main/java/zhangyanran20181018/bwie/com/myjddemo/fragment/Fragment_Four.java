package zhangyanran20181018.bwie.com.myjddemo.fragment;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.activity.MainActivity;
import zhangyanran20181018.bwie.com.myjddemo.adapter.ShopCartAdapter;
import zhangyanran20181018.bwie.com.myjddemo.bean.CarBean;
import zhangyanran20181018.bwie.com.myjddemo.even.OnResfreshListener;
import zhangyanran20181018.bwie.com.myjddemo.mvp.car.presenter.ShowPresenter;
import zhangyanran20181018.bwie.com.myjddemo.mvp.car.view.ShowView;

public class Fragment_Four extends Fragment implements ShowView {
    private ShowPresenter showPresenter;
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tvShopCartSubmit, tvShopCartSelect, tvShopCartTotalNum;

    private RecyclerView rlvShopCart, rlvHotProducts;
    private ShopCartAdapter mShopCartAdapter;
    private LinearLayout llPay;
    private RelativeLayout rlHaveProduct;
    private List<CarBean.DataBean.ListBean> mAllOrderList = new ArrayList<>();
    private ArrayList<CarBean.DataBean.ListBean> mGoPayList = new ArrayList<>();
    private List<String> mHotProductsList = new ArrayList<>();
    private TextView tvShopCartTotalPrice;
    private int mCount, mPosition;
    private float mTotalPrice1;
    private boolean mSelect;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment__four, container, false);
        //初始化控件
        tvShopCartSelect = inflate.findViewById(R.id.tv_shopcart_addselect);
        tvShopCartTotalPrice = inflate.findViewById(R.id.tv_shopcart_totalprice);
        tvShopCartTotalNum = inflate.findViewById(R.id.tv_shopcart_totalnum);
        rlvShopCart = inflate.findViewById(R.id.rlv_shopcart);
        llPay = inflate.findViewById(R.id.ll_pay);
        tvShopCartSubmit = inflate.findViewById(R.id.tv_shopcart_submit);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//布局管理
        rlvShopCart.setLayoutManager(new LinearLayoutManager(getActivity()));
        //加载适配器
        mShopCartAdapter = new ShopCartAdapter(getActivity(), mAllOrderList);
        rlvShopCart.setAdapter(mShopCartAdapter);
        //创建P层
        showPresenter = new ShowPresenter(this);
        showPresenter.show();

        //实时监控全选按钮----计算总价
        mShopCartAdapter.setOnResfreshListener(new OnResfreshListener() {
            @Override
            public void onResfresh(boolean isSelect) {
                mSelect = isSelect;
                if (isSelect) {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
                } else {
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
                }
                // 计算总价
                float mTotalPrice = 0;
                int mTotalNum = 0;
                mTotalPrice1 = 0;
                mGoPayList.clear();
                // 遍历所有商品 计算总价
                for (int i = 0; i < mAllOrderList.size(); i++)
                    if (mAllOrderList.get(i).getSelected() == 0) {
                        mTotalPrice += mAllOrderList.get(i).getPrice() * mAllOrderList.get(i).getNum();
                        mTotalNum += 1;
                        mGoPayList.add(mAllOrderList.get(i));
                    }
                mTotalPrice1 = mTotalPrice;
                tvShopCartTotalPrice.setText("总价：" + mTotalPrice);
                tvShopCartTotalNum.setText("共" + mTotalNum + "件商品");

            }
        });

        tvShopCartSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 对全选状态进行去反
                mSelect = !mSelect;
                if (mSelect) {
                    // 全部选中
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_selected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
                    for (CarBean.DataBean.ListBean listBean : mAllOrderList) {
                        listBean.setSelected(0);
                        listBean.setShopSelect(true);
                    }
                } else {
                    // 全部取消
                    Drawable left = getResources().getDrawable(R.drawable.shopcart_unselected);
                    tvShopCartSelect.setCompoundDrawablesWithIntrinsicBounds(left, null, null, null);
                    for (CarBean.DataBean.ListBean listBean : mAllOrderList) {
                        listBean.setSelected(1);
                        listBean.setShopSelect(false);
                    }
                }
                mShopCartAdapter.notifyDataSetChanged();
            }
        });

    }

    //判断是否是第一个条目
    public static void isSelectFirst(List<CarBean.DataBean.ListBean> list) {
        // 1. 判断是否有商品 有商品 根据商品是否是第一个显示商铺
        if (list.size() > 0) {
            //头个商品一定属于它所在商铺的第一个位置，isFirst标记为1.
            list.get(0).setFirst(true);
            for (int i = 1; i < list.size(); i++) {
                //每个商品跟它前一个商品比较，如果Shopid相同isFirst则标记为2，
                //如果Shopid不同，isFirst标记为1.
                if (list.get(i).getSellerid() == list.get(i - 1).getSellerid()) {
                    list.get(i).setFirst(false);
                } else {
                    list.get(i).setFirst(true);
                }
            }
        }
    }
    //mvp的回调数据并且加到集合中
    @Override
    public void onSuccess(final String result) {

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Gson gson = new Gson();
                CarBean shopBean = gson.fromJson(result, CarBean.class);
                for (CarBean.DataBean dataBean : shopBean.getData()) {
                    for (CarBean.DataBean.ListBean listBean : dataBean.getList()) {
                        listBean.setShopName(dataBean.getSellerName());
                        mAllOrderList.add(listBean);
                    }
                }
                isSelectFirst(mAllOrderList);
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mShopCartAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    @Override
    public void onFailure(String msg) {

    }
}
