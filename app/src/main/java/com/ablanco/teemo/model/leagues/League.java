package com.ablanco.teemo.model.leagues;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class League extends BaseObject {

    private List<LeagueEntry> entries;
    private String name;
    private String participantId;
    private String queue;
    private String tier;

    //search criteria
    private String summonerOrTeamId;
    private boolean onlyEntry;

    public List<LeagueEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<LeagueEntry> entries) {
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getSummonerOrTeamId() {
        return summonerOrTeamId;
    }

    public void setSummonerOrTeamId(String summonerOrTeamId) {
        this.summonerOrTeamId = summonerOrTeamId;
    }

    public boolean isOnlyEntry() {
        return onlyEntry;
    }

    public void setOnlyEntry(boolean onlyEntry) {
        this.onlyEntry = onlyEntry;
    }
}

