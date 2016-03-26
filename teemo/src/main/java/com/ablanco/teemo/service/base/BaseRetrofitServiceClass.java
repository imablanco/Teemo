package com.ablanco.teemo.service.base;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class BaseRetrofitServiceClass<T> {

    protected T mHandler;

    public BaseRetrofitServiceClass(T handler){
        this.mHandler = handler;
    }
}
