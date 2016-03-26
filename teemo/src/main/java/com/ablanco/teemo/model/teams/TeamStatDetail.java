package com.ablanco.teemo.model.teams;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamStatDetail extends BaseObject {

    private Integer averageGamesPlayed;
    private Integer losses;
    private Integer wins;
    private String teamStatType;

    public Integer getAverageGamesPlayed() {
        return averageGamesPlayed;
    }

    public void setAverageGamesPlayed(Integer averageGamesPlayed) {
        this.averageGamesPlayed = averageGamesPlayed;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public String getTeamStatType() {
        return teamStatType;
    }

    public void setTeamStatType(String teamStatType) {
        this.teamStatType = teamStatType;
    }
}
