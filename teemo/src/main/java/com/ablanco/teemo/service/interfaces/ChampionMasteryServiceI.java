package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.championmastery.ChampionMasteryDto;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 9/6/16
 * TonsOfDamage
 */
public interface ChampionMasteryServiceI {

    /**
     * Get a champion mastery by player id and champion id. Response code 204 means there were no masteries found for given player id or player id and champion id combination.
     * @param platformId
     * @param playerId
     * @param championId
     * @param listener
     */
    void getChampionMastery(String platformId, Long playerId, Long championId, ServiceResponseListener<ChampionMasteryDto> listener);

    /**
     * Get all champion mastery entries sorted by number of champion points descending
     * @param platformId
     * @param playerId
     * @param listener
     */
    void getChampionsMasteryByPlayer(String platformId, Long playerId, ServiceResponseListener<List<ChampionMasteryDto>> listener);

    /**
     * Get a player's total champion mastery score, which is sum of individual champion mastery levels
     * @param platformId
     * @param playerId
     * @param listener
     */
    void getChampionsMasteryScore(String platformId, Long playerId, ServiceResponseListener<Integer> listener);

    /**
     * Get specified number of top champion mastery entries sorted by number of champion points descending
     * @param platformId
     * @param playerId
     * @param listener
     */
    void getTopChampionsMastery(String platformId, Long playerId, Integer count, ServiceResponseListener<List<ChampionMasteryDto>> listener);
}
