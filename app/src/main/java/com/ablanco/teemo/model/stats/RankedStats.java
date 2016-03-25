package com.ablanco.teemo.model.stats;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RankedStats extends BaseObject {

    private List<ChampionStats> champions;
    private Long modifyDate;
    private Long summonerId;

    //search criteria fields
    private String season;

    public List<ChampionStats> getChampions() {
        return champions;
    }

    public void setChampions(List<ChampionStats> champions) {
        this.champions = champions;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
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
