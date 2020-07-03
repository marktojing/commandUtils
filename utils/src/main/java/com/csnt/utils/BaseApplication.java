package com.csnt.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.csnt.utils.activityManage.ActivityLifecycleImp;

/**
 * Created by sunrain
 * Created Date 2020/6/18 10:24 AM
 */
@SuppressLint("Registered")
public class BaseApplication extends Application {
    private static BaseApplication instance;
    public static Context getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        registerActivityLifecycleCallbacks(ActivityLifecycleImp.getInstance());
    }
}
