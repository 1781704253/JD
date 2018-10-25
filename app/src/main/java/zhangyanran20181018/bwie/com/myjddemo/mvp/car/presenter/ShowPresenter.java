package zhangyanran20181018.bwie.com.myjddemo.mvp.car.presenter;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Response;
import zhangyanran20181018.bwie.com.myjddemo.even.ShowCallBack;
import zhangyanran20181018.bwie.com.myjddemo.mvp.car.model.ShowModel;
import zhangyanran20181018.bwie.com.myjddemo.mvp.car.view.ShowView;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class ShowPresenter {
    private ShowView showView;
    private ShowModel showModel;
    public ShowPresenter(ShowView showView) {
        this.showView = showView;
        showModel = new ShowModel();
    }

    public void show(){
        HashMap<String, String> parms = new HashMap<>();
        showModel.show("http://www.zhaoapi.cn/product/getCarts?uid=71", parms, new ShowCallBack() {
            @Override
            public void onSuccess(Call call, Response response) {
                try {
                    String string = response.body().string();
                    showView.onSuccess(string);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call call, IOException e) {
                showView.onFailure("失败");
            }
        });
    }
}
