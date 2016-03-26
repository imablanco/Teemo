package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchTeam extends BaseObject {

    private List<MatchBannedChampion> bans;
    private Integer baronKills, dragonKills, inhibitorKills, riftHeraldKills, teamId, towerKills, vilemawKills;
    private Long dominionVictoryScore;
    private Boolean firstBaron, firstBlood, firstDragon, firstInhibitor, firstRiftHerald, firstTower, winner;

    public List<MatchBannedChampion> getBans() {
        return bans;
    }

    public void setBans(List<MatchBannedChampion> bans) {
        this.bans = bans;
    }

    public Integer getBaronKills() {
        return baronKills;
    }

    public void setBaronKills(Integer baronKills) {
        this.baronKills = baronKills;
    }

    public Integer getDragonKills() {
        return dragonKills;
    }

    public void setDragonKills(Integer dragonKills) {
        this.dragonKills = dragonKills;
    }

    public Integer getInhibitorKills() {
        return inhibitorKills;
    }

    public void setInhibitorKills(Integer inhibitorKills) {
        this.inhibitorKills = inhibitorKills;
    }

    public Integer getRiftHeraldKills() {
        return riftHeraldKills;
    }

    public void setRiftHeraldKills(Integer riftHeraldKills) {
        this.riftHeraldKills = riftHeraldKills;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getTowerKills() {
        return towerKills;
    }

    public void setTowerKills(Integer towerKills) {
        this.towerKills = towerKills;
    }

    public Integer getVilemawKills() {
        return vilemawKills;
    }

    public void setVilemawKills(Integer vilemawKills) {
        this.vilemawKills = vilemawKills;
    }

    public Long getDominionVictoryScore() {
        return dominionVictoryScore;
    }

    public void setDominionVictoryScore(Long dominionVictoryScore) {
        this.dominionVictoryScore = dominionVictoryScore;
    }

    public Boolean getFirstBaron() {
        return firstBaron;
    }

    public void setFirstBaron(Boolean firstBaron) {
        this.firstBaron = firstBaron;
    }

    public Boolean getFirstBlood() {
        return firstBlood;
    }

    public void setFirstBlood(Boolean firstBlood) {
        this.firstBlood = firstBlood;
    }

    public Boolean getFirstDragon() {
        return firstDragon;
    }

    public void setFirstDragon(Boolean firstDragon) {
        this.firstDragon = firstDragon;
    }

    public Boolean getFirstInhibitor() {
        return firstInhibitor;
    }

    public void setFirstInhibitor(Boolean firstInhibitor) {
        this.firstInhibitor = firstInhibitor;
    }

    public Boolean getFirstRiftHerald() {
        return firstRiftHerald;
    }

    public void setFirstRiftHerald(Boolean firstRiftHerald) {
        this.firstRiftHerald = firstRiftHerald;
    }

    public Boolean getFirstTower() {
        return firstTower;
    }

    public void setFirstTower(Boolean firstTower) {
        this.firstTower = firstTower;
    }

    public Boolean getWinner() {
        return winner;
    }

    public void setWinner(Boolean winner) {
        this.winner = winner;
    }
}
