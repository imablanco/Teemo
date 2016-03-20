package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.champions.ChampionList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public interface RetrofitChampionsServiceHandler {

    @GET("api/lol/{region}/v1.2/champion")
    Call<ChampionList> getChallenges(@Path("region") String region);
}
