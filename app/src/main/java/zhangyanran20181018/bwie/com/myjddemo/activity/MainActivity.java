package zhangyanran20181018.bwie.com.myjddemo.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import zhangyanran20181018.bwie.com.myjddemo.R;
import zhangyanran20181018.bwie.com.myjddemo.fragment.Fragment_Five;
import zhangyanran20181018.bwie.com.myjddemo.fragment.Fragment_Four;
import zhangyanran20181018.bwie.com.myjddemo.fragment.Fragment_One;
import zhangyanran20181018.bwie.com.myjddemo.fragment.Fragment_Three;
import zhangyanran20181018.bwie.com.myjddemo.fragment.Fragment_Two;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home_frame_layout)
    FrameLayout homeFrameLayout;
    @BindView(R.id.home_rb1)
    RadioButton homeRb1;
    @BindView(R.id.home_rb2)
    RadioButton homeRb2;
    @BindView(R.id.home_rb3)
    RadioButton homeRb3;
    @BindView(R.id.home_rb4)
    RadioButton homeRb4;
    @BindView(R.id.home_rb5)
    RadioButton homeRb5;
    @BindView(R.id.home_radio_group)
    RadioGroup homeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //点击切换
        homeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.home_rb1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new Fragment_One()).commit();
                        break;
                    case R.id.home_rb2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new Fragment_Two()).commit();
                        break;
                    case R.id.home_rb3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new Fragment_Three()).commit();
                        break;
                    case R.id.home_rb4:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new Fragment_Four()).commit();
                        break;
                    case R.id.home_rb5:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_frame_layout,new Fragment_Five()).commit();
                        break;
                }
            }
        });
        //默认选中第一个
        homeRadioGroup.check(R.id.home_rb1);
    }
}
