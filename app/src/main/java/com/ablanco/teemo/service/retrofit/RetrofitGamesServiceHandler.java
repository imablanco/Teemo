package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.games.RecentGames;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public interface RetrofitGamesServiceHandler {

    @GET("api/lol/{region}/v1.3/game/by-summoner/{summonerId}/recent")
    Call<RecentGames> getRecentGames(@Path("region") String region, @Path("summonerId") long summonerId);
}
