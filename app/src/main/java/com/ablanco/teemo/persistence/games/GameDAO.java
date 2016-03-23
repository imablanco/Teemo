package com.ablanco.teemo.persistence.games;

import android.database.Cursor;

import com.ablanco.teemo.model.games.Game;
import com.ablanco.teemo.model.games.Player;
import com.ablanco.teemo.model.games.RawStats;
import com.ablanco.teemo.model.games.RecentGames;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class GameDAO extends BaseReferencedDAO<Game, RecentGames> {

    public GameDAO() {
        super(Game.class);
    }

    @Override
    public long save(Game object, RecentGames parent) {
        long id = super.save(object,parent);

        if(id > -1){

            PlayerDAO playerDAO = new PlayerDAO();
            List<Player> players = playerDAO.findFromParent(object);

            playerDAO.deleteAll(players);
            playerDAO.saveAll(object.getFellowPlayers(), object);

            RawStatsDAO rawStatsDAO = new RawStatsDAO();
            List<RawStats> rawStats = rawStatsDAO.findFromParent(object);
            rawStatsDAO.deleteAll(rawStats);
            rawStatsDAO.save(object.getStats(), object);

        }

        return id;
    }

    @Override
    public void delete(Game object) {

        PlayerDAO playerDAO = new PlayerDAO();
        List<Player> players = playerDAO.findFromParent(object);

        playerDAO.deleteAll(players);

        RawStatsDAO rawStatsDAO = new RawStatsDAO();
        List<RawStats> rawStats = rawStatsDAO.findFromParent(object);
        rawStatsDAO.deleteAll(rawStats);

        super.delete(object);
    }

    @Override
    public Game fromCursor(Cursor c) {

        Game object =  super.fromCursor(c);

        if(object != null){
            PlayerDAO playerDAO = new PlayerDAO();
            object.setFellowPlayers(playerDAO.findFromParent(object));

            RawStatsDAO rawStatsDAO = new RawStatsDAO();
            object.setStats(rawStatsDAO.findFirstFromParent(object));
        }

        return object;
    }
}
