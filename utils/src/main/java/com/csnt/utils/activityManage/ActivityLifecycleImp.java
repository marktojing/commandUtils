package com.csnt.utils.activityManage;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.csnt.utils.app.ClassUtil;
import com.csnt.utils.log.LogUtil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Created by sunrain
 * Created Date 2020/6/18 11:00 AM
 */
public class ActivityLifecycleImp implements Application.ActivityLifecycleCallbacks {
    private static ActivityLifecycleImp instance;
    public static ActivityLifecycleImp getInstance(){
        if(instance==null){
            instance=new ActivityLifecycleImp();
        }
        return instance;
    }
    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        //这里入栈
        AppManager.getAppManager().addActivity(activity);
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostResumed(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPrePaused(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        //这里出栈
        AppManager.getAppManager().finishActivity(activity);
        LogUtil.d(ClassUtil.getClassName(activity));
    }

    /**
     *
     * ------------------------------以上就是activity的整个生命周期-----------------------------------
     * @param activity
     * @param savedInstanceState
     */


    @Override
    public void onActivityPreCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }

    @Override
    public void onActivityPreStarted(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostStarted(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }

    @Override
    public void onActivityPreResumed(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostStopped(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostPaused(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }

    @Override
    public void onActivityPreStopped(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPreSaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostSaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }

    @Override
    public void onActivityPreDestroyed(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }
    @Override
    public void onActivityPostDestroyed(@NonNull Activity activity) {
        LogUtil.d(ClassUtil.getClassName(activity));
    }

}
