package com.ablanco.teemo.persistence.games;

import android.database.Cursor;

import com.ablanco.teemo.model.games.Game;
import com.ablanco.teemo.model.games.RecentGames;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class RecentGamesDAO extends BaseDAO<RecentGames>{

    public RecentGamesDAO() {
        super(RecentGames.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HALF_HOUR; //games have a medium live time of 30 min
    }

    @Override
    public long save(RecentGames object) {
        long id = super.save(object);

        if(id > -1){

            GameDAO gameDAO = new GameDAO();
            List<Game> games = gameDAO.findFromParent(object);

            gameDAO.deleteAll(games);
            gameDAO.saveAll(games, object);
        }

        return id;
    }

    @Override
    public void delete(RecentGames object) {

        GameDAO gameDAO = new GameDAO();
        List<Game> games = gameDAO.findFromParent(object);

        gameDAO.deleteAll(games);

        super.delete(object);
    }

    @Override
    public RecentGames fromCursor(Cursor c) {
        RecentGames object = super.fromCursor(c);


        if(object != null){
            GameDAO gameDAO = new GameDAO();
            object.setGames(gameDAO.findFromParent(object));

        }

        return object;
    }


    public RecentGames finBySummonerId(long summonerId){
        return findFirst("summonerId = ?", new String[]{String.valueOf(summonerId)}, null, null);
    }
}
