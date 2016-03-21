package com.ablanco.teemo.service.base;

import android.content.Context;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class BaseRetrofitServiceClass<T> {

    protected T mHandler;
    protected Context mContext;

    public BaseRetrofitServiceClass(Context context, T handler){
        this.mContext = context;
        this.mHandler = handler;
    }
}
