package com.ablanco.teemo.model.stats;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class ChampionStats extends BaseObject {

    //id 0 represent the combined stats for all champions
    private Integer id;

    private AggregatedStats stats;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AggregatedStats getStats() {
        return stats;
    }

    public void setStats(AggregatedStats stats) {
        this.stats = stats;
    }
}
