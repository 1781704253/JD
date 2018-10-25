package zhangyanran20181018.bwie.com.myjddemo.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zhangyanran20181018.bwie.com.myjddemo.R;

public class WelComeActivity extends AppCompatActivity {
    private int i = 3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0){
                i--;
                if (i==0){
                    Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
                    startActivity(intent);
                }else{
                    handler.sendEmptyMessageDelayed(0,1000);
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        handler.sendEmptyMessageDelayed(0,1000);
    }
}
