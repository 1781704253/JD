package zhangyanran20181018.bwie.com.myjddemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.mvp.login.presenter.AccountPretension;
import zhangyanran20181018.bwie.com.myjddemo.mvp.login.view.RagIView;

public class RagActivity extends AppCompatActivity implements RagIView {

    @BindView(R.id.edit_nameDL)
    EditText editNameDL;
    @BindView(R.id.edit_pwdDL)
    EditText editPwdDL;
    @BindView(R.id.but_regDL)
    Button butRegDL;
    private AccountPretension accountP;
    private String name;
    private String pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rag);
        ButterKnife.bind(this);
        //创建P层
        accountP = new AccountPretension(this);
        x.view().inject(this);
    }

    @OnClick(R.id.but_regDL)
    public void onViewClicked() {
        readNameAndPwd();
        if (name.matches("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$")){
            if (pwd.matches("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$")){
                accountP.reg(name, pwd);
            }else{
                Toast.makeText(RagActivity.this,"密码不少于8位字母数字组合",Toast.LENGTH_SHORT).show();
            }
        }else {
            Toast.makeText(RagActivity.this,"请输入正确的手机格式",Toast.LENGTH_SHORT).show();
        }
    }

    private void readNameAndPwd() {
        name = editNameDL.getText().toString();
        pwd = editPwdDL.getText().toString();
    }

    @Override
    public void onSuccess(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RagActivity.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onError(final String errorMsg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RagActivity.this,errorMsg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
