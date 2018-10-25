package zhangyanran20181018.bwie.com.myjddemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.stx.xhb.xbanner.XBanner;
import com.stx.xhb.xbanner.transformers.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.adapter.HomeAdapter;
import zhangyanran20181018.bwie.com.myjddemo.adapter.JiuAdapter;
import zhangyanran20181018.bwie.com.myjddemo.bean.BannerBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.JiuBean;
import zhangyanran20181018.bwie.com.myjddemo.bean.OneUser;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.presenter.HomePresenter;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.presenter.HomePresenterBanner;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.presenter.HomePresenterJiu;
import zhangyanran20181018.bwie.com.myjddemo.mvp.home.view.MyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_One extends Fragment implements MyView {


    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.but_one)
    Button butOne;
    private GridLayoutManager layoutManager;
    private HomePresenter mainPresenter;
    private HomeAdapter myAdapter;
    private int page = 1;
    private JiuAdapter jiuAdapter;
    private GridLayoutManager gridLayoutManager;
    private HomePresenterJiu homePresenterJiu;
    private RecyclerView recyclerViewJiu,recyclerView;
    private XBanner ban_ner;
    private List<String> imageUrls = new ArrayList<>();
    private HomePresenterBanner homePresenterBanner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment__one, container, false);
        recyclerViewJiu = inflate.findViewById(R.id.recycler_view_jiu);
        recyclerView = inflate.findViewById(R.id.recycler_view);
        ban_ner = inflate.findViewById(R.id.ban_ner);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        mainPresenter.getDatas("手机", page, "0");
        homePresenterJiu.getDataJiu();
        homePresenterBanner.getDataBanner();
    }

    private void initView() {
        layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        gridLayoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewJiu.setLayoutManager(gridLayoutManager);
    }

    private void initData() {
        mainPresenter = new HomePresenter(this);
        homePresenterJiu = new HomePresenterJiu(this);
        homePresenterBanner = new HomePresenterBanner(this);
        myAdapter = new HomeAdapter(getActivity());
        jiuAdapter = new JiuAdapter(getActivity());


    }


    @OnClick(R.id.but_one)
    public void onViewClicked() {

    }


    @Override
    public void onSuccess(List<OneUser.DataBean> data) {
        myAdapter.addData(data, true);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccessJiu(List<JiuBean.DataBean> jiu_data) {
        jiuAdapter.addData(jiu_data,true);
        recyclerViewJiu.setAdapter(jiuAdapter);
        jiuAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccessBan(List<BannerBean.DataBean> banner_data) {
        Log.i("pp",banner_data.get(1).getTitle());
        for (int i = 0; i < banner_data.size();i++){
            imageUrls.add(banner_data.get(i).getIcon());
        }
        ban_ner.setData(imageUrls,null);
        // 设置XBanner的页面切换特效
        ban_ner.setPageTransformer(Transformer.Default);
        // 设置XBanner页面切换的时间，即动画时长
        ban_ner.setPageChangeDuration(1000);
        ban_ner.startAutoPlay();
    }

}
