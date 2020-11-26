package com.cqsx.rgzn.smartagriculture.Activity;

import android.app.Application;


import org.xutils.DbManager;
import org.xutils.x;

public class UniteAPP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);

    }
}

