package zhangyanran20181018.bwie.com.myjddemo.mvp.home.model;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class HttpUtils {
    public final HomeApi api;

    private HttpUtils(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(HomeConstant.URL_T)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(HomeApi.class);
    }

    private static class GetUtilsInstance{
        private static HttpUtils httpUtils = new HttpUtils();
    }

    public static HttpUtils getUtilsInstance(){
        return GetUtilsInstance.httpUtils;
    }
}
