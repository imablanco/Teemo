package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.constants.Season;
import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.model.stats.RankedStats;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class StatsServiceTest extends BaseServiceTest {

    public void testRankedStats(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStatsHandler().getRankedStatsBySummonerAndSeason(TestConstants.SUMMONER_ID, Season.SEASON2014, new ServiceResponseListener<RankedStats>() {
                @Override
                public void onResponse(RankedStats response) {
                    assertTrue(response != null);
                    assertTrue(response.getSeason().equals(Season.SEASON2014));
                    assertTrue(response.getSummonerId() == TestConstants.SUMMONER_ID);
                    countDownLatch.countDown();
                }

                @Override
                public void onError(TeemoException e) {
                    assertTrue(false);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void testPlayerSummaryStats(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStatsHandler().getPlayerStatsSummaryBySummonerAndSeason(TestConstants.SUMMONER_ID, Season.SEASON2014, new ServiceResponseListener<PlayerStatsSummaryList>() {
                @Override
                public void onResponse(PlayerStatsSummaryList response) {
                    assertTrue(response != null);
                    assertTrue(response.getSeason().equals(Season.SEASON2014));
                    assertTrue(response.getSummonerId() == TestConstants.SUMMONER_ID);
                    countDownLatch.countDown();
                }

                @Override
                public void onError(TeemoException e) {
                    assertTrue(false);
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
