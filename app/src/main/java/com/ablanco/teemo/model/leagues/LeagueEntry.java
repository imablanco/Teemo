package com.ablanco.teemo.model.leagues;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class LeagueEntry extends BaseObject {

    private String division;
    private Boolean isFreshBlood;
    private Boolean isHotStreak;
    private Boolean isInactive;
    private Boolean isVeteran;
    private Integer leaguePoints;
    private Integer losses;
    private MiniSeries miniSeries;
    private String playerOrTeamId;
    private String playerOrTeamName;
    private Integer wins;

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Boolean isFreshBlood() {
        return isFreshBlood;
    }

    public void setIsFreshBlood(Boolean isFreshBlood) {
        this.isFreshBlood = isFreshBlood;
    }

    public Boolean isHotStreak() {
        return isHotStreak;
    }

    public void setIsHotStreak(Boolean isHotStreak) {
        this.isHotStreak = isHotStreak;
    }

    public Boolean isInactive() {
        return isInactive;
    }

    public void setIsInactive(Boolean isInactive) {
        this.isInactive = isInactive;
    }

    public Boolean isVeteran() {
        return isVeteran;
    }

    public void setIsVeteran(Boolean isVeteran) {
        this.isVeteran = isVeteran;
    }

    public Integer getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(Integer leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public MiniSeries getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeries miniSeries) {
        this.miniSeries = miniSeries;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }
}
