package com.ablanco.teemo.model.teams;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MatchHistorySummary extends BaseObject {

    private int assists;
    private int deaths;
    private int kills;
    private int mapId;
    private int opposingTeamKills;
    private long date;
    private long gameId;
    private String gameMode;
    private String opposingTeamName;
    private boolean invalid;
    private boolean win;

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getOpposingTeamKills() {
        return opposingTeamKills;
    }

    public void setOpposingTeamKills(int opposingTeamKills) {
        this.opposingTeamKills = opposingTeamKills;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
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

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
