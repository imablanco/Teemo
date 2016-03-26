package com.ablanco.teemo.persistence.stats;

import android.database.Cursor;

import com.ablanco.teemo.model.stats.ChampionStats;
import com.ablanco.teemo.model.stats.RankedStats;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RankedStatsDAO extends BaseDAO<RankedStats> {

    public RankedStatsDAO() {
        super(RankedStats.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HALF_HOUR;
    }

    public long save(RankedStats object, String season) {
        object.setSeason(season);
        long id =  super.save(object);

        if(id > -1){
            ChampionStatsDAO dao = new ChampionStatsDAO();

            List<ChampionStats> championStatses = dao.findFromParent(object);

            dao.deleteAll(championStatses);

            dao.saveAll(object.getChampions(), object);
        }

        return id;
    }

    @Override
    public void delete(RankedStats object) {
        ChampionStatsDAO dao = new ChampionStatsDAO();

        List<ChampionStats> championStatses = dao.findFromParent(object);

        dao.deleteAll(championStatses);

        super.delete(object);
    }

    @Override
    public RankedStats fromCursor(Cursor c) {
        RankedStats rankedStats = super.fromCursor(c);

        if(rankedStats != null){
            ChampionStatsDAO dao = new ChampionStatsDAO();

            List<ChampionStats> championStatses = dao.findFromParent(rankedStats);

            rankedStats.setChampions(championStatses);
        }

        return rankedStats;
    }

    public RankedStats findBySummonerIdandSeason(long summonerId, String season){
        return findFirst("summonerId = ? AND season LIKE ?", new String[]{String.valueOf(summonerId), season}, null,null);
    }
}
