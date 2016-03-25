package com.ablanco.teemo.model.matchlist;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchList extends BaseObject {

    private int endIndex;
    private List<MatchReference> matches;
    private int startIndex;
    private int totalGames;

    //search criteria fields
    private String championIds;
    private long beginTime;
    private long endTime;

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public List<MatchReference> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchReference> matches) {
        this.matches = matches;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public String getChampionIds() {
        return championIds;
    }

    public void setChampionIds(String championIds) {
        this.championIds = championIds;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
