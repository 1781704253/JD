package zhangyanran20181018.bwie.com.myjddemo.mvp.home.view;

import java.util.List;

import zhangyanran20181018.bwie.com.myjddemo.bean.BannerBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.JiuBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.OneUser;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public interface MyView {
    void onSuccess(List<OneUser.DataBean> data);

    void onSuccessJiu(List<JiuBean.DataBean> jiu_data);

    void onSuccessBan(List<BannerBean.DataBean> banner_data);
}
