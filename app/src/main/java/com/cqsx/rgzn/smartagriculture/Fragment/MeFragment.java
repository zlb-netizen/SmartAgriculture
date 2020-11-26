package com.cqsx.rgzn.smartagriculture.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cqsx.rgzn.smartagriculture.Activity.RabatActivity;
import com.cqsx.rgzn.smartagriculture.R;


public class MeFragment extends Fragment {

   View view;
   Context context;
   TextView  about_tv_version;
    public MeFragment(Context context) {
        super();
        this.context = context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        intView();
    }

    private void intView() {
        about_tv_version=view.findViewById(R.id.about_tv_version);
        about_tv_version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, RabatActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_me, container, false);

        }
        return view;
    }
    }