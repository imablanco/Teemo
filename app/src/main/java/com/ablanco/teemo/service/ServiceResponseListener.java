package com.ablanco.teemo.service;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public interface ServiceResponseListener<T>  {
    void onResponse(T response);
    void onError(Exception e);
}
