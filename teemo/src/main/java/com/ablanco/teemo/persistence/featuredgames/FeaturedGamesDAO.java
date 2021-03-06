package com.ablanco.teemo.persistence.featuredgames;

import android.database.Cursor;

import com.ablanco.teemo.model.featuredgames.FeaturedGameInfo;
import com.ablanco.teemo.model.featuredgames.FeaturedGames;
import com.ablanco.teemo.persistence.base.BaseDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class FeaturedGamesDAO  extends BaseDAO<FeaturedGames>{

    public FeaturedGamesDAO() {
        super(FeaturedGames.class);
    }

    @Override
    public long save(FeaturedGames object) {
        long id = super.save(object);

        if(id > -1){
            //expirationTime = object.getClientRefreshInterval();

            FeaturedGameInfoDAO featuredGameInfoDAO = new FeaturedGameInfoDAO();
            List<FeaturedGameInfo> featuredGameInfos = featuredGameInfoDAO.findAll();

            featuredGameInfoDAO.deleteAll(featuredGameInfos);
            featuredGameInfoDAO.saveAll(object.getGameList());
        }

        return id;
    }

    @Override
    public void delete(FeaturedGames object) {

        FeaturedGameInfoDAO featuredGameInfoDAO = new FeaturedGameInfoDAO();
        List<FeaturedGameInfo> featuredGameInfos = featuredGameInfoDAO.findAll();

        featuredGameInfoDAO.deleteAll(featuredGameInfos);

        super.delete(object);

    }

    @Override
    public FeaturedGames fromCursor(Cursor c) {
        FeaturedGames featuredGames =  super.fromCursor(c);

        if(featuredGames != null){
            FeaturedGameInfoDAO featuredGameInfoDAO = new FeaturedGameInfoDAO();
            List<FeaturedGameInfo> featuredGameInfos = featuredGameInfoDAO.findAll();
            featuredGames.setGameList(featuredGameInfos);
        }

        return featuredGames;
    }

    public boolean hasExpired(FeaturedGames obj) {
        //as it is not specified in the API reference, we gonna take client refresh interval as seconds
        return System.currentTimeMillis() - obj.getLastUpdate().getTime() > obj.getClientRefreshInterval()*1000;
    }
}
