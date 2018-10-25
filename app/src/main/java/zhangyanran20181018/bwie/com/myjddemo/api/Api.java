package zhangyanran20181018.bwie.com.myjddemo.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhangyanran20181018.bwie.com.myjddemo.bean.Yean;
import zhangyanran20181018.bwie.com.myjddemo.bean.Zean;

/**
 * Created by 匹诺曹 on 2018/10/19.
 */

public interface Api {
    @GET("product/getCatagory")
    Observable<Zean> Zuo();
    @GET("product/getProductCatagory")
    Observable<Yean> You(@Query("cid") int cid);
}
