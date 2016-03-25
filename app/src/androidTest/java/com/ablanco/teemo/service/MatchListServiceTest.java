package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.constants.Season;
import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchListServiceTest extends BaseServiceTest {

    public void testMatchList(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getMatchListHandler().getMatchListBySummonerId(TestConstants.SUMMONER_ID, null, Arrays.asList(Season.SEASON2015), null, null, null, null, null, new ServiceResponseListener<MatchList>() {
                @Override
                public void onResponse(MatchList response) {
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
