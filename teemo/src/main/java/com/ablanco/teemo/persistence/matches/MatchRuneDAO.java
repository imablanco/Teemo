package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.MatchParticipant;
import com.ablanco.teemo.model.matches.MatchRune;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchRuneDAO extends BaseReferencedDAO<MatchRune, MatchParticipant> {

    public MatchRuneDAO() {
        super(MatchRune.class);
    }
}
