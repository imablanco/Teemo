package com.ablanco.teemo.persistence.games;

import com.ablanco.teemo.model.games.Game;
import com.ablanco.teemo.model.games.RawStats;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class RawStatsDAO extends BaseReferencedDAO<RawStats, Game> {

    public RawStatsDAO() {
        super(RawStats.class);
    }
}
