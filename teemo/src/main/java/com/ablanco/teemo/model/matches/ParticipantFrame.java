package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantFrame extends BaseObject {

    private Integer currentGold, jungleMinionsKilled, level, minionsKilled, participantId, totalGold, xp, dominionScore, teamScore;
    private Position position;

    public Integer getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(Integer currentGold) {
        this.currentGold = currentGold;
    }

    public Integer getJungleMinionsKilled() {
        return jungleMinionsKilled;
    }

    public void setJungleMinionsKilled(Integer jungleMinionsKilled) {
        this.jungleMinionsKilled = jungleMinionsKilled;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMinionsKilled() {
        return minionsKilled;
    }

    public void setMinionsKilled(Integer minionsKilled) {
        this.minionsKilled = minionsKilled;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(Integer totalGold) {
        this.totalGold = totalGold;
    }

    public Integer getXp() {
        return xp;
    }

    public void setXp(Integer xp) {
        this.xp = xp;
    }

    public Integer getDominionScore() {
        return dominionScore;
    }

    public void setDominionScore(Integer dominionScore) {
        this.dominionScore = dominionScore;
    }

    public Integer getTeamScore() {
        return teamScore;
    }

    public void setTeamScore(Integer teamScore) {
        this.teamScore = teamScore;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
