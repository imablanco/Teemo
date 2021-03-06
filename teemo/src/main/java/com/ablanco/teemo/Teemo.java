package com.ablanco.teemo;

import android.content.Context;

import com.ablanco.teemo.persistence.base.DBContext;
import com.ablanco.teemo.service.base.ServiceGenerator;
import com.ablanco.teemo.service.handlers.ChampionMasteryServiceHandler;
import com.ablanco.teemo.service.handlers.ChampionsServiceHandler;
import com.ablanco.teemo.service.handlers.CurrentGameInfoServiceHandler;
import com.ablanco.teemo.service.handlers.FeaturedGamesServiceHandler;
import com.ablanco.teemo.service.handlers.GamesServiceHandler;
import com.ablanco.teemo.service.handlers.LeaguesServiceHandler;
import com.ablanco.teemo.service.handlers.MatchListServiceHandler;
import com.ablanco.teemo.service.handlers.MatchesServiceHandler;
import com.ablanco.teemo.service.handlers.StaticDataServiceHandler;
import com.ablanco.teemo.service.handlers.StatsServiceHandler;
import com.ablanco.teemo.service.handlers.StatusServiceHandler;
import com.ablanco.teemo.service.handlers.SummonersServiceHandler;
import com.ablanco.teemo.service.handlers.TeamsServiceHandler;
import com.ablanco.teemo.service.interfaces.ChampionMasteryServiceI;
import com.ablanco.teemo.service.interfaces.ChampionsServiceI;
import com.ablanco.teemo.service.interfaces.CurrentGameInfoServiceI;
import com.ablanco.teemo.service.interfaces.FeaturedGamesServiceI;
import com.ablanco.teemo.service.interfaces.GamesServiceI;
import com.ablanco.teemo.service.interfaces.LeaguesServiceI;
import com.ablanco.teemo.service.interfaces.MatchListServiceI;
import com.ablanco.teemo.service.interfaces.MatchesServiceI;
import com.ablanco.teemo.service.interfaces.StaticDataServiceI;
import com.ablanco.teemo.service.interfaces.StatsServiceI;
import com.ablanco.teemo.service.interfaces.StatusServiceI;
import com.ablanco.teemo.service.interfaces.SummonerServiceI;
import com.ablanco.teemo.service.interfaces.TeamsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitChampionMasteryServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitChampionsServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitCurrentGameInfoServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitFeaturedGamesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitGamesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitLeaguesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitMatchListServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitMatchesServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitStaticDataServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitStatsServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitStatusServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitSummonerServiceHandler;
import com.ablanco.teemo.service.retrofit.RetrofitTeamsServiceHandler;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class Teemo {

    private final static String API_KEY_PARAM = "api_key";

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
    private StatusServiceI mStatusHandler;
    private StaticDataServiceI mStaticDataHandler;
    private ChampionMasteryServiceI mChampionMasteryHandler;

    private Converter.Factory converterFactory =  GsonConverterFactory.create();

    private Interceptor apiInterceptor = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            HttpUrl url = request.url().newBuilder().addQueryParameter(API_KEY_PARAM, APIConfigurationContext.API_KEY).build();
            request = request.newBuilder().url(url).build();
            return chain.proceed(request);
        }
    };

    private OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(apiInterceptor).build();

    public static Teemo getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Teemo(context,null,null);
        }

        return mInstance;
    }


    public static void setArmedAndReady(Context context, String apiKey){
        mInstance = new Teemo(context,apiKey,null);
    }

    public static void setArmedAndReady(Context context, String apiKey, String region){
        mInstance = new Teemo(context,apiKey,region);
    }

    private Teemo(Context context, String apiKey, String region) {


        if(apiKey == null){
            throw new IllegalStateException("API key can not be null");
        }
        
        APIConfigurationContext.API_KEY = apiKey;
        APIConfigurationContext.setRegion(region);

        DBContext.initDb(context);

        buildStatusRetrofit();

        if(region != null){
            buildStaticRetrofit();
            buildAPIRetrofit();
        }
    }

    public void setRegion(String region){
        APIConfigurationContext.setRegion(region);
        buildAPIRetrofit();
        buildStaticRetrofit();
    }

    private void buildStatusRetrofit(){
        Retrofit retrofitStatus = new Retrofit.Builder()
                .baseUrl(APIConfigurationContext.STATUS_BASE_URL)
                .addConverterFactory(converterFactory)
                .build();

        ServiceGenerator serviceGenerator = new ServiceGenerator(retrofitStatus);

        mStatusHandler = new StatusServiceHandler(serviceGenerator.createService(RetrofitStatusServiceHandler.class));
    }

    private void buildStaticRetrofit(){
        Retrofit retrofitStatic = new Retrofit.Builder()
                .baseUrl(APIConfigurationContext.STATIC_BASE_URL)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build();

        ServiceGenerator serviceGenerator = new ServiceGenerator(retrofitStatic);

        mStaticDataHandler = new StaticDataServiceHandler(serviceGenerator.createService(RetrofitStaticDataServiceHandler.class));

    }

    private void buildAPIRetrofit(){

        Retrofit retrofitAPI = new Retrofit.Builder()
                .baseUrl(APIConfigurationContext.BASE_URL)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build();

        ServiceGenerator serviceGenerator = new ServiceGenerator(retrofitAPI);

        mChampionsHandler = new ChampionsServiceHandler(serviceGenerator.createService(RetrofitChampionsServiceHandler.class));
        mCurrentGameInfoHandler = new CurrentGameInfoServiceHandler(serviceGenerator.createService(RetrofitCurrentGameInfoServiceHandler.class));
        mFeaturedGamesHandler = new FeaturedGamesServiceHandler(serviceGenerator.createService(RetrofitFeaturedGamesServiceHandler.class));
        mGamesHandler = new GamesServiceHandler(serviceGenerator.createService(RetrofitGamesServiceHandler.class));
        mLeaguesHandler = new LeaguesServiceHandler(serviceGenerator.createService(RetrofitLeaguesServiceHandler.class));
        mStatsHandler = new StatsServiceHandler(serviceGenerator.createService(RetrofitStatsServiceHandler.class));
        mTeamsHandler = new TeamsServiceHandler(serviceGenerator.createService(RetrofitTeamsServiceHandler.class));
        mSummonersHandler = new SummonersServiceHandler(serviceGenerator.createService(RetrofitSummonerServiceHandler.class));
        mMatchListHandler = new MatchListServiceHandler(serviceGenerator.createService(RetrofitMatchListServiceHandler.class));
        mMatchesHandler = new MatchesServiceHandler(serviceGenerator.createService(RetrofitMatchesServiceHandler.class));
        mChampionMasteryHandler = new ChampionMasteryServiceHandler(serviceGenerator.createService(RetrofitChampionMasteryServiceHandler.class));
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

    public StaticDataServiceI getStaticDataHandler(){
        checkRegion();
        return mStaticDataHandler;
    }

    public ChampionMasteryServiceI getChampionMasteryHandler(){
        checkRegion();
        return mChampionMasteryHandler;
    }

    public StatusServiceI getStatusHandler(){
        return mStatusHandler;
    }
}
