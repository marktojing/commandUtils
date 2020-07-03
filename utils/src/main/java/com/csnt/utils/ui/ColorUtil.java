package com.csnt.utils.ui;

/**
 * Created by sunrain
 * Created Date 2020/6/9 12:02 AM
 */
public class ColorUtil {
    public static int setAlpha(int percent,int color){
        return ((255*percent/100)<<24)|color;
    }
}
