package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public interface TeamsServiceI {

    void getTeamsBySummonersIds(List<String> summonerIds, ServiceResponseListener<Map<String, List<Team>>> listener);
    void getTeamsByTeamIds(List<String> teamIds, ServiceResponseListener<Map<String, Team>> listener);
}
