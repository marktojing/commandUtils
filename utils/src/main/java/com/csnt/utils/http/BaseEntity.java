package com.csnt.utils.http;

/**
 * @Author: JACK-GU
 * @Date: 2018/1/12
 * @E-Mail: 528489389@qq.com
 * <p>
 * 基础的entity
 */

public class BaseEntity<T> {
    private String resultInfo;
    private int total;
    private int resultCode;//确定好之后，可以在baseRespiratory里面进行拦截操作
    private T data;
    private T rows;

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public int getResultCode() {
        return resultCode==0?resultCode:-1;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getData() {
        return data == null ? rows : data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
