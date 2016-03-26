package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.matchlist.MatchList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public interface RetrofitMatchListServiceHandler {

    @GET("api/lol/{region}/v2.2/matchlist/by-summoner/{summonerId}")
    Call<MatchList> getMatchListBySummonerId(@Path("region") String region,
                                             @Path("summonerId") Long summonerId,
                                             @Query("championIds") String championIds,
                                             @Query("rankedQueues") String rankedQueues,
                                             @Query("seasons") String seasons,
                                             @Query("beginTime") Long beginTime,
                                             @Query("endTime") Long endTime,
                                             @Query("beginIndex") Integer beginIndex,
                                             @Query("endIndex") Integer endIndex);
}
