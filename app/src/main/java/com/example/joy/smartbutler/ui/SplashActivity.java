package com.example.joy.smartbutler.ui;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.joy.smartbutler.MainActivity;
import com.example.joy.smartbutler.R;
import com.example.joy.smartbutler.utils.ShareUtils;
import com.example.joy.smartbutler.utils.StaticClass;
import com.example.joy.smartbutler.utils.UtilTool;

/**
 * Created by joy on 2018/2/14.
 * 包名：com.example.joy.smartbutler.ui
 * 描述：${CLASS_NAME}
 */

public class SplashActivity extends AppCompatActivity {

    private TextView tv_splash;

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case StaticClass.HANDLE_SPLASH:
                    if(isFirst()){
                        startActivity(new Intent(SplashActivity.this,GuideActivity.class));
                    }else{
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    }
                    finish();
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initView();
    }


    private void initView() {

        handler.sendEmptyMessageDelayed(StaticClass.HANDLE_SPLASH, 3000);

        tv_splash=findViewById(R.id.tv_splash);

        UtilTool.setTypeFace(this,tv_splash);
    }


    private boolean isFirst() {
        Boolean is_first = ShareUtils.getBoolean(this, StaticClass.IS_FIRST, true);
        if(is_first){
            ShareUtils.putBoolean(this,StaticClass.IS_FIRST,false);
            return true;
        }else{
            return false;
        }
    }
}
