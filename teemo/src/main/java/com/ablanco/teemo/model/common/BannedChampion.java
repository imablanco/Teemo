package com.ablanco.teemo.model.common;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class BannedChampion extends BaseObject {

    private Long championId;
    private Integer pickTurn;
    private Long teamId;

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public Integer getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(Integer pickTurn) {
        this.pickTurn = pickTurn;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

}
