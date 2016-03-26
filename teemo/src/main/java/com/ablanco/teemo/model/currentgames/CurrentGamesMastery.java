package com.ablanco.teemo.model.currentgames;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class CurrentGamesMastery extends BaseObject {

    private Long masteryId;
    private Integer rank;

    public Long getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(Long masteryId) {
        this.masteryId = masteryId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
