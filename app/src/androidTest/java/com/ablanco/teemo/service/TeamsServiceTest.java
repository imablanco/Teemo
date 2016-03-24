package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamsServiceTest extends BaseServiceTest {

    public void testGetTeamsBysummoners(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getTeamsHandler().getTeamsBySummonersIds(Collections.singletonList(TestConstants.SUMMONER_ID_STRING), new ServiceResponseListener<Map<String, List<Team>>>() {
                @Override
                public void onResponse(Map<String, List<Team>> response) {
                    assertTrue(response != null);
                    for (Map.Entry<String, List<Team>> entry : response.entrySet()){
                        for (Team team : entry.getValue()){
                            assertTrue(entry.getKey().equals(team.getSummonerId()));
                        }
                    }
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

    public void testGetTeamsTeamIds(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getTeamsHandler().getTeamsByTeamIds(Collections.singletonList(TestConstants.TEAM_ID), new ServiceResponseListener<Map<String, Team>>() {
                @Override
                public void onResponse(Map<String, Team> response) {
                    assertTrue(response != null);
                    for (Map.Entry<String, Team> entry : response.entrySet()){
                        assertTrue(entry.getKey().equals(entry.getValue().getFullId()));
                    }

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
