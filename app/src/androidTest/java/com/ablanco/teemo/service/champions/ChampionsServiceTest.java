package com.ablanco.teemo.service.champions;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.service.BaseServiceTest;
import com.ablanco.teemo.service.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionsServiceTest extends BaseServiceTest{

    public void testGetChampions(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getChampionsHandler().getChallenges(new ServiceResponseListener<ChampionList>() {
                @Override
                public void onResponse(ChampionList response) {
                    response.toString();

                    countDownLatch.countDown();
                }

                @Override
                public void onError(Exception e) {
                    e.toString();
                    countDownLatch.countDown();
                }
            });

            countDownLatch.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
