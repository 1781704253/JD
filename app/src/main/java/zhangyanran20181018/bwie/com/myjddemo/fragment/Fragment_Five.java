package zhangyanran20181018.bwie.com.myjddemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.activity.RagActivity;
import zhangyanran20181018.bwie.com.myjddemo.mvp.login.presenter.AccountPretension;
import zhangyanran20181018.bwie.com.myjddemo.mvp.login.view.RagIView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Five extends Fragment implements RagIView {


    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_pasword)
    EditText editPasword;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.text_view)
    TextView textView;
    Unbinder unbinder;
    private AccountPretension accountP;
    private String name;
    private String pwd;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_fragment__five, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //创建P层
        accountP = new AccountPretension(this);
        x.view().inject(getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.but_login, R.id.text_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_login:
                readNameAndPwd();
                if (name.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$")){
                    if (pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
                        accountP.login(name, pwd);
                    }else{
                        Toast.makeText(getActivity(),"密码不少于8位字母数字组合",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getActivity(),"请输入正确的手机格式",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.text_view:
                Intent intent = new Intent(getActivity(), RagActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void readNameAndPwd() {
        name = editName.getText().toString();
        pwd = editPasword.getText().toString();
    }

    @Override
    public void onSuccess(final String msg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onError(final String errorMsg) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(),errorMsg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
