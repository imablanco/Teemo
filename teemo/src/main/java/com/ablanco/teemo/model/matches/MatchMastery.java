package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchMastery extends BaseObject {

    private Long masteryId, rank;

    public Long getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(Long masteryId) {
        this.masteryId = masteryId;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }
}
