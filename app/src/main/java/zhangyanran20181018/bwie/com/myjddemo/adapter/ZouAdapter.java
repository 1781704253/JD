package zhangyanran20181018.bwie.com.myjddemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.bean.Zean;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class ZouAdapter extends RecyclerView.Adapter<ZouAdapter.MyHolder> {
    private Context context;
    private Zean zean;
    private OnItemClickListener mOnItemClickListener;

    public ZouAdapter(Context context, Zean list) {
        this.context = context;
        this.zean = list;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder holder = new MyHolder(LayoutInflater.from(context).inflate(R.layout.zuo_layout, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {
        holder.zuo_mz.setText(zean.getData().get(position).getName());
        if (mOnItemClickListener != null) {
            holder.zuo_mz.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return zean.getData().size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView zuo_mz;

        public MyHolder(View itemView) {
            super(itemView);
            zuo_mz = itemView.findViewById(R.id.zuo_mz);
        }
    }
}