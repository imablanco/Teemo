package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.currentgame.CurrentGameInfo;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public interface CurrentGameInfoServiceI {

    //Get current game information for the given summoner ID. (REST)
    void getCurrentGameInfoByPlatform(String platformId, long summonerId, ServiceResponseListener<CurrentGameInfo> listener);

    void getCurrentGameInfo(long summonerId, ServiceResponseListener<CurrentGameInfo> listener);
}
