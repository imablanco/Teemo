package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public interface ChampionsServiceI {

    /**
     * Retrieve all champions.
     * @param onlyFreeToPlay
     * @param listener
     */
    void getChampions(boolean onlyFreeToPlay, ServiceResponseListener<ChampionList> listener);


    /**
     * Retrieve champion by ID
     * @param id
     * @param listener
     */
    void getChampionById(long id, ServiceResponseListener<Champion> listener);
}
