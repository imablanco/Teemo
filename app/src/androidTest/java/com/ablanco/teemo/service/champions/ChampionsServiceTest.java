package com.ablanco.teemo.service.champions;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.service.BaseServiceTest;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionsServiceTest extends BaseServiceTest {

    public void testGetAllChampions() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getChampionsHandler().getChampions(false, new ServiceResponseListener<ChampionList>() {
                @Override
                public void onResponse(ChampionList response) {
                    assertTrue(response != null);
                    assertTrue(response.getChampions() != null);

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

    public void testGetChampionsFreeToPlay() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getChampionsHandler().getChampions(true, new ServiceResponseListener<ChampionList>() {
                @Override
                public void onResponse(ChampionList response) {
                    assertTrue(response != null);
                    assertTrue(response.getChampions() != null);

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

    public void testGetChampionById() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getChampionsHandler().getChampionById(205, new ServiceResponseListener<Champion>() {
                @Override
                public void onResponse(Champion response) {
                    assertTrue(response != null);
                }

                @Override
                public void onError(TeemoException e) {
                    assertTrue(false);
                }
            });

            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
