package com.ablanco.teemo.persistence.leagues;

import android.database.Cursor;

import com.ablanco.teemo.model.leagues.League;
import com.ablanco.teemo.model.leagues.LeagueEntry;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class LeagueDAO extends BaseDAO<League> {

    public LeagueDAO() {
        super(League.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HOUR;
    }

    public long save(League object, String summonerId, boolean onlyEntry) {
        object.setSummonerOrTeamId(summonerId);
        object.setOnlyEntry(onlyEntry);
        long id = super.save(object);

        if(id > -1){

            LeagueEntryDAO leagueEntryDAO = new LeagueEntryDAO();
            List<LeagueEntry> entries = leagueEntryDAO.findFromParent(object);

            leagueEntryDAO.deleteAll(entries);
            leagueEntryDAO.saveAll(object.getEntries(), object);
        }

        return id;
    }

    @Override
    public void delete(League object) {

        LeagueEntryDAO leagueEntryDAO = new LeagueEntryDAO();
        List<LeagueEntry> entries = leagueEntryDAO.findFromParent(object);

        leagueEntryDAO.deleteAll(entries);

        super.delete(object);
    }

    @Override
    public League fromCursor(Cursor c) {
        League league = super.fromCursor(c);

        if(league != null){
            LeagueEntryDAO leagueEntryDAO = new LeagueEntryDAO();
            List<LeagueEntry> entries = leagueEntryDAO.findFromParent(league);

            league.setEntries(entries);
        }

        return league;
    }

    public List<League> findBySummonerOrTeamIdAndOnlyEntry(String summonerId, boolean onlyEntry){
        int convertedValue = onlyEntry ? 1 : 0;
        return find("summonerOrTeamId LIKE ? AND onlyEntry = ?", new String[]{summonerId, String.valueOf(convertedValue)}, null, null);
    }

    // TODO: 23/3/16 future findByTier save manually tier(as it dont comes in the call) and dont save summonerId, that could be the searchCriteria
}
