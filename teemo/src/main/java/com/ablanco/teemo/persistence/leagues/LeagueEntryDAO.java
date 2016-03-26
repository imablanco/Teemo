package com.ablanco.teemo.persistence.leagues;

import android.database.Cursor;

import com.ablanco.teemo.model.leagues.League;
import com.ablanco.teemo.model.leagues.LeagueEntry;
import com.ablanco.teemo.model.leagues.MiniSeries;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class LeagueEntryDAO extends BaseReferencedDAO<LeagueEntry, League> {

    public LeagueEntryDAO() {
        super(LeagueEntry.class);
    }


    @Override
    public long save(LeagueEntry object, League parent) {
        long id =  super.save(object, parent);

        if(id > -1){
            MiniSeriesDAO miniSeriesDAO = new MiniSeriesDAO();
            MiniSeries miniSeries = miniSeriesDAO.findFirstFromParent(object);

            miniSeriesDAO.delete(miniSeries);
            miniSeriesDAO.save(object.getMiniSeries(), object);
        }

        return id;
    }

    @Override
    public void delete(LeagueEntry object) {

        MiniSeriesDAO miniSeriesDAO = new MiniSeriesDAO();
        MiniSeries miniSeries = miniSeriesDAO.findFirstFromParent(object);

        miniSeriesDAO.delete(miniSeries);

        super.delete(object);
    }

    @Override
    public LeagueEntry fromCursor(Cursor c) {
        LeagueEntry object = super.fromCursor(c);

        if(object != null){
            MiniSeriesDAO miniSeriesDAO = new MiniSeriesDAO();
            object.setMiniSeries(miniSeriesDAO.findFirstFromParent(object));
        }

        return object;
    }
}
