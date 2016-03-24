package com.ablanco.teemo.persistence.stats;

import com.ablanco.teemo.model.stats.AggregatedStats;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class AggregatedStatsDAO extends BaseComplexReferencedDAO<AggregatedStats> {

    public AggregatedStatsDAO() {
        super(AggregatedStats.class);
    }
}
