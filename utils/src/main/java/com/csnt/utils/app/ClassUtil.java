package com.csnt.utils.app;

import android.app.Activity;

/**
 * Created by sunrain
 * Created Date 2020/6/18 1:19 PM
 */
public class ClassUtil {
    public static StackTraceElement getMethodName(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if(stackTrace.length>3){
            return new StackTraceElement(
                    stackTrace[3].getClassName(),
                    stackTrace[3].getMethodName(),
                    stackTrace[3].getFileName(),
                    stackTrace[3].getLineNumber()
                    );
        }
        return null;
    }
    public static String getClassName(Activity activity){
        return activity.getLocalClassName();
    }

}
