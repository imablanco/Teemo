package com.ablanco.teemo.model.currentgame;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class BannedChampion extends BaseObject {

    private long championId;
    private int pickTurn;
    private long teamId;

    public long getChampionId() {
        return championId;
    }

    public void setChampionId(long championId) {
        this.championId = championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }
}
