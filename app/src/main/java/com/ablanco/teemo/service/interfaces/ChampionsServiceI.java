package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public interface ChampionsServiceI {

    void getChampions(ServiceResponseListener<ChampionList> listener);
}
