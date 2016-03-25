package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public interface MatchListServiceI {

    void getMatchListBySummonerId(Long summonerId, List<String> championIds, List<String> seasons, List<String> rankedQueues, Long beginTime, Long endTime, Integer beginIndex, Integer endIndex, ServiceResponseListener<MatchList> listener);
}
