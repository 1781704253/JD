package zhangyanran20181018.bwie.com.myjddemo.mvp.fen.presenter;

import zhangyanran20181018.bwie.com.myjddemo.bean.Yean;
import zhangyanran20181018.bwie.com.myjddemo.bean.Zean;
import zhangyanran20181018.bwie.com.myjddemo.mvp.fen.model.FenModel;
import zhangyanran20181018.bwie.com.myjddemo.mvp.fen.view.IFenView;

/**
 * Created by 匹诺曹 on 2018/10/23.
 */

public class FenPresenter implements FenModel.ScuMod  {
    IFenView view;
    FenModel model;

    public FenPresenter(IFenView view) {
        this.view = view;
        model = new FenModel();
        model.setScuMod(this);
    }

    @Override
    public void Zc(Zean bean) {
        view.onZuo(bean);
    }

    @Override
    public void Yc(Yean yean) {
        view.onYuo(yean);
    }

    //左侧调用
    public void  ShowPer(){
        model.ZuoChen();
    }
    // 右侧调用
    public void FlShowYou(int cont){
        model.YuoChen(cont);
    }

}
