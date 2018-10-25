package zhangyanran20181018.bwie.com.myjddemo.mvp.home.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zhangyanran20181018.bwie.com.myjddemo.bean.JiuBean;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.model.HttpUtils;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.view.MyView;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class HomePresenterJiu implements MyPresenter{
    MyView myView;

    public HomePresenterJiu(MyView myView) {
        this.myView = myView;
    }

    public void getDataJiu(){
        Observable<JiuBean> jiu_data = HttpUtils.getUtilsInstance().api.jiu_data();
        jiu_data.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<JiuBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(JiuBean jiuBean) {
                myView.onSuccessJiu(jiuBean.getData());
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
