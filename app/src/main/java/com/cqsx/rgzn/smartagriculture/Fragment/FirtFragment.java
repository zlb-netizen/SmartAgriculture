package com.cqsx.rgzn.smartagriculture.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.cqsx.rgzn.smartagriculture.Activity.FirstInformatiomActivity;
import com.cqsx.rgzn.smartagriculture.Activity.FirstNotesActivity;
import com.cqsx.rgzn.smartagriculture.Activity.HttpUrlConnectionActivity;
import com.cqsx.rgzn.smartagriculture.Adapter.AboutAdapter;
import com.cqsx.rgzn.smartagriculture.R;

import java.util.ArrayList;
import java.util.List;

/**
t.
 */
public class FirtFragment extends Fragment {
    ViewFlipper vv;
    View view;
    Context context;
    RelativeLayout relativeLayout1,relativeLayout2,relativeLayout3;
    LinearLayout pointLayout;
    ViewPager aboutVp;
    List<View> viewList;   //ViewPager的数据源
    public FirtFragment(Context context) {
        super();
        this.context = context;
    }
    int[] picIds = {R.mipmap.a, R.mipmap.a6, R.mipmap.a6, R.mipmap.a9, R.mipmap.a4};
    private AboutAdapter adapter1;
    List<ImageView> pointList;   //存放显示器小点点的集合
    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
//                接收到消息之后，需要使ViewPager页面向下滑动一页
                int currentItem = aboutVp.getCurrentItem();
                aboutVp.setCurrentItem(currentItem + 1);
                handler.sendEmptyMessageDelayed(1, 3000);
            }
        }
    };

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

        viewList = new ArrayList<>();
        pointList = new ArrayList<>();
//        初始化ViewPager的页面信息1
        for (int i = 0; i < picIds.length; i++) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_aboutvp, null);
            ImageView iv = view.findViewById(R.id.item_aboutvp_iv);
            iv.setImageResource(picIds[i]);
            viewList.add(view);
//            创建指示器内容
            ImageView pointIv = new ImageView(context);
//            在代码中设置控件的宽高和外边距等属性
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.
                    WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0, 20, 0);
//            将布局参数设置给ImageView
            pointIv.setLayoutParams(lp);
            pointIv.setImageResource(R.mipmap.a2);
            pointList.add(pointIv); //添加到集合当中便于统一管理
            pointLayout.addView(pointIv); //添加到布局当中显示出来
        }
        pointList.get(0).setImageResource(R.mipmap.a1);  //设置第一个小圆点为选中状态
//        创建适配器对象
        adapter1 = new AboutAdapter(viewList);
//        设置适配器
        aboutVp.setAdapter(adapter1);
//        发送切换页面消息
        handler.sendEmptyMessageDelayed(1, 3000);
//        设置ViewPager页面监听器
        setVPListener();
    }

    private void initView() {
            aboutVp = view.findViewById(R.id.about_vp);
            pointLayout = view.findViewById(R.id.about_layout_point);
        //img=view.findViewById(R.id.img);
        relativeLayout1=view.findViewById(R.id.first_l);
        relativeLayout2=view.findViewById(R.id.first_2);
        relativeLayout3=view.findViewById(R.id.first_3);
        vv=view.findViewById(R.id.marquee_view);
        vv.addView(View.inflate(context,R.layout.item_addrrs_layout,null));
    }

    private void setVPListener() {
        /* 设置ViewPager的监听器*/
        aboutVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < pointList.size(); i++) {
                    pointList.get(i).setImageResource(R.mipmap.a2);
                }
                pointList.get(position % pointList.size()).setImageResource(R.mipmap.a1);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        relativeLayout1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context, HttpUrlConnectionActivity.class);
               startActivity(intent);
           }
       });
        relativeLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(context, FirstNotesActivity.class);
                startActivity(intent1);
            }
        });
        relativeLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(context, FirstInformatiomActivity.class);
                startActivity(intent3);
            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fragment_firt, container, false);

        }
        return view;
    }


}

