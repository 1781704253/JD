package zhangyanran20181018.bwie.com.myjddemo.mvp.car.model;

import java.util.HashMap;

import zhangyanran20181018.bwie.com.myjddemo.even.ShowCallBack;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class ShowModel {
    public void show(String url, HashMap<String,String> parms, ShowCallBack showCallBack){
        OkHttpUtil.getInstance().postData(url,parms,showCallBack);
    }
}
