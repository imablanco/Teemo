package com.ablanco.teemo.service.retrofit;


import com.ablanco.teemo.model.currentgames.CurrentGameInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public interface RetrofitCurrentGameInfoServiceHandler {

    @GET("/observer-mode/rest/consumer/getSpectatorGameInfo/{platformId}/{summonerId}")
    Call<CurrentGameInfo> getCurrentGameInfo(@Path("platformId") String platformId,@Path("summonerId") long summonerId);
}
