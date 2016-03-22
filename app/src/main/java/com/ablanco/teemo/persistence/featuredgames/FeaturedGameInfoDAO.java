package com.ablanco.teemo.persistence.featuredgames;

import com.ablanco.teemo.model.common.BannedChampion;
import com.ablanco.teemo.model.featuredgames.FeaturedGameInfo;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.common.BannedChampionDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class FeaturedGameInfoDAO extends BaseDAO<FeaturedGameInfo>{

    private static final String BANNED_CHAMPIONS = "bannedChampioms";

    public FeaturedGameInfoDAO() {
        super(FeaturedGameInfo.class);
    }

    @Override
    public long save(FeaturedGameInfo object) {
        long id = super.save(object);

        if(id > -1){

            BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
            List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);
            bannedChampionDAO.deleteAll(bannedChampions);
            bannedChampionDAO.saveAll(bannedChampions);


        }

        return id;
    }
}
