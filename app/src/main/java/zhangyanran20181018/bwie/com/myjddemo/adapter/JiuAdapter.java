package zhangyanran20181018.bwie.com.myjddemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.bean.JiuBean;
import zhangyanran20181018.bwie.com.myjddemo.holder.JiuViewHolder;

/**
 * Created by 匹诺曹 on 2018/10/25.
 */

public class JiuAdapter extends RecyclerView.Adapter<JiuViewHolder>{
    Context context;
    List<JiuBean.DataBean> list = new ArrayList();

    public JiuAdapter(Context context) {
        this.context = context;

    }

    public  void addData(List<JiuBean.DataBean> list, boolean isFresh){
        if (list!=null) {
            if(isFresh) {
                this.list.clear();
            }
            Log.i("kkk",list.get(0).getName());
            this.list.addAll(list);
        }
    }

    public List<JiuBean.DataBean> getData() {
        return list;
    }

    @NonNull
    @Override
    public JiuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new JiuViewHolder(LayoutInflater.from(context).inflate(R.layout.home_item_jiu,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull JiuViewHolder holder, int position) {
        String jiu_img= list.get(position).getIcon();
        String jiu_na= list.get(position).getName();
        holder.bindjiutext(jiu_img,jiu_na);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
