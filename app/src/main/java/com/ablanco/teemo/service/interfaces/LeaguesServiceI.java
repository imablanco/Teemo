package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.leagues.League;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public interface LeaguesServiceI {

    void getLeaguesBySummoners(List<String> summoners, boolean onlyEntry, ServiceResponseListener<Map<String, List<League>>> listener);
    void getLeaguesByTeams(List<String> teams,boolean onlyEntry, ServiceResponseListener<Map<String, List<League>>> listener);
    void getChallengerLeagues(ServiceResponseListener<League> listener);
    void getMasterLeagues(ServiceResponseListener<League> listener);

}
