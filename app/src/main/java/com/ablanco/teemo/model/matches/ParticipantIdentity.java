package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantIdentity extends BaseObject {


    private Integer participantId;
    private MatchPlayer player;

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public MatchPlayer getPlayer() {
        return player;
    }

    public void setPlayer(MatchPlayer player) {
        this.player = player;
    }
}
