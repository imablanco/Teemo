package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.teams.Team;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public interface RetrofitTeamsServiceHandler {

    @GET("api/lol/{region}/v2.4/team/by-summoner/{summonerIds}")
    Call<Map<String, List<Team>>> getTeamsBySummonersIds(@Path("region") String region, @Path("summonerIds") String summonerIds);

    @GET("api/lol/{region}/v2.4/team/{teamIds}")
    Call<Map<String, Team>> getTeamsByTeamIds(@Path("region") String region, @Path("teamIds") String teamIds);
}
