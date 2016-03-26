package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.model.summoners.Summoner;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public interface SummonerServiceI {

    void getSummonersByIds(List<String> summonerIds, ServiceResponseListener<Map<String, Summoner>> listener);
    void getSummonersByNames(List<String> summonerNames, ServiceResponseListener<Map<String, Summoner>> listener);
    void getSummonersNamesByIds(List<String> summonerIds, ServiceResponseListener<Map<String, String>> listener);
    void getSummonerMasteryPages(List<String> summonerIds, ServiceResponseListener<Map<String, MasteryPages>> listener);
    void getSummonerRunePages(List<String> summonerIds, ServiceResponseListener<Map<String, RunePages>> listener);

}
