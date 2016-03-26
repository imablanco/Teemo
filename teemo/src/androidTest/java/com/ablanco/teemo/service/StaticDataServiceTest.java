package com.ablanco.teemo.service;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.staticdata.ChampionDto;
import com.ablanco.teemo.model.staticdata.ChampionListDto;
import com.ablanco.teemo.model.staticdata.ItemDto;
import com.ablanco.teemo.model.staticdata.ItemListDto;
import com.ablanco.teemo.model.staticdata.LanguageStringsDto;
import com.ablanco.teemo.model.staticdata.MapDataDto;
import com.ablanco.teemo.model.staticdata.MasteryDto;
import com.ablanco.teemo.model.staticdata.MasteryListDto;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class StaticDataServiceTest extends BaseServiceTest {

    public void testGetChampions() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getChampions(null, null, null, null, new ServiceResponseListener<ChampionListDto>() {
                @Override
                public void onResponse(ChampionListDto response) {
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

    public void testGetChampionById() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getChampionById(266, null, null, null, new ServiceResponseListener<ChampionDto>() {
                @Override
                public void onResponse(ChampionDto response) {
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

    public void testGetItems() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getItems(null, null, null, new ServiceResponseListener<ItemListDto>() {
                @Override
                public void onResponse(ItemListDto response) {
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

    public void testGetItemById() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getItemById(TestConstants.ITEM_ID, null, null, null, new ServiceResponseListener<ItemDto>() {
                @Override
                public void onResponse(ItemDto response) {
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

    public void testGetLanguageStrings() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getLanguages("es_ES",null, new ServiceResponseListener<LanguageStringsDto>() {
                @Override
                public void onResponse(LanguageStringsDto response) {
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

    public void testMapData() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getMapData(null, null, new ServiceResponseListener<MapDataDto>() {
                @Override
                public void onResponse(MapDataDto response) {
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

    public void testGetMasteries() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getMasteries(null, null, null, new ServiceResponseListener<MasteryListDto>() {
                @Override
                public void onResponse(MasteryListDto response) {
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

    public void testGetMastery() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {

            Teemo.getInstance(getContext()).getStaticDataHandler().getMasteryById(TestConstants.MASTERY_ID, null, null, null, new ServiceResponseListener<MasteryDto>() {
                @Override
                public void onResponse(MasteryDto response) {
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
