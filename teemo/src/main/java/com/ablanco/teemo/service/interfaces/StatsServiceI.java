package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.model.stats.RankedStats;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public interface StatsServiceI {

    void getRankedStatsBySummonerAndSeason(long summonerId, String season, ServiceResponseListener<RankedStats> listener);
    void getPlayerStatsSummaryBySummonerAndSeason(long summonerId, String season, ServiceResponseListener<PlayerStatsSummaryList> listener);
}
