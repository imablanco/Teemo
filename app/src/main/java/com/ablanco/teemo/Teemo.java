package com.ablanco.teemo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.ablanco.teemo.service.ServiceGenerator;
import com.ablanco.teemo.service.handlers.ChampionsServiceHandler;
import com.ablanco.teemo.service.interfaces.ChampionsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitChampionsServiceHandler;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import io.realm.RealmObject;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class Teemo {

    private final String TAG = getClass().getSimpleName();

    private static String API_KEY_PARAM = "api_key";
    private static String META_DATA_API_KEY = "com.ablanco.teemo.apikey";

    private static Teemo mInstance;
    private Retrofit retrofit;
    private ChampionsServiceI mChampionsServiceHandler;

    public static Teemo getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Teemo(context,null,null);
        }

        return mInstance;
    }


    public static void setArmedAndReady(Context context){
        mInstance = new Teemo(context,null,null);
    }

    public static void setArmedAndReady(Context context, String region){
        mInstance = new Teemo(context,null,region);
    }

    public static void setArmedAndReady(Context context, String apiKey, String region){
        mInstance = new Teemo(context,apiKey,region);
    }

    private Teemo(Context context, String apiKey, String region) {


        if(apiKey == null){
            try {
                ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                Bundle bundle = ai.metaData;
                apiKey = bundle.getString(META_DATA_API_KEY);
            } catch (PackageManager.NameNotFoundException | NullPointerException e) {
                throw new IllegalStateException("");
            }
        }

        APIConfigurationContext.API_KEY = apiKey;
        APIConfigurationContext.setRegion(region);

        if(region != null){
            buildRetrofit(context);
        }
    }

    public void setRegion(Context context, String region){
        APIConfigurationContext.setRegion(region);
        buildRetrofit(context);
    }

    private void buildRetrofit(Context context){

        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter(API_KEY_PARAM, APIConfigurationContext.API_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        };

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getDeclaringClass().equals(RealmObject.class);
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(APIConfigurationContext.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        ServiceGenerator mServiceGenerator = new ServiceGenerator(retrofit);

        mChampionsServiceHandler = new ChampionsServiceHandler(context, mServiceGenerator.createService(RetrofitChampionsServiceHandler.class));

    }

    public ChampionsServiceI getChampionsHandler() {
        if(APIConfigurationContext.REGION() == null){
            throw new IllegalStateException("Teemo not initialized, forgot to add region?");
        }
        return mChampionsServiceHandler;
    }

}
