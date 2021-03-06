package com.ablanco.teemo.model.stats;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class PlayerStatsSummary extends BaseObject {

    private AggregatedStats aggregatedStats;
    private Integer losses;
    private Long modifyDate;

    /**
     * Legal values {@link com.ablanco.teemo.constants.PlayerStatSummaryType}
     */
    private String playerStatSummaryType;

    public AggregatedStats getAggregatedStats() {
        return aggregatedStats;
    }

    public void setAggregatedStats(AggregatedStats aggregatedStats) {
        this.aggregatedStats = aggregatedStats;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public void setPlayerStatSummaryType(String playerStatSummaryType) {
        this.playerStatSummaryType = playerStatSummaryType;
    }
}
