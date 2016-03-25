package com.ablanco.teemo.model;

import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.summoners.Mastery;
import com.ablanco.teemo.model.summoners.MasteryPage;
import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.model.summoners.RunePage;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.model.summoners.RuneSlot;
import com.ablanco.teemo.model.summoners.Summoner;
import com.ablanco.teemo.persistence.summoners.MasteryPagesDAO;
import com.ablanco.teemo.persistence.summoners.RunePagesDAO;
import com.ablanco.teemo.persistence.summoners.SummonerDAO;

import java.util.Collections;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class SummonersModelTest extends BaseModelTest{

    public void testSummoners(){

        Summoner summoner = new Summoner();
        summoner.setName(TestConstants.SUMMONER_NAME);

        Summoner summoner1 = new Summoner();
        summoner1.setId(TestConstants.SUMMONER_ID);

        SummonerDAO dao = new SummonerDAO();

        dao.save(summoner);
        dao.save(summoner1);

        assertTrue(dao.findById(TestConstants.SUMMONER_ID).getName() == null);
        assertTrue(dao.findById(TestConstants.SUMMONER_ID).getId() == TestConstants.SUMMONER_ID);
        assertTrue(dao.findByName(TestConstants.SUMMONER_NAME).getId() == null);
        assertTrue(dao.findByName(TestConstants.SUMMONER_NAME).getName().equals(TestConstants.SUMMONER_NAME));
    }

    public void testMasteries(){

        Mastery mastery = new Mastery();
        mastery.setId(1);

        MasteryPage masteryPage = new MasteryPage();

        masteryPage.setId(2l);
        masteryPage.setMasteries(Collections.singletonList(mastery));

        MasteryPages masteryPages = new MasteryPages();

        masteryPages.setSummonerId(TestConstants.SUMMONER_ID);

        masteryPages.setPages(Collections.singletonList(masteryPage));

        MasteryPagesDAO dao = new MasteryPagesDAO();

        dao.save(masteryPages);

        masteryPages = dao.finBySummonerId(TestConstants.SUMMONER_ID);

        assertTrue(masteryPages != null);

        assertTrue(masteryPages.getSummonerId() == TestConstants.SUMMONER_ID);
        assertTrue(masteryPages.getPages().get(0).getId() == 2);
        assertTrue(masteryPages.getPages().get(0).getMasteries().get(0).getId() == 1);

    }

    public void testRunePages(){

        RuneSlot runeSlot = new RuneSlot();
        runeSlot.setRuneId(1);

        RunePage runePage = new RunePage();

        runePage.setId(2l);
        runePage.setSlots(Collections.singletonList(runeSlot));

        RunePages runePages = new RunePages();

        runePages.setSummonerId(TestConstants.SUMMONER_ID);

        runePages.setPages(Collections.singletonList(runePage));

        RunePagesDAO dao = new RunePagesDAO();

        dao.save(runePages);

        runePages = dao.finBySummonerId(TestConstants.SUMMONER_ID);

        assertTrue(runePages != null);

        assertTrue(runePages.getSummonerId() == TestConstants.SUMMONER_ID);
        assertTrue(runePages.getPages().get(0).getId() == 2);
        assertTrue(runePages.getPages().get(0).getSlots().get(0).getRuneId() == 1);

    }
}
