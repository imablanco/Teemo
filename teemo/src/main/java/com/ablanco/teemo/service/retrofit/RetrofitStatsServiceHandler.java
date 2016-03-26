package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.model.stats.RankedStats;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public interface RetrofitStatsServiceHandler  {

    @GET("api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/ranked")
    Call<RankedStats> getRankedStatsBySummoner(@Path("region") String region, @Path("summonerId") long summonerId, @Query("season") String season);

    @GET("api/lol/{region}/v1.3/stats/by-summoner/{summonerId}/summary")
    Call<PlayerStatsSummaryList> getPlayerStatsSummaryBySummoner(@Path("region") String region, @Path("summonerId") long summonerId, @Query("season") String season);
}
