package com.csnt.utils.http;


import android.accounts.NetworkErrorException;

import com.google.gson.JsonSyntaxException;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * 默认的订阅者，最好是用这个，好统一管理
 *
 * @Author: JACK-GU
 * @Date: 2018/1/18
 * @E-Mail: 528489389@qq.com
 */
public abstract class DefaultSubscriber<T> implements Observer<T> {

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
           String reason = "";
        int code = -1;
        if (e instanceof JsonSyntaxException) {//数据格式化错误
            reason = "数据格式化错误";
        } else if (e instanceof HttpException) {// http异常
            reason = "HTTP异常";
        } else if (e instanceof UnknownHostException || e instanceof ConnectException)
        {//未连接网络或DNS错误
            reason = "未连接网络或DNS错误";
        } else if (e instanceof NetworkErrorException) {
            reason = "网络错误";
        } else if (e instanceof SocketException || e instanceof SocketTimeoutException) {
            reason = "连接超时";
        }  else if (e instanceof CodeException) {
            reason = e.getMessage();
            code = ((CodeException) e).getCode();
        } else {
            reason = "未知错误:"+e.getMessage();
        }
        e.printStackTrace();
        _onError(reason);
        _onErrorCode(reason, code);
//        ToastUtil.showShortMessage(reason);
    }

    @Override
    public void onSubscribe(Disposable d) {
    }

    @Override
    public void onNext(T entity) {
        //这里可以拦截判断，服务器的成功与否
        _onNext(entity);
    }

    public abstract void _onNext(T entity);

    public abstract void _onError(String msg);

    public void _onErrorCode(String msg, int code) {

    }
}
