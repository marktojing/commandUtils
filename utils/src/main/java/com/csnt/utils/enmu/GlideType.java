package com.csnt.utils.enmu;

/**
 * Created by sunrain
 * Created Date 2020/6/19 4:13 PM
 * 设置加载图片的方式，不作处理，圆形的或者是圆角,这个是只作用于加载的资源，不作用于imageView，也就是说占位符是不影响的
 */

public enum GlideType {
    NORMAL,
    CIRCLE,
    ROUND,
    centerCrop,
    fitCenter,
    centerInside,
}
