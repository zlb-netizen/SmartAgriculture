package com.cqsx.rgzn.smartagriculture.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cqsx.rgzn.smartagriculture.Activity.LightActivity;
import com.cqsx.rgzn.smartagriculture.Activity.LoginActivity;
import com.cqsx.rgzn.smartagriculture.Activity.SoilActivity;
import com.cqsx.rgzn.smartagriculture.Activity.TemperatureActivity;
import com.cqsx.rgzn.smartagriculture.Activity.WindActivity;
import com.cqsx.rgzn.smartagriculture.R;


public class TestFragment extends Fragment implements View.OnClickListener {
    View view;
    Context context;
   RelativeLayout relativeLayout,wid,test,sun;

    public TestFragment(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intView();
    }

    private void intView() {
        relativeLayout=view.findViewById(R.id.qew);
        sun=view.findViewById(R.id.sun);
        test=view.findViewById(R.id.test);
        wid=view.findViewById(R.id.wid);
        test.setOnClickListener(this);
        wid.setOnClickListener(this);
        sun.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_test, container, false);

        }
        return view;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.qew:
                Intent intent =new Intent(context, TemperatureActivity.class);
                startActivity(intent);
                break;
            case R.id.sun:
               Intent intent2 =new Intent(context, SoilActivity.class);
                startActivity(intent2);
                break;
            case R.id.test:
                Intent intent1 =new Intent(context, LightActivity.class);
                startActivity(intent1);

                break;
                case R.id.wid:
                    Intent intent3=new Intent(context, WindActivity.class);
                    startActivity(intent3);
                    break;
        }
    }
}