package com.cqsx.rgzn.smartagriculture.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;

import com.cqsx.rgzn.smartagriculture.Fragment.ControlFragment;
import com.cqsx.rgzn.smartagriculture.Fragment.FirtFragment;
import com.cqsx.rgzn.smartagriculture.Fragment.MeFragment;
import com.cqsx.rgzn.smartagriculture.Fragment.TestFragment;
import com.cqsx.rgzn.smartagriculture.R;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    Context context;
    RadioGroup mainButton;
    //声明四个按钮对应的Fragment对象
    Fragment fristFrg,controlFrg,testFrg,meFrg;
    private FragmentManager Manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
       // ActionBar actionBar=getActionBar();
       // actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33000000")));

        mainButton=findViewById(R.id.mian_button);
        //设置点击了那个单选按钮
        mainButton.setOnCheckedChangeListener(this);
        //创建碎片对象
        fristFrg=new FirtFragment(this);
        controlFrg=new ControlFragment(this);
        testFrg=new TestFragment(this);
        meFrg=new MeFragment(this);
        //将四个Fragment进行动态加载，一起加载到布局中，方法1：replace  方法2：add/hide/show
        addFragment();
    }





    /**
     * 将主页中的碎片添加到布局中，有用的显示，无用的影藏。
     * 将4个Fragment进行动态加载的方法：
     *          1、创建碎片管理者对象
     *          2、创建碎片处理事务的对象
     *          3、将4个Fragment统一进行添加到布局中
     *          4、将后面3个Fragment影藏
     *          5、提交碎片改变后的事务
     * */

    private void addFragment() {
        //1.创建碎片管理者对象
        Manager= getSupportFragmentManager();
        //2.创建碎片处理事务的对象
        FragmentTransaction transaction=Manager.beginTransaction();
        //3.将4个Fragment统一添加到布局中
        transaction.add(R.id.main_layout_top,fristFrg);
        transaction.add(R.id.main_layout_top,controlFrg);
        transaction.add(R.id.main_layout_top,testFrg);
        transaction.add(R.id.main_layout_top,meFrg);
        //4.将后面3个Fragment隐藏
        transaction.hide(controlFrg);
        transaction.hide(testFrg);
        transaction.hide(meFrg);
        //5.提交碎片改变后的事务
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //   创建碎片处理事务的对象
        FragmentTransaction transaction=Manager.beginTransaction();
        switch (checkedId){
            case R.id.main_button_first:
                //隐藏后三个Fragment
                transaction.hide(controlFrg);
                transaction.hide(testFrg);
                transaction.hide(meFrg);
                //显示第一个
                transaction.show(fristFrg);
                break;
            case R.id.main_button_control:
                transaction.hide(fristFrg);
                transaction.hide(testFrg);
                transaction.hide(meFrg);
                transaction.show(controlFrg);
                break;
            case R.id.main_button_test:
                transaction.hide(controlFrg);
                transaction.hide(fristFrg);
                transaction.hide(meFrg);
                transaction.show(testFrg);
                break;
            case R.id.main_button_me:
                transaction.hide(testFrg);
                transaction.hide(controlFrg);
                transaction.hide(fristFrg);
                transaction.show(meFrg);
                break;
        }
        transaction.commit();

    }
}
