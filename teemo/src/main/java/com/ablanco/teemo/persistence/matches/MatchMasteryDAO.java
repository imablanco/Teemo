package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.MatchMastery;
import com.ablanco.teemo.model.matches.MatchParticipant;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchMasteryDAO extends BaseReferencedDAO<MatchMastery, MatchParticipant> {

    public MatchMasteryDAO() {
        super(MatchMastery.class);
    }
}
