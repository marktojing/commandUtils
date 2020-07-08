package com.csnt.utils.http.interceptor;


import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * -
 *
 */
public abstract class AddParamsInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        RequestBody requestBody = oldRequest.body();
        Request.Builder requestBuilder = oldRequest.newBuilder();

        //这里可以对头部进行处理
        // requestBuilder.header("APIKEY", Constant.API_KEY);

        if (requestBody instanceof FormBody) {
            //表单的话
            FormBody.Builder newFormBody = new FormBody.Builder();
            FormBody oldFormBody = (FormBody) oldRequest.body();
            for (int i = 0; i < oldFormBody.size(); i++) {
                newFormBody.addEncoded(oldFormBody.encodedName(i)
                        , oldFormBody.encodedValue(i));
            }
            //添加固定参数,注意，重复都有可能,这个参数是int也用string包裹，应该会自己转
            //newFormBody.add("page","2");
            setUserInfo();
//            if (AppConfig.userInfoEntity != null) {
//                newFormBody.add("userToken", AppConfig.userInfoEntity.getUserToken());
//                newFormBody.add("userId", AppConfig.userInfoEntity.getUserId());
//            }
            setUserInfo();

            requestBuilder.method(oldRequest.method(), newFormBody.build());
        } else if (requestBody instanceof MultipartBody) {
            MultipartBody.Builder newFormBody = new MultipartBody.Builder();
            MultipartBody oldFormBody = (MultipartBody) oldRequest.body();
            for (MultipartBody.Part part : oldFormBody.parts()) {
                newFormBody.addPart(part);
            }
            //添加固定参数
            //newFormBody.addFormDataPart("name", "李四");
            setUserInfo();
//            if (AppConfig.userInfoEntity != null) {
//                newFormBody.addFormDataPart("userToken", AppConfig.userInfoEntity.getUserToken());
//                newFormBody.addFormDataPart("userId", AppConfig.userInfoEntity.getUserId());
//            }
            requestBuilder.method(oldRequest.method(), newFormBody.build());
        }

        return chain.proceed(requestBuilder.build());
    }

    protected abstract void setUserInfo();
}
