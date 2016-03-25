package com.ablanco.teemo.persistence.summoners;

import com.ablanco.teemo.model.summoners.Summoner;
import com.ablanco.teemo.persistence.base.BaseDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class SummonerDAO extends BaseDAO<Summoner> {

    public SummonerDAO() {
        super(Summoner.class);
    }

    public Summoner findByName(String name){
        return findFirst("name LIKE ?", new String[]{name}, null, null);
    }

    public Summoner findById(long id){
        return findFirst("id = ?", new String[]{String.valueOf(id)}, null, null);
    }
}
