package com.csnt.utils.activityManage;

import android.app.Activity;

/**
 * Created by sunrain
 * Created Date 2020/6/18 2:43 PM
 */
public class ActivityTaskManage {
    private static volatile ActivityTaskManage instance;
    public static ActivityTaskManage getInstance(){
        if(instance==null){
            synchronized (ActivityTaskManage.class){
                if(instance==null){
                    instance=new ActivityTaskManage();
                }
            }
        }
        return instance;
    }
    private void addActivity(Activity activity){

    }
}
