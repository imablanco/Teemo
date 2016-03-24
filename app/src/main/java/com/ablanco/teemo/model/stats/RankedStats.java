package com.ablanco.teemo.model.stats;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RankedStats extends BaseObject {

    private List<ChampionStats> champions;
    private long modifyDate;
    private long summonerId;

    //search criteria fields
    private String season;

    public List<ChampionStats> getChampions() {
        return champions;
    }

    public void setChampions(List<ChampionStats> champions) {
        this.champions = champions;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
