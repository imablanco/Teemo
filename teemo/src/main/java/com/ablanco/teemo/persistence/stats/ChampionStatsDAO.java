package com.ablanco.teemo.persistence.stats;

import android.database.Cursor;

import com.ablanco.teemo.model.stats.AggregatedStats;
import com.ablanco.teemo.model.stats.ChampionStats;
import com.ablanco.teemo.model.stats.RankedStats;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class ChampionStatsDAO extends BaseReferencedDAO<ChampionStats, RankedStats>{

    private final static String AGGREGATED_STATS = "aggregatedStats";

    public ChampionStatsDAO() {
        super(ChampionStats.class);
    }

    @Override
    public long save(ChampionStats object, RankedStats parent) {
        long id =  super.save(object, parent);

        if(id > -1){
            AggregatedStatsDAO dao = new AggregatedStatsDAO();

            List<AggregatedStats> aggregatedStatses = dao.findFromParent(object,AGGREGATED_STATS);

            dao.deleteAll(aggregatedStatses);
            dao.save(object.getStats(), object, AGGREGATED_STATS);
        }

        return id;

    }

    @Override
    public void delete(ChampionStats object) {
        AggregatedStatsDAO dao = new AggregatedStatsDAO();

        List<AggregatedStats> aggregatedStatses = dao.findFromParent(object,AGGREGATED_STATS);

        dao.deleteAll(aggregatedStatses);

        super.delete(object);
    }

    @Override
    public ChampionStats fromCursor(Cursor c) {
        ChampionStats object =  super.fromCursor(c);

        if(object != null){

            AggregatedStatsDAO dao = new AggregatedStatsDAO();

            AggregatedStats aggregatedStats = dao.findFirstFromParent(object, AGGREGATED_STATS);

            object.setStats(aggregatedStats);
        }

        return object;
    }
}
