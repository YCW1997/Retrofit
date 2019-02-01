package com.yuan.retrofit;

import android.support.annotation.Keep;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2019/2/1 0001.
 */

@Keep
public class BaseResponse<T> {
    public int errorCode = 0;
    public String errorMsg = "";//错误消息
    public T data;
}