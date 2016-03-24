package com.ablanco.teemo.persistence.stats;

import android.database.Cursor;

import com.ablanco.teemo.model.stats.AggregatedStats;
import com.ablanco.teemo.model.stats.PlayerStatsSummary;
import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class PlayerStatsSummaryDAO extends BaseReferencedDAO<PlayerStatsSummary, PlayerStatsSummaryList> {

    private final static String AGGREGATED_STATS = "aggregatedStats";

    public PlayerStatsSummaryDAO() {
        super(PlayerStatsSummary.class);
    }

    @Override
    public long save(PlayerStatsSummary object, PlayerStatsSummaryList parent) {
        long id = super.save(object, parent);

        if(id > -1){

            AggregatedStatsDAO dao = new AggregatedStatsDAO();

            List<AggregatedStats> aggregatedStatses = dao.findFromParent(object,AGGREGATED_STATS);

            dao.deleteAll(aggregatedStatses);
            dao.save(object.getAggregatedStats(), object, AGGREGATED_STATS);
        }

        return id;
    }

    @Override
    public void delete(PlayerStatsSummary object) {

        AggregatedStatsDAO dao = new AggregatedStatsDAO();

        List<AggregatedStats> aggregatedStatses = dao.findFromParent(object,AGGREGATED_STATS);

        dao.deleteAll(aggregatedStatses);

        super.delete(object);
    }

    @Override
    public PlayerStatsSummary fromCursor(Cursor c) {
        PlayerStatsSummary object =  super.fromCursor(c);

        if(object != null){

            AggregatedStatsDAO dao = new AggregatedStatsDAO();

            AggregatedStats aggregatedStats = dao.findFirstFromParent(object, AGGREGATED_STATS);

            object.setAggregatedStats(aggregatedStats);
        }

        return object;
    }
}
