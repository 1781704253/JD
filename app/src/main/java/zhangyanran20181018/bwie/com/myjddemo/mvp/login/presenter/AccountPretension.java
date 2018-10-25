package zhangyanran20181018.bwie.com.myjddemo.mvp.login.presenter;

import zhangyanran20181018.bwie.com.myjddemo.mvp.login.model.AccountModle;
import zhangyanran20181018.bwie.com.myjddemo.mvp.login.view.RagIView;

/**
 * Created by 匹诺曹 on 2018/10/24.
 */

public class AccountPretension {
    //引用view
    private RagIView view;
    //创建M层
    private AccountModle modle;
    public AccountPretension(RagIView view) {
        this.view = view;
        modle = new AccountModle();
    }

    public void reg(String name, String pwd) {
        modle.reg(name, pwd, new AccountModle.AccountCallback() {
            @Override
            public void onSuccess(String msg) {
                view.onSuccess(msg);
            }

            @Override
            public void onError(String errorMsg) {
                view.onError("注册失败");
            }
        });
    }

    public void login(String name, String pwd) {
        modle.login(name, pwd, new AccountModle.AccountCallback() {
            @Override
            public void onSuccess(String msg) {
                view.onSuccess(msg);
            }

            @Override
            public void onError(String errorMsg) {
                view.onError("登录失败");
            }
        });
    }
}
