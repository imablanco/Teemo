package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.status.Shard;
import com.ablanco.teemo.model.status.ShardStatus;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class StatusServiceTest extends BaseServiceTest{

    public void testGetShards(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStatusHandler().getShards(new ServiceResponseListener<List<Shard>>() {
                @Override
                public void onResponse(List<Shard> response) {
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

    public void testGetShardStatus(){
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStatusHandler().getShardStatus("euw", new ServiceResponseListener<ShardStatus>() {
                @Override
                public void onResponse(ShardStatus response) {
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
