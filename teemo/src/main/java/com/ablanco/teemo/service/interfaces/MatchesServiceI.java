package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public interface MatchesServiceI {

    void getMatch(long matchId, boolean includeTimeline, ServiceResponseListener<MatchDetail> listener);
}
