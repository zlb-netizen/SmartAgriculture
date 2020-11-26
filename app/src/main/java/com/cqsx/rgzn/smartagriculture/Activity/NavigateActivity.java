package com.cqsx.rgzn.smartagriculture.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.cqsx.rgzn.smartagriculture.R;

/**
 * 导航页面
 */
public class NavigateActivity extends AppCompatActivity {
      private Handler handler=new Handler(){
        public void handleMessage(Message msg){
            super.handleMessage(msg);
            Intent intent=new Intent(NavigateActivity.this, MainActivity.class);
            startActivity(intent);
            NavigateActivity.this.finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏ActionBar
        getSupportActionBar().hide();
        setContentView(R.layout.activity_navigate);
        //3秒后自动跳转到登录页面
        handler.sendEmptyMessageDelayed(0,3000);
    }
}