package com.csnt.utils.http.service;


import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @Author: JACK-GU
 * @Date: 2017-07-12
 * @E-Mail: 528489389@qq.com
 */
public interface LoginService<T> {
    @FormUrlEncoded
    @POST("json.action")
    Observable<T> login(@FieldMap HashMap<String, Object> params);
}
