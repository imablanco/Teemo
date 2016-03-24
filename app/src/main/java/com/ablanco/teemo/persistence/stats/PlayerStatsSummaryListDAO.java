package com.ablanco.teemo.persistence.stats;

import android.database.Cursor;

import com.ablanco.teemo.model.stats.PlayerStatsSummary;
import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.persistence.base.BaseDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class PlayerStatsSummaryListDAO extends BaseDAO<PlayerStatsSummaryList> {

    public PlayerStatsSummaryListDAO() {
        super(PlayerStatsSummaryList.class);
    }

    public long save(PlayerStatsSummaryList object, String season) {

        object.setSeason(season);

        long id = super.save(object);

        if(id > -1){
            PlayerStatsSummaryDAO dao = new PlayerStatsSummaryDAO();

            List<PlayerStatsSummary> playerStatsSummaries = dao.findFromParent(object);

            dao.deleteAll(playerStatsSummaries);

            dao.saveAll(object.getPlayerStatSummaries(), object);
        }

        return id;
    }

    @Override
    public void delete(PlayerStatsSummaryList object) {
        PlayerStatsSummaryDAO dao = new PlayerStatsSummaryDAO();

        List<PlayerStatsSummary> playerStatsSummaries = dao.findFromParent(object);

        dao.deleteAll(playerStatsSummaries);

        super.delete(object);
    }

    @Override
    public PlayerStatsSummaryList fromCursor(Cursor c) {
        PlayerStatsSummaryList playerStatsSummaryList =  super.fromCursor(c);

        if (playerStatsSummaryList != null){
            PlayerStatsSummaryDAO dao = new PlayerStatsSummaryDAO();

            List<PlayerStatsSummary> playerStatsSummaries = dao.findFromParent(playerStatsSummaryList);

            playerStatsSummaryList.setPlayerStatSummaries(playerStatsSummaries);
        }

        return playerStatsSummaryList;
    }

    public PlayerStatsSummaryList findBySummonerIdandSeason(long summonerId, String season){
        return findFirst("summonerId = ? AND season LIKE ?", new String[]{String.valueOf(summonerId), season}, null,null);
    }
}
