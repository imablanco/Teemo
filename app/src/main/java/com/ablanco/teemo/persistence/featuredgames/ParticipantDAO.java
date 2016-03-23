package com.ablanco.teemo.persistence.featuredgames;

import com.ablanco.teemo.model.featuredgames.FeaturedGameInfo;
import com.ablanco.teemo.model.featuredgames.Participant;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class ParticipantDAO extends BaseReferencedDAO<Participant, FeaturedGameInfo> {

    public ParticipantDAO() {
        super(Participant.class);
    }
}
