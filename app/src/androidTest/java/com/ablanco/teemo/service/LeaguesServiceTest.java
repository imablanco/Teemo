package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.leagues.League;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class LeaguesServiceTest extends BaseServiceTest {

    public void testGetAllLeaguesBySummonersWithOnlyEntry(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getLeaguesHandler().getLeaguesBySummoners(Collections.singletonList(TestConstants.SUMMONER_ID_FOR_LEAGUE),true, new ServiceResponseListener<Map<String, List<League>>>() {
                @Override
                public void onResponse(Map<String, List<League>> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
                    assertTrue(response.get(TestConstants.SUMMONER_ID_FOR_LEAGUE).get(0).getEntries().size() == 1);
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

    public void testGetAllLeaguesBySummonersWithAllEntries(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getLeaguesHandler().getLeaguesBySummoners(Collections.singletonList(TestConstants.SUMMONER_ID_FOR_LEAGUE),false, new ServiceResponseListener<Map<String, List<League>>>() {
                @Override
                public void onResponse(Map<String, List<League>> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
                    assertTrue(response.get(TestConstants.SUMMONER_ID_FOR_LEAGUE).get(0).getEntries().size() > 1);
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
