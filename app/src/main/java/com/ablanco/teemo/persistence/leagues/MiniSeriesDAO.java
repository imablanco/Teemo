package com.ablanco.teemo.persistence.leagues;

import com.ablanco.teemo.model.leagues.LeagueEntry;
import com.ablanco.teemo.model.leagues.MiniSeries;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class MiniSeriesDAO extends BaseReferencedDAO<MiniSeries, LeagueEntry> {

    public MiniSeriesDAO() {
        super(MiniSeries.class);
    }

}
