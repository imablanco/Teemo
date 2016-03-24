package com.ablanco.teemo.model;

import com.ablanco.teemo.model.leagues.League;
import com.ablanco.teemo.model.leagues.LeagueEntry;
import com.ablanco.teemo.model.leagues.MiniSeries;
import com.ablanco.teemo.persistence.leagues.LeagueDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class LeagueModelTest extends BaseModelTest {

    public void testLeague(){

        League league = new League();

        List<LeagueEntry> entries = new ArrayList<>();

        LeagueEntry leagueEntry = new LeagueEntry();

        leagueEntry.setMiniSeries(new MiniSeries());

        entries.add(leagueEntry);

        league.setEntries(entries);

        LeagueDAO leagueDAO = new LeagueDAO();

        leagueDAO.save(league, "1", true);

        List<League>  leagues= leagueDAO.findBySummonerOrTeamIdAndOnlyEntry("1",true);

        assertTrue(!leagues.isEmpty());
        assertTrue(!leagues.get(0).getEntries().isEmpty());

        assertTrue(leagues.get(0).getEntries().get(0).getMiniSeries() != null);

        leagueDAO.deleteAll(leagues);

        assertTrue(leagueDAO.findBySummonerOrTeamIdAndOnlyEntry("1",true).isEmpty());
    }
}
