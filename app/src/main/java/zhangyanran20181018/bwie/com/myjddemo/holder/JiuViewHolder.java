package zhangyanran20181018.bwie.com.myjddemo.holder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import zhangyanran20181018.bwie.com.myjddemo.R;

/**
 * Created by 匹诺曹 on 2018/10/25.
 */

public class JiuViewHolder extends RecyclerView.ViewHolder{

    public final SimpleDraweeView image_view;
    public final TextView title_one;

    public JiuViewHolder(View itemView) {
        super(itemView);
        image_view = itemView.findViewById(R.id.jiu_tu);
        title_one = itemView.findViewById(R.id.jiu_name);
    }

    public void bindjiutext(String jiu_img, String jiu_na) {
        image_view.setImageURI(jiu_img);
        title_one.setText(jiu_na);
    }
}
