package zhangyanran20181018.bwie.com.myjddemo.mvp.home.model;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zhangyanran20181018.bwie.com.myjddemo.bean.BannerBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.JiuBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.OneUser;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public interface HomeApi {
    //推荐
    @GET("product/searchProducts")//product/getCatagory
    Observable<OneUser> toget(@Query("keywords") String keywords, @Query("page") int page, @Query("sort") String sort);
    //九宫格
    @GET("product/getCatagory")//product/getCatagory
    Observable<JiuBean> jiu_data();
    //轮播
    @GET("ad/getAd")//product/getCatagory
    Observable<BannerBean> ban_data();
}
