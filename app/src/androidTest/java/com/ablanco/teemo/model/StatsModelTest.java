package com.ablanco.teemo.model;

import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.constants.Seasons;
import com.ablanco.teemo.model.stats.AggregatedStats;
import com.ablanco.teemo.model.stats.ChampionStats;
import com.ablanco.teemo.model.stats.PlayerStatsSummary;
import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.model.stats.RankedStats;
import com.ablanco.teemo.persistence.stats.PlayerStatsSummaryListDAO;
import com.ablanco.teemo.persistence.stats.RankedStatsDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class StatsModelTest extends BaseModelTest{

    public void testRankedStats(){

        RankedStats rankedStats = new RankedStats();
        rankedStats.setSummonerId(TestConstants.SUMMONER_ID);

        List<ChampionStats> championStatses = new ArrayList<>();

        ChampionStats championStats= new ChampionStats();
        AggregatedStats aggregatedStats = new AggregatedStats();
        aggregatedStats.setAverageAssists(30);

        championStats.setStats(aggregatedStats);
        championStatses.add(championStats);

        rankedStats.setChampions(championStatses);

        RankedStatsDAO rankedStatsDAO = new RankedStatsDAO();

        rankedStatsDAO.save(rankedStats, Seasons.SEASON2016);

        rankedStats = rankedStatsDAO.findBySummonerIdandSeason(TestConstants.SUMMONER_ID, Seasons.SEASON2016);
        assertTrue(rankedStats != null);
        assertTrue(!rankedStats.getChampions().isEmpty());
        assertTrue(rankedStats.getChampions().size() == 1);
        assertTrue(rankedStats.getChampions().get(0).getStats().getAverageAssists() == 30);
    }

    public void testPlayerStatsSummaryList(){

        PlayerStatsSummaryList playerStatsSummaryList = new PlayerStatsSummaryList();
        playerStatsSummaryList.setSummonerId(TestConstants.SUMMONER_ID);

        List<PlayerStatsSummary> playerStatsSummaries = new ArrayList<>();

        PlayerStatsSummary playerStatsSummary= new PlayerStatsSummary();
        AggregatedStats aggregatedStats = new AggregatedStats();
        aggregatedStats.setAverageAssists(30);

        playerStatsSummary.setAggregatedStats(aggregatedStats);
        playerStatsSummaries.add(playerStatsSummary);

        playerStatsSummaryList.setPlayerStatSummaries(playerStatsSummaries);

        PlayerStatsSummaryListDAO dao = new PlayerStatsSummaryListDAO();

        dao.save(playerStatsSummaryList, Seasons.SEASON2016);

        playerStatsSummaryList = dao.findBySummonerIdandSeason(TestConstants.SUMMONER_ID, Seasons.SEASON2016);
        assertTrue(playerStatsSummaryList != null);
        assertTrue(!playerStatsSummaryList.getPlayerStatSummaries().isEmpty());
        assertTrue(playerStatsSummaryList.getPlayerStatSummaries().size() == 1);
        assertTrue(playerStatsSummaryList.getPlayerStatSummaries().get(0).getAggregatedStats().getAverageAssists() == 30);
    }
}
