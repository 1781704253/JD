package zhangyanran20181018.bwie.com.myjddemo.mvp.login.model;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class AccountModle {
    private OkHttpClient client;

    public AccountModle(){
        client= new OkHttpClient
                .Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .build();
    }
    public void reg(String name,String pwd, final AccountCallback callback){
        FormBody formBody = new FormBody
                .Builder()
                .add("mobile",name)
                .add("password",pwd)
                .build();
        Request request = new Request
                .Builder()
                .url("http://www.zhaoapi.cn/user/reg")
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }
    public void login(String name,String pwd, final AccountCallback callback){
        FormBody formBody = new FormBody
                .Builder()
                .add("mobile",name)
                .add("password",pwd)
                .build();
        Request request = new Request
                .Builder()
                .url("http://www.zhaoapi.cn/user/login")
                .post(formBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });
    }
    public interface AccountCallback{
        void onSuccess(String msg);
        void onError(String errorMsg);
    }
}
