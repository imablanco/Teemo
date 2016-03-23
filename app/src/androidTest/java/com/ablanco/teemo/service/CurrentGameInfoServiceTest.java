package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.currentgames.CurrentGameInfo;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public class CurrentGameInfoServiceTest extends BaseServiceTest {

    /**
     * Only correctly testable when user is playing a game
     */
    public void testGetCurrentGameInfo() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getCurrentGameInfoHandler().getCurrentGameInfoByPlatform("EUW1", TestConstants.SUMMONER_ID, new ServiceResponseListener<CurrentGameInfo>() {
                @Override
                public void onResponse(CurrentGameInfo response) {
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

    public void testNotFoundGetCurrentGameInfo() {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getCurrentGameInfoHandler().getCurrentGameInfoByPlatform("EUW1", TestConstants.SUMMONER_ID, new ServiceResponseListener<CurrentGameInfo>() {
                @Override
                public void onResponse(CurrentGameInfo response) {
                    assertTrue(response != null);
                    countDownLatch.countDown();
                }

                @Override
                public void onError(TeemoException e) {
                    assertTrue(e.getCode() == TeemoException.CODE_NOT_FOUND);
                    countDownLatch.countDown();
                }
            });

            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
