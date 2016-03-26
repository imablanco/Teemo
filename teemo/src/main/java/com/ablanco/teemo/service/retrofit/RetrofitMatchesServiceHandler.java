package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.matches.MatchDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public interface RetrofitMatchesServiceHandler {

    @GET("api/lol/{region}/v2.2/match/{matchId}")
    Call<MatchDetail> getMatch(@Path("region") String region, @Path("matchId") long matchId, @Query("includeTimeline") boolean includeTimeline);
}
