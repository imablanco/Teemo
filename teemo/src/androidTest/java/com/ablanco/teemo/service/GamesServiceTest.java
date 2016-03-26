package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.games.RecentGames;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class GamesServiceTest extends BaseServiceTest {

    public void testGetRecentGames(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getGamesHandler().getRecentGames(TestConstants.SUMMONER_ID, new ServiceResponseListener<RecentGames>() {
                @Override
                public void onResponse(RecentGames response) {
                    assertTrue(response != null);
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
