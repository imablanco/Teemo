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
    void getSummonerById(String summonerId, ServiceResponseListener<Summoner> listener);
    void getSummonersByNames(List<String> summonerNames, ServiceResponseListener<Map<String, Summoner>> listener);
    void getSummonerByName(String summonerName, ServiceResponseListener<Summoner> listener);
    void getSummonersNamesByIds(List<String> summonerIds, ServiceResponseListener<Map<String, String>> listener);
    void getSummonerNameById(String summonerId, ServiceResponseListener<String> listener);
    void getSummonersMasteryPages(List<String> summonerIds, ServiceResponseListener<Map<String, MasteryPages>> listener);
    void getSummonerMasteryPages(String summonerId, ServiceResponseListener<MasteryPages> listener);
    void getSummonersRunePages(List<String> summonerIds, ServiceResponseListener<Map<String, RunePages>> listener);
    void getSummonerRunePages(String summonerId, ServiceResponseListener<RunePages> listener);
    List<Summoner> findSummonersBySuggestion(String nameSuggestion);

}
