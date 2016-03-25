package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchParticipant extends BaseObject {

    private Integer championId, participantId, spell1Id, spell2Id, teamId;

    private String highestAchievedSeasonTier;
    private List<MatchMastery> masteries;
    private List<MatchRune> runes;
    private ParticipantStats stats;
    private ParticipantTimeline timeline;

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(Integer spell1Id) {
        this.spell1Id = spell1Id;
    }

    public Integer getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(Integer spell2Id) {
        this.spell2Id = spell2Id;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getHighestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
        this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    }

    public List<MatchMastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(List<MatchMastery> masteries) {
        this.masteries = masteries;
    }

    public List<MatchRune> getRunes() {
        return runes;
    }

    public void setRunes(List<MatchRune> runes) {
        this.runes = runes;
    }

    public ParticipantStats getStats() {
        return stats;
    }

    public void setStats(ParticipantStats stats) {
        this.stats = stats;
    }

    public ParticipantTimeline getTimeline() {
        return timeline;
    }

    public void setTimeline(ParticipantTimeline timeline) {
        this.timeline = timeline;
    }
}
