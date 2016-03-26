package com.ablanco.teemo.model.games;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class Player extends BaseObject {

    private Integer championId;
    private Long summonerId;
    private Integer teamId;

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
