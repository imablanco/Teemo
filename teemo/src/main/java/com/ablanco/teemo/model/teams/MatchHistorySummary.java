package com.ablanco.teemo.model.teams;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MatchHistorySummary extends BaseObject {

    private Integer assists;
    private Integer deaths;
    private Integer kills;
    private Integer mapId;
    private Integer opposingTeamKills;
    private Long date;
    private Long gameId;
    private String gameMode;
    private String opposingTeamName;
    private Boolean invalid;
    private Boolean win;

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getOpposingTeamKills() {
        return opposingTeamKills;
    }

    public void setOpposingTeamKills(Integer opposingTeamKills) {
        this.opposingTeamKills = opposingTeamKills;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getOpposingTeamName() {
        return opposingTeamName;
    }

    public void setOpposingTeamName(String opposingTeamName) {
        this.opposingTeamName = opposingTeamName;
    }

    public Boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public Boolean isWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }
}
