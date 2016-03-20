package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.service.ServiceResponseListener;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public interface ChampionsServiceI {

    void getChallenges(ServiceResponseListener<ChampionList> listener);
}
