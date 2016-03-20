package com.ablanco.teemo.service;

import retrofit2.Retrofit;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ServiceGenerator {

    private Retrofit mRetrofit;

    public ServiceGenerator(Retrofit retrofit){
        this.mRetrofit = retrofit;
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }
}