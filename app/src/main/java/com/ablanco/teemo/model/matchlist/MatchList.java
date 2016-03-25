package com.ablanco.teemo.model.matchlist;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchList extends BaseObject {

    private Integer endIndex;
    private List<MatchReference> matches;
    private Integer startIndex;
    private Integer totalGames;

    //search criteria fields
    private String championIds;
    private long begIntegerime;
    private long endTime;

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public List<MatchReference> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchReference> matches) {
        this.matches = matches;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Integer totalGames) {
        this.totalGames = totalGames;
    }

    public String getChampionIds() {
        return championIds;
    }

    public void setChampionIds(String championIds) {
        this.championIds = championIds;
    }

    public long getBegIntegerime() {
        return begIntegerime;
    }

    public void setBegIntegerime(long begIntegerime) {
        this.begIntegerime = begIntegerime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
