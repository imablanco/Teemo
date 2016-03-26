package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.leagues.League;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public interface RetrofitLeaguesServiceHandler {

    @GET("api/lol/{region}/v2.5/league/by-summoner/{summonerIds}")
    Call<Map<String, List<League>>> getLeaguesBySummonersWithAllEntries(@Path("region") String region, @Path("summonerIds") String summonerIds);

    @GET("api/lol/{region}/v2.5/league/by-summoner/{summonerIds}/entry")
    Call<Map<String, List<League>>> getLeaguesBySummonersWithOnlyOwnEntries(@Path("region") String region, @Path("summonerIds") String summonerIds);

    @GET("api/lol/{region}/v2.5/league/by-team/{teamIds}")
    Call<Map<String, List<League>>> getLeaguesByTeamsWithAllEntries(@Path("region") String region, @Path("teamIds") String teamIds);

    @GET("api/lol/{region}/v2.5/league/by-team/{teamIds}/entry")
    Call<Map<String, List<League>>> getActiveLeaguesByTeamsWithOnlyOwnEntries(@Path("region") String region, @Path("teamIds") String teamIds);

    @GET("api/lol/{region}/v2.5/league/challenger")
    Call<League> getChallengerLeagues(@Path("region") String region);

    @GET("api/lol/{region}/v2.5/league/master")
    Call<League> getMasterLeagues(@Path("region") String region);

}
