package com.ablanco.teemo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.ablanco.teemo.persistence.base.DBContext;
import com.ablanco.teemo.service.base.ServiceGenerator;
import com.ablanco.teemo.service.handlers.ChampionsServiceHandler;
import com.ablanco.teemo.service.handlers.CurrentGameInfoServiceHandler;
import com.ablanco.teemo.service.handlers.FeaturedGamesServiceHandler;
import com.ablanco.teemo.service.handlers.GamesServiceHandler;
import com.ablanco.teemo.service.handlers.LeaguesServiceHandler;
import com.ablanco.teemo.service.handlers.MatchListServiceHandler;
import com.ablanco.teemo.service.handlers.MatchesServiceHandler;
import com.ablanco.teemo.service.handlers.ShardsServiceHandler;
import com.ablanco.teemo.service.handlers.StatsServiceHandler;
import com.ablanco.teemo.service.handlers.SummonersServiceHandler;
import com.ablanco.teemo.service.handlers.TeamsServiceHandler;
import com.ablanco.teemo.service.interfaces.ChampionsServiceI;
import com.ablanco.teemo.service.interfaces.CurrentGameInfoServiceI;
import com.ablanco.teemo.service.interfaces.FeaturedGamesServiceI;
import com.ablanco.teemo.service.interfaces.GamesServiceI;
import com.ablanco.teemo.service.interfaces.LeaguesServiceI;
import com.ablanco.teemo.service.interfaces.MatchListServiceI;
import com.ablanco.teemo.service.interfaces.MatchesServiceI;
import com.ablanco.teemo.service.interfaces.ShardsServiceI;
import com.ablanco.teemo.service.interfaces.StatsServiceI;
import com.ablanco.teemo.service.interfaces.SummonerServiceI;
import com.ablanco.teemo.service.interfaces.TeamsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitChampionsServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitCurrentGameInfoServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitFeaturedGamesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitGamesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitLeaguesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitMatchListServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitMatchesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitShardsServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitStatsServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitSummonerServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitTeamsServiceHandler;

import java.io.IOException;

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

    private final static String API_KEY_PARAM = "api_key";
    private final static String META_DATA_API_KEY = "com.ablanco.teemo.apikey";

    private static Teemo mInstance;

    private ChampionsServiceI mChampionsHandler;
    private CurrentGameInfoServiceI mCurrentGameInfoHandler;
    private FeaturedGamesServiceI mFeaturedGamesHandler;
    private GamesServiceI mGamesHandler;
    private LeaguesServiceI mLeaguesHandler;
    private StatsServiceI mStatsHandler;
    private TeamsServiceI mTeamsHandler;
    private SummonerServiceI mSummonersHandler;
    private MatchListServiceI mMatchListHandler;
    private MatchesServiceI mMatchesHandler;
    private ShardsServiceI mShardsHandler;

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

        DBContext.initDb(context);

        buildStatusRetrofit();

        if(region != null){
            buildAPIRetrofit();
        }
    }

    public void setRegion(String region){
        APIConfigurationContext.setRegion(region);
        buildAPIRetrofit();
    }

    private void buildStatusRetrofit(){
        Retrofit statusAPI = new Retrofit.Builder()
                .baseUrl(APIConfigurationContext.STATUS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServiceGenerator mServiceGenerator = new ServiceGenerator(statusAPI);

        mShardsHandler = new ShardsServiceHandler(mServiceGenerator.createService(RetrofitShardsServiceHandler.class));

    }

    private void buildAPIRetrofit(){

        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder().addQueryParameter(API_KEY_PARAM, APIConfigurationContext.API_KEY).build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        };

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        Retrofit retrofitAPI = new Retrofit.Builder()
                .baseUrl(APIConfigurationContext.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        ServiceGenerator mServiceGenerator = new ServiceGenerator(retrofitAPI);

        mChampionsHandler = new ChampionsServiceHandler(mServiceGenerator.createService(RetrofitChampionsServiceHandler.class));
        mCurrentGameInfoHandler = new CurrentGameInfoServiceHandler(mServiceGenerator.createService(RetrofitCurrentGameInfoServiceHandler.class));
        mFeaturedGamesHandler = new FeaturedGamesServiceHandler(mServiceGenerator.createService(RetrofitFeaturedGamesServiceHandler.class));
        mGamesHandler = new GamesServiceHandler(mServiceGenerator.createService(RetrofitGamesServiceHandler.class));
        mLeaguesHandler = new LeaguesServiceHandler(mServiceGenerator.createService(RetrofitLeaguesServiceHandler.class));
        mStatsHandler = new StatsServiceHandler(mServiceGenerator.createService(RetrofitStatsServiceHandler.class));
        mTeamsHandler = new TeamsServiceHandler(mServiceGenerator.createService(RetrofitTeamsServiceHandler.class));
        mSummonersHandler = new SummonersServiceHandler(mServiceGenerator.createService(RetrofitSummonerServiceHandler.class));
        mMatchListHandler = new MatchListServiceHandler(mServiceGenerator.createService(RetrofitMatchListServiceHandler.class));
        mMatchesHandler = new MatchesServiceHandler(mServiceGenerator.createService(RetrofitMatchesServiceHandler.class));
    }

    private void checkRegion(){
        if(APIConfigurationContext.REGION == null){
            throw new IllegalStateException("Teemo not initialized, forgot to add region?");
        }
    }

    public ChampionsServiceI getChampionsHandler() {
        checkRegion();
        return mChampionsHandler;
    }

    public CurrentGameInfoServiceI getCurrentGameInfoHandler() {
        checkRegion();
        return mCurrentGameInfoHandler;
    }

    public FeaturedGamesServiceI getFeaturedGamesHandler(){
        checkRegion();
        return mFeaturedGamesHandler;
    }

    public GamesServiceI getGamesHandler(){
        checkRegion();
        return mGamesHandler;
    }

    public LeaguesServiceI getLeaguesHandler(){
        checkRegion();
        return mLeaguesHandler;
    }

    public StatsServiceI getStatsHandler(){
        checkRegion();
        return mStatsHandler;
    }

    public TeamsServiceI getTeamsHandler(){
        checkRegion();
        return mTeamsHandler;
    }

    public SummonerServiceI getSummonersHandler(){
        checkRegion();
        return mSummonersHandler;
    }

    public MatchListServiceI getMatchListHandler(){
        checkRegion();
        return mMatchListHandler;
    }

    public MatchesServiceI getMatchesHandler(){
        checkRegion();
        return mMatchesHandler;
    }

    public ShardsServiceI getShardsHandler(){
        checkRegion();
        return mShardsHandler;
    }
}
