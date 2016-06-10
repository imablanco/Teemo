package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.championmastery.ChampionMasteryDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Álvaro Blanco Cabrero on 9/6/16
 * TonsOfDamage
 */
public interface RetrofitChampionMasteryServiceHandler {

    @GET("championmastery/location/{platformId}/player/{playerId}/champion/{championId}")
    Call<ChampionMasteryDto> getChampionMastery(@Path("platformId") String platformId, @Path("playerId") Long playerId, @Path("championId") Long championId);

    @GET("championmastery/location/{platformId}/player/{playerId}/champions")
    Call<List<ChampionMasteryDto>> getChampionsMasteryByPlayer(@Path("platformId") String platformId, @Path("playerId") Long playerId);

    @GET("championmastery/location/{platformId}/player/{playerId}/score")
    Call<Integer> getChampionsMasteryScore(@Path("platformId") String platformId, @Path("playerId") Long playerId);

    @GET("championmastery/location/{platformId}/player/{playerId}/topchampions")
    Call<List<ChampionMasteryDto>> getTopChampionsMastery(@Path("platformId") String platformId, @Path("playerId") Long playerId, @Query("count") Integer count);
}
