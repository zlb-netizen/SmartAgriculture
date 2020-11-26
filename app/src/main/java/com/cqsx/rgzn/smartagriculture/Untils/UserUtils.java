package com.cqsx.rgzn.smartagriculture.Untils;

import com.cqsx.rgzn.smartagriculture.R;

import java.util.ArrayList;
import java.util.List;



public class UserUtils {
    private static final String[] name = { "Co2浓度", "光照强度", "土壤指数", "温度" };
    private static final String[] name1 = { "Co2浓度", "光照强度", "土壤指数", "温度"};
    private static final String[] set = { "设定值：200", "设定值：300", "设定值：100", "设定值：300"};
    private static final String[]  number = {"200","300","200","350"};
    private static final int[] photo = {R.mipmap.tree1, R.mipmap.tree1, R.mipmap.tree1,
            R.mipmap.tree1 };


    public static List<User> getAllList(){
        List<User>list = new ArrayList<>();
        for (int i = 0;i<name.length ; i++) {
            User bean = new User(photo[i],name[i],name1[i]);
            list.add(bean);
        }
        return list;
    }
}


