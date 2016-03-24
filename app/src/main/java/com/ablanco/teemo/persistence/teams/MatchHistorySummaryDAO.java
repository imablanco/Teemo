package com.ablanco.teemo.persistence.teams;

import com.ablanco.teemo.model.teams.MatchHistorySummary;
import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MatchHistorySummaryDAO extends BaseReferencedDAO<MatchHistorySummary, Team> {

    public MatchHistorySummaryDAO() {
        super(MatchHistorySummary.class);
    }

}
