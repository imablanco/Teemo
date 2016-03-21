package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.model.champions.ChampionList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public interface RetrofitChampionsServiceHandler {

    @GET("api/lol/{region}/v1.2/champion")
    Call<ChampionList> getChampions(@Path("region") String region, @Query("freeToPlay") boolean freeToPlay);

    @GET("api/lol/{region}/v1.2/champion/{id}")
    Call<Champion> getChampionById(@Path("region") String region,@Path("id") long id);
}
