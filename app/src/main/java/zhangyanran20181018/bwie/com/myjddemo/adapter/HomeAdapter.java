package zhangyanran20181018.bwie.com.myjddemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.activity.WebActivity;
import zhangyanran20181018.bwie.com.myjddemo.holder.MyViewHolder;
import zhangyanran20181018.bwie.com.myjddemo.bean.OneUser;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class HomeAdapter extends RecyclerView.Adapter<MyViewHolder>{
    Context context;
    List<OneUser.DataBean> list = new ArrayList<>();

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public  void addData( List<OneUser.DataBean> list,boolean isFresh){
        if (list!=null) {
            if(isFresh) {
                this.list.clear();
            }
            this.list.addAll(list);
        }
    }

    public List<OneUser.DataBean> getData() {
        return list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        String img= list.get(position).getImages().split("\\|")[0];
        String desc=list.get(position).getTitle();
        String desc2=list.get(position).getPrice();
        holder.bindtext(img,desc,desc2);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra("detailUrl",list.get(position).getDetailUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
