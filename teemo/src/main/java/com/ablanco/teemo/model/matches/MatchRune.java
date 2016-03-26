package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchRune extends BaseObject {
    private Long rank, runeId;

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getRuneId() {
        return runeId;
    }

    public void setRuneId(Long runeId) {
        this.runeId = runeId;
    }
}
