package zhangyanran20181018.bwie.com.myjddemo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.adapter.ErAdapter;
import zhangyanran20181018.bwie.com.myjddemo.adapter.ZouAdapter;
import zhangyanran20181018.bwie.com.myjddemo.bean.Yean;
import zhangyanran20181018.bwie.com.myjddemo.bean.Zean;
import zhangyanran20181018.bwie.com.myjddemo.mvp.fen.presenter.FenPresenter;
import zhangyanran20181018.bwie.com.myjddemo.mvp.fen.view.IFenView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Two extends Fragment implements IFenView {


    private FenPresenter presenter;
    private RecyclerView zrv;
    private ExpandableListView yev;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment__two, container, false);
        zrv = inflate.findViewById(R.id.zrv);
        yev = inflate.findViewById(R.id.yev);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //拿到P层
        presenter = new FenPresenter(this);
        presenter.ShowPer();
        presenter.FlShowYou(1);
    }

    @Override
    public void onZuo(final Zean zean) {
        //线性布局
        zrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        //拿到适配器
        ZouAdapter adapter= new ZouAdapter(getActivity(),zean);
        zrv.setAdapter(adapter);
        //调用点击事件
        adapter.setOnItemClickListener(new ZouAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int id = zean.getData().get(position).getCid();
                presenter.FlShowYou(id);
            }
        });
    }

    @Override
    public void onYuo(Yean yean) {
        //拿到适配器
        ErAdapter adapter = new ErAdapter(getActivity(),yean);
        yev.setAdapter(adapter);
        //父级列表默认全部展开
        int groupCount = yev.getCount();
        for (int i=0; i<groupCount; i++){
            yev.expandGroup(i);
        }
        //设置父条目不可点击
        yev.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;//返回true,表示不可点击
            }
        });
        //设置属性去掉默认向下的箭头
        yev.setGroupIndicator(null);
    }

}
