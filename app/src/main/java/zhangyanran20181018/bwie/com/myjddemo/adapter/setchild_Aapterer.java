package zhangyanran20181018.bwie.com.myjddemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.activity.FlDetailsActivity;
import zhangyanran20181018.bwie.com.myjddemo.bean.Yean;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class setchild_Aapterer extends RecyclerView.Adapter<setchild_Aapterer.ViewHodler>{
    private Context context;
    private Yean yean;
    private int i,i1;
    private OnItemClickListener mOnItemClickListener;

    public setchild_Aapterer(Context context,Yean list,int i,int i1) {
        this.context = context;
        this.yean = list;
        this.i = i;
        this.i1 = i1;
    }
    //点击事件
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    @Override
    public setchild_Aapterer.ViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = View.inflate(context, R.layout.child_item,null);
        ViewHodler hodler = new ViewHodler(v);
        hodler.img_child = v.findViewById(R.id.img_child);
        hodler.tv_child = v.findViewById(R.id.tv_child);
        return hodler;
    }

    @Override
    public void onBindViewHolder(final setchild_Aapterer.ViewHodler holder, final int position) {

        String[] str =yean.getData().get(i).getList().get(position).getIcon().split("\\|");
        String s = str[0];
        Glide.with(context).load(s).into(holder.img_child);
        holder.tv_child.setText(yean.getData().get(i).getList().get(position).getName());
        final int pcid = yean.getData().get(i).getList().get(position).getPcid();
        if (mOnItemClickListener != null){
            holder.img_child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(context, FlDetailsActivity.class);
                    intent.putExtra("cip",pcid+"");
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return yean.getData().get(i).getList().size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder {
        private ImageView img_child;
        private TextView tv_child;
        public ViewHodler(View itemView) {
            super(itemView);
        }
    }
}
