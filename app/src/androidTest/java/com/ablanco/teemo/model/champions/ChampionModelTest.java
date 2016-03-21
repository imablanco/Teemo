package com.ablanco.teemo.model.champions;

import com.ablanco.teemo.model.BaseModelTest;
import com.ablanco.teemo.persistence.champions.ChampionDAO;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionModelTest extends BaseModelTest{

    public void testChampionList(){
        ChampionList championList = new ChampionList();
        championList.setFreeToPlay(true);
        ChampionListDAO dao = new ChampionListDAO();
        dao.save(championList);

        assertTrue(championList.getChampions() == null);
        assertTrue(dao.findByFreeToPlay(true).isFreeToPlay());
        assertFalse(dao.findAll().isEmpty());

        championList.setFreeToPlay(false);
        dao.save(championList);

        assertTrue(!dao.findByFreeToPlay(false).isFreeToPlay());
        assertFalse(dao.findAll().isEmpty());

        dao.deleteAll(dao.findAll());

        assertTrue(dao.findAll().isEmpty());
    }

    public void testChampion(){
        Champion champion = new Champion();
        ChampionDAO dao = new ChampionDAO();
        dao.save(champion);

        assertFalse(dao.findAll().isEmpty());

        dao.deleteAll(dao.findAll());

        assertTrue(dao.findAll().isEmpty());
    }

}
