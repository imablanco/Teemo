package com.ablanco.teemo.persistence.summoners;

import com.ablanco.teemo.model.summoners.Summoner;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class SummonerDAO extends BaseDAO<Summoner> {

    public SummonerDAO() {
        super(Summoner.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HALF_HOUR;

    }

    public Summoner findByName(String name){
        return findFirst("name LIKE ?", new String[]{name}, null, null);
    }

    public Summoner findById(long id){
        return findFirst("id = ?", new String[]{String.valueOf(id)}, null, null);
    }

    public List<Summoner> findBySuggestion(String suggestion){
        String suggestionFormatted = suggestion.concat("%");
        return find("name LIKE ?", new String[]{suggestionFormatted}, null, null);
    }
}
