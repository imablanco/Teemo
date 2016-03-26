package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.model.summoners.Summoner;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class SummonersServiceTest extends BaseServiceTest {

    public void testGetSummonersByIds(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getSummonersHandler().getSummonersByIds(Collections.singletonList(TestConstants.SUMMONER_ID_STRING), new ServiceResponseListener<Map<String, Summoner>>() {
                @Override
                public void onResponse(Map<String, Summoner> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
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

    public void testGetSummonersByNames(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getSummonersHandler().getSummonersByNames(Collections.singletonList(TestConstants.SUMMONER_NAME), new ServiceResponseListener<Map<String, Summoner>>() {
                @Override
                public void onResponse(Map<String, Summoner> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
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

    public void testGetSummonersNamesByIds(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getSummonersHandler().getSummonersNamesByIds(Collections.singletonList(TestConstants.SUMMONER_ID_STRING), new ServiceResponseListener<Map<String, String>>() {
                @Override
                public void onResponse(Map<String, String> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
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

    public void testGetMasteries(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getSummonersHandler().getSummonerMasteryPages(Collections.singletonList(TestConstants.SUMMONER_ID_STRING), new ServiceResponseListener<Map<String, MasteryPages>>() {
                @Override
                public void onResponse(Map<String, MasteryPages> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
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

    public void testGetRunePages(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getSummonersHandler().getSummonerRunePages(Collections.singletonList(TestConstants.SUMMONER_ID_STRING), new ServiceResponseListener<Map<String, RunePages>>() {
                @Override
                public void onResponse(Map<String, RunePages> response) {
                    assertTrue(response != null);
                    assertTrue(response.size() == 1);
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
