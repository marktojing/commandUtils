package com.csnt.utils.ui;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * Created by sunrain
 * Created Date 2020/6/19 4:33 PM
 * 获取资源
 */
public class ResourcesUtil {
    /**
     * 通过id获得string
     *
     * @param id 资源ID
     * @return string id对应的string
     */
    public static String getString(Context context,int id) {
        return context.getResources().getString(id);
    }

    /**
     * 获得Resources对象
     *
     * @return resources resources对象
     * @Author: JACK-GU
     * @Date: 2018/4/9 10:16
     * @E-Mail: 528489389@qq.com
     */
    public static Resources getResources(Context context) {
        return context.getResources();
    }

    /**
     * 获得颜色
     *
     * @param id 资源ID
     * @return color 返回颜色，可以直接设置
     */
    public static int getColor(Context context,int id) {
        return context.getResources().getColor(id);
    }

    /**
     * 获得像素，如果是sp不建议这个获取有问题，sp使用#getDimensionValue(int)
     *
     * @param id 资源ID
     * @return px 返回像素,如果xml中单位是px，返回是px，如果是dp或者sp都会转成px
     */
    public static float getPx(Context context,int id) {
        return context.getResources().getDimension(id);
    }

    /**
     * 获取Dimension的值，单位不变，值不变，自己转换
     *
     */
    public static float getDimensionValue(Context context,int id) {
        TypedValue mTmpValue = new TypedValue();
        context.getResources().getValue(id, mTmpValue, true);
        return TypedValue.complexToFloat(mTmpValue.data);
    }
}

