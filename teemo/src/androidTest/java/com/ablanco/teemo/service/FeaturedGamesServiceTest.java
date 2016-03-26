package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.featuredgames.FeaturedGames;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class FeaturedGamesServiceTest extends BaseServiceTest {

    public void testGetFeaturedGames(){

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getFeaturedGamesHandler().getFeaturedGames(new ServiceResponseListener<FeaturedGames>() {
                @Override
                public void onResponse(FeaturedGames response) {
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
