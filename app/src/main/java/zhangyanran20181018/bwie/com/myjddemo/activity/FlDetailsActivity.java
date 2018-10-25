package zhangyanran20181018.bwie.com.myjddemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import zhangyanran20181018.bwie.com.myjddemo.R;

public class FlDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fl_details);
        String cips = getIntent().getStringExtra("cip");
        int id=Integer.parseInt(cips);


    }
}
