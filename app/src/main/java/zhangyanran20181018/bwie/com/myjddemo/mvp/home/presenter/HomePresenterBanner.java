package zhangyanran20181018.bwie.com.myjddemo.mvp.home.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zhangyanran20181018.bwie.com.myjddemo.bean.BannerBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.OneUser;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.model.HttpUtils;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.view.MyView;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class HomePresenterBanner implements MyPresenter{
    MyView myView;

    public HomePresenterBanner(MyView myView) {
        this.myView = myView;
    }

    public void getDataBanner(){
        Observable<BannerBean> toget = HttpUtils.getUtilsInstance().api.ban_data();
        toget.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<BannerBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(BannerBean bannerBean) {
                myView.onSuccessBan(bannerBean.getData());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onDestroy() {
        if (myView!=null){
            myView=null;
        }
    }
}
