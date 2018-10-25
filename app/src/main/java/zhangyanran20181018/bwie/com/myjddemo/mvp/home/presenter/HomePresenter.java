package zhangyanran20181018.bwie.com.myjddemo.mvp.home.presenter;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.model.HttpUtils;
import zhangyanran20181018.bwie.com.myjddemo.bean.OneUser;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.view.MyView;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class HomePresenter implements MyPresenter{
    MyView myView;

    public HomePresenter(MyView myView) {
        this.myView = myView;
    }

    public void getDatas(String key,int page,String sort){
        Observable<OneUser> toget = HttpUtils.getUtilsInstance().api.toget(key, page, sort);
        toget.observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(new Observer<OneUser>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(OneUser oneUser) {
                myView.onSuccess(oneUser.getData());
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
