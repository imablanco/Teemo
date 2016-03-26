package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.model.summoners.Summoner;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public interface RetrofitSummonerServiceHandler {

    @GET("api/lol/{region}/v1.4/summoner/by-name/{summonerNames}")
    Call<Map<String, Summoner>> getSummonersByNames(@Path("region") String region, @Path("summonerNames") String summonerNames);

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}")
    Call<Map<String, Summoner>> getSummonersByIds(@Path("region") String region, @Path("summonerIds") String summonerIds);

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}/name")
    Call<Map<String, String>> getSummonersNamesByIds(@Path("region") String region, @Path("summonerIds") String summonerIds);

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}/masteries")
    Call<Map<String, MasteryPages>> getSummonerMasteryPages(@Path("region") String region, @Path("summonerIds") String summonerIds);

    @GET("api/lol/{region}/v1.4/summoner/{summonerIds}/runes")
    Call<Map<String, RunePages>> getSummonerRunePages(@Path("region") String region, @Path("summonerIds") String summonerIds);
}
