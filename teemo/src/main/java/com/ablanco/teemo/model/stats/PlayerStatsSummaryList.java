package com.ablanco.teemo.model.stats;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class PlayerStatsSummaryList extends BaseObject {

    private List<PlayerStatsSummary> playerStatSummaries;

    private Long summonerId;

    //search criteria fields
    private String season;

    public List<PlayerStatsSummary> getPlayerStatSummaries() {
        return playerStatSummaries;
    }

    public void setPlayerStatSummaries(List<PlayerStatsSummary> playerStatSummaries) {
        this.playerStatSummaries = playerStatSummaries;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

}
