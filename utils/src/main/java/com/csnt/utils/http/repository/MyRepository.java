package com.csnt.utils.http.repository;


import com.csnt.utils.http.BaseEntity;
import com.csnt.utils.http.RetrofitHelper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;

/**
 * 响应,T表示最后需要的数据，不用创建那么多的repository，T为需要获取的实体类，不需要包装BaseEntity
 * <p>
 * 建议使用这个来进行网络请求，上次文件，已经完成封装了
 * <p>
 * 普通请求：get
 * <p>
 * 上传文件：uploadFile
 * <p>
 * 列表操作：getList
 * <p>
 * 弃用：2018年7月24日
 *
 * @Author: JACK-GU
 * @Date: 2018-06-12 10:21
 * @E-Mail: 528489389@qq.com
 */
public class MyRepository<T> extends BaseRepository<T> {
    //默认的方法名字,可以少传一个参数，最好是保持一致的
    private final static String DEFAULT_METHOD_NAME = "get";

    /**
     * 开始请求,返回必须是BaseEntity<T>
     *
     * @param serviceClass service的class
     * @param methodName   service的方法名字
     * @param params       参数
     * @Author: JACK-GU
     * @E-Mail: 528489389@qq.com
     */
    public Observable<T> get(Class serviceClass, String methodName, Map<String, Object> params) {
        Observable<T> rObservable = null;
        try {
            Object o = RetrofitHelper.getInstance().createService(serviceClass);
            Method declaredMethod = o.getClass().getDeclaredMethod(methodName, HashMap.class);
            Observable<BaseEntity<T>> baseEntityObservable = (Observable<BaseEntity<T>>)
                    declaredMethod.invoke(o, params);
            rObservable = transformResult(baseEntityObservable);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return rObservable;
        }
    }


    /**
     * 开始请求，配合refreshHelper,你也可以在这里设置total,会自动添加一个参数，叫page
     * ,返回必须是BaseEntity<T>
     *
     * @param serviceClass  service的class
     * @param methodName    service的方法名字
     * @param params        参数
     * @Author: JACK-GU
     * @E-Mail: 528489389@qq.com
     */
    public Observable<T> getList(Class serviceClass, String methodName, Map<String, Object> params
                                ) {
        Observable<T> rObservable = null;
        try {
            Object o = RetrofitHelper.getInstance().createService(serviceClass);
            Method declaredMethod = o.getClass().getDeclaredMethod(methodName, HashMap.class);
            Observable<BaseEntity<T>> baseEntityObservable = (Observable<BaseEntity<T>>)
                    declaredMethod.invoke(o, params);
            rObservable = transformResult(baseEntityObservable);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return rObservable;
        }
    }


    /**
     * 开始请求,返回必须是BaseEntity<T>
     * <p>
     * MultipartBody.Part part = MultipartBodyHelper.transform("", "header");
     * MultipartBody multipartBody = new MultipartBody.Builder()
     * .setType(MultipartBody.FORM) //设置为表单格式
     * .addPart(part) //添加文件参数
     * .addFormDataPart("name", "王麻子") //添加普通参数
     * .build();
     * <p>
     * 定义service的时候
     * <p>
     * \@Multipart
     * <p>
     * \@POST("UserCenter/UpdateUserHeader.ashx")
     * <p>
     * Observable<BaseEntity<UserInfo>> get(@PartMap HashMap<String, RequestBody> params)
     * <p>
     * </p>
     *
     * @param serviceClass service的class
     * @param methodName   service的方法名字
     * @param params       参数，这个适合传文件的时候使用
     * @Author: JACK-GU
     * @E-Mail: 528489389@qq.com
     */
    public Observable<T> uploadFile(Class serviceClass, String methodName,
                                    Map<String, RequestBody> params) {
        Observable<T> rObservable = null;
        try {
            Object o = RetrofitHelper.getInstance().createService(serviceClass);
            Method declaredMethod = o.getClass().getDeclaredMethod(methodName, HashMap.class);
            Observable<BaseEntity<T>> baseEntityObservable = (Observable<BaseEntity<T>>)
                    declaredMethod.invoke(o, params);
            rObservable = transformResult(baseEntityObservable);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return rObservable;
        }
    }


    /**
     * 开始请求,返回必须是BaseEntity<T>,默认的service方法：请看DEFAULT_METHOD_NAME
     *
     * @param serviceClass service的class
     * @param params       参数
     * @Author: JACK-GU
     * @E-Mail: 528489389@qq.com
     */
    public Observable<T> get(Class serviceClass, Map<String, Object> params) {
        Observable<T> rObservable = null;
        try {
            Object o = RetrofitHelper.getInstance().createService(serviceClass);
            Method declaredMethod = o.getClass().getDeclaredMethod(DEFAULT_METHOD_NAME,
                    HashMap.class);
            Observable<BaseEntity<T>> baseEntityObservable = (Observable<BaseEntity<T>>)
                    declaredMethod.invoke(o, params);
            rObservable = transformResult(baseEntityObservable);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return rObservable;
        }
    }


    /**
     * 开始请求，配合refreshHelper,你也可以在这里设置total,会自动添加一个参数，叫page
     * ,返回必须是BaseEntity<T>,默认的service方法：请看DEFAULT_METHOD_NAME
     *
     * @param serviceClass  service的class
     * @param params        参数
     * @Author: JACK-GU
     * @E-Mail: 528489389@qq.com
     */
    public Observable<T> getList(Class serviceClass, Map<String, Object> params
                                ) {
        Observable<T> rObservable = null;
        try {
            Object o = RetrofitHelper.getInstance().createService(serviceClass);
            Method declaredMethod = o.getClass().getDeclaredMethod(DEFAULT_METHOD_NAME, HashMap.class);
            Observable<BaseEntity<T>> baseEntityObservable = (Observable<BaseEntity<T>>)
                    declaredMethod.invoke(o, params);
            rObservable = transformResult(baseEntityObservable);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } finally {
            return rObservable;
        }
    }
}
