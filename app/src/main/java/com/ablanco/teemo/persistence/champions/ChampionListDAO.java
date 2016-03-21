package com.ablanco.teemo.persistence.champions;

import android.database.Cursor;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 21/3/16
 * Teemo
 */
public class ChampionListDAO  extends BaseDAO<ChampionList>{

    private final static String CHAMPIONS = "champions";
    private final static String FREE_TO_PLAY = "freeToPlay";

    public ChampionListDAO() {
        super(ChampionList.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_MINUTE;
    }


    @Override
    public long save(ChampionList object) {
        long id = super.save(object);
        if(id > -1){
            ChampionDAO dao = new ChampionDAO();
            List<Champion> champions = dao.findFromParent(object, CHAMPIONS);
            dao.deleteAll(champions);

            dao.saveAll(object.getChampions(), object, CHAMPIONS);
        }

        return id;
    }

    @Override
    public void delete(ChampionList object) {

        ChampionDAO dao = new ChampionDAO();
        List<Champion> champions = dao.findFromParent(object, CHAMPIONS);
        dao.deleteAll(champions);

        super.delete(object);
    }

    @Override
    public ChampionList fromCursor(Cursor c) {
        ChampionList championList =  super.fromCursor(c);

        if(championList != null){
            ChampionDAO dao = new ChampionDAO();
            List<Champion> champions = dao.findFromParent(championList, CHAMPIONS);
            championList.setChampions(champions);
        }

        return championList;

    }

    public ChampionList findByFreeToPlay(boolean freeToPlay){
        int convertedValue = freeToPlay ? 1 : 0;
        List<ChampionList> championLists = find(FREE_TO_PLAY + " = ?", new String[]{String.valueOf(convertedValue)},null,null,null);
        if(!championLists.isEmpty()){
            return championLists.get(0);
        }else {
            return null;
        }
    }
}
