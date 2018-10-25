package zhangyanran20181018.bwie.com.myjddemo.mvp.car.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import zhangyanran20181018.bwie.com.myjddemo.even.ShowCallBack;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class OkHttpUtil {
    public static OkHttpUtil okHttpUtil;
    public static OkHttpClient okHttpClient;
    public OkHttpUtil(){
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpUtil getInstance(){
        if (okHttpUtil==null){
            synchronized (OkHttpUtil.class){
                if (okHttpUtil==null){
                    okHttpUtil = new OkHttpUtil();
                }
            }
        }
        return okHttpUtil;
    }

    public void postData(String url, HashMap<String,String> parms, final ShowCallBack showCallBack){
        FormBody.Builder formBody = new FormBody.Builder();
        for (Map.Entry<String,String> stringStringEntry:parms.entrySet()
                ) {
            String key = stringStringEntry.getKey();
            String value = stringStringEntry.getValue();
            formBody.add(key,value);
        }
        if (parms!=null && parms.size()>0){
            Request request = new Request.Builder()
                    .url(url)
                    .post(formBody.build())
                    .build();

            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    showCallBack.onFailure(call,e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    showCallBack.onSuccess(call,response);
                }
            });
        }else {
            Request request = new Request.Builder()
                    .url(url)
                    //.post(formBody.build())
                    .build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    showCallBack.onFailure(call,e);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    showCallBack.onSuccess(call,response);
                }
            });
        }

    }
}
