package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.MatchPlayer;
import com.ablanco.teemo.model.matches.ParticipantIdentity;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchPlayerDAO extends BaseReferencedDAO<MatchPlayer, ParticipantIdentity> {


    public MatchPlayerDAO() {
        super(MatchPlayer.class);
    }
}
