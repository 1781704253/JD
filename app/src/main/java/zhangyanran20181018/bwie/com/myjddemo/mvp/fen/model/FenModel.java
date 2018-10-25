package zhangyanran20181018.bwie.com.myjddemo.mvp.fen.model;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import zhangyanran20181018.bwie.com.myjddemo.api.Api;
import zhangyanran20181018.bwie.com.myjddemo.bean.Yean;
import zhangyanran20181018.bwie.com.myjddemo.bean.Zean;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class FenModel {
    ScuMod scuMod;

    public void setScuMod(ScuMod scuMod) {
        this.scuMod = scuMod;
    }

    //左面请求
    public void ZuoChen(){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance("http://www.zhaoapi.cn/",ok)
                .setCreate(Api.class)
                .Zuo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Zean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Zean zean) {
                        scuMod.Zc(zean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    //右面请求
    public void YuoChen(int cont){
        //OkHttp里面可以添加拦截器
        OkHttpClient ok = new OkHttpClient.Builder()
                .build();
        //请求数据
        RetrofitUnitl.getInstance("http://www.zhaoapi.cn/",ok)
                .setCreate(Api.class)
                .You(cont)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Yean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Yean yean) {
                        scuMod.Yc(yean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    //定义一个接口
    public interface ScuMod{
        void Zc(Zean bean);
        void Yc(Yean yean);
    }
}
