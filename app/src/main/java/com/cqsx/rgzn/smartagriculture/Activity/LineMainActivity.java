package com.cqsx.rgzn.smartagriculture.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cqsx.rgzn.smartagriculture.R;

public class LineMainActivity extends AppCompatActivity {
    MyView n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_main);
        n=this.findViewById(R.id.sdfg);
       
    }
}