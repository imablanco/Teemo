package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.MatchBannedChampion;
import com.ablanco.teemo.model.matches.MatchTeam;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchBannedChampionDAO extends BaseReferencedDAO<MatchBannedChampion, MatchTeam> {

    public MatchBannedChampionDAO() {
        super(MatchBannedChampion.class);
    }
}
