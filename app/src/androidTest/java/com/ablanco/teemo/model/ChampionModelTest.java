package com.ablanco.teemo.model;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.persistence.champions.ChampionDAO;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionModelTest extends BaseModelTest{

    public void testChampionList(){
        ChampionList championList = new ChampionList();
        ChampionListDAO dao = new ChampionListDAO();

        List<Champion> champions = new ArrayList<>();
        champions.add(new Champion());

        championList.setChampions(champions);

        dao.save(championList, true);

        assertTrue(!dao.findByFreeToPlay(true).getChampions().isEmpty());
        assertTrue(dao.findByFreeToPlay(true).isFreeToPlay());
        assertTrue(!dao.findAll().isEmpty());

        championList.setFreeToPlay(false);
        dao.save(championList);

        assertTrue(!dao.findByFreeToPlay(false).isFreeToPlay());
        assertTrue(!dao.findAll().isEmpty());

        dao.deleteAll(dao.findAll());

        assertTrue(dao.findAll().isEmpty());
    }

    public void testChampion(){
        Champion champion = new Champion();
        champion.setId(1);
        ChampionDAO dao = new ChampionDAO();
        dao.save(champion);

        assertFalse(dao.findAll().isEmpty());
        assertTrue(dao.findById(1) != null);

        dao.deleteAll(dao.findAll());

        assertTrue(dao.findAll().isEmpty());
    }

    public void testInsertingOrder() throws InterruptedException {

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Champion firstChampion = new Champion();
                firstChampion.setId(1);

                Champion secondChampion = new Champion();
                secondChampion.setId(2);

                ChampionDAO dao = new ChampionDAO();

                dao.save(firstChampion);

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                dao.save(secondChampion);

                assertTrue(dao.findFirst().getLastUpdate().after(dao.findLast().getLastUpdate()));

                countDownLatch.countDown();

            }
        }).start();

        countDownLatch.await();



    }

}
