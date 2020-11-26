package com.cqsx.rgzn.smartagriculture.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cqsx.rgzn.smartagriculture.Activity.ControlLightActivity;
import com.cqsx.rgzn.smartagriculture.Activity.ControlSoilActivity;
import com.cqsx.rgzn.smartagriculture.Activity.ControlTemperatureActivity;
import com.cqsx.rgzn.smartagriculture.Activity.ControlWindActivity;
import com.cqsx.rgzn.smartagriculture.Activity.ControlWindoutActivity;
import com.cqsx.rgzn.smartagriculture.R;



public class ControlFragment extends Fragment implements View.OnClickListener {
View view;
Context context;
    LinearLayout linearLayout1,LinearLayout2,LinearLayout3,LinearLayout4,LinearLayout5;
    public ControlFragment(Context context) {
        super();
        this.context = context;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        linearLayout1=view.findViewById(R.id.control1);
        LinearLayout2=view.findViewById(R.id.control2);
        LinearLayout3=view.findViewById(R.id.control3);
        LinearLayout4=view.findViewById(R.id.control4);
        LinearLayout5=view.findViewById(R.id.control5);
        linearLayout1.setOnClickListener(this);
        LinearLayout2.setOnClickListener(this);
        LinearLayout3.setOnClickListener(this);
        LinearLayout4.setOnClickListener(this);
        LinearLayout5.setOnClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_control, container, false);

        }
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.control1:
                Intent intent1=new Intent(context, ControlTemperatureActivity.class);
                startActivity(intent1);
                break;
            case R.id.control2:
                Intent intent=new Intent(context, ControlLightActivity.class);
                startActivity(intent);
                break;
            case R.id.control3:
                Intent intent4=new Intent(context, ControlSoilActivity.class);
                startActivity(intent4);
                break;
            case R.id.control4:
                Intent intent5=new Intent(context, ControlWindActivity.class);
                startActivity(intent5);
                break;
            case R.id.control5:
                Intent intent6=new Intent(context, ControlWindoutActivity.class);
                startActivity(intent6);
                break;

        }
    }
}