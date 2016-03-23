package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.games.RecentGames;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public interface GamesServiceI {

    //Get recent games by summoner ID.
    void getRecentGames(long summonerId, ServiceResponseListener<RecentGames> listener);
}
