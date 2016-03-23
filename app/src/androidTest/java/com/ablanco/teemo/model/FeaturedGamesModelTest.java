package com.ablanco.teemo.model;

import com.ablanco.teemo.model.common.BannedChampion;
import com.ablanco.teemo.model.currentgame.Observer;
import com.ablanco.teemo.model.featuredgames.FeaturedGameInfo;
import com.ablanco.teemo.model.featuredgames.FeaturedGames;
import com.ablanco.teemo.model.featuredgames.Participant;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGameInfoDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGamesDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class FeaturedGamesModelTest extends BaseModelTest{


    public void testFeaturedGames(){

        FeaturedGames featuredGames = new FeaturedGames();

        List<FeaturedGameInfo> featuredGameInfos = new ArrayList<>();
        featuredGameInfos.add(new FeaturedGameInfo());

        featuredGames.setGameList(featuredGameInfos);

        FeaturedGamesDAO featuredGamesDAO = new FeaturedGamesDAO();
        featuredGamesDAO.save(featuredGames);

        assertTrue(featuredGamesDAO.findLast() != null);
        assertTrue(!featuredGamesDAO.findLast().getGameList().isEmpty());

        featuredGamesDAO.deleteAll(featuredGamesDAO.findAll());

        assertTrue(featuredGamesDAO.findAll().isEmpty());

    }

    public void testFeaturedGameInfo(){
        FeaturedGameInfo featuredGameInfo = new FeaturedGameInfo();

        List<BannedChampion> bannedChampions = new ArrayList<>();
        bannedChampions.add(new BannedChampion());
        bannedChampions.add(new BannedChampion());

        List<Participant> participants = new ArrayList<>();
        participants.add(new Participant());
        participants.add(new Participant());

        Observer observer = new Observer();

        featuredGameInfo.setBannedChampions(bannedChampions);
        featuredGameInfo.setParticipants(participants);
        featuredGameInfo.setObservers(observer);

        FeaturedGameInfoDAO featuredGameInfoDAO = new FeaturedGameInfoDAO();

        featuredGameInfoDAO.save(featuredGameInfo);

        featuredGameInfo = featuredGameInfoDAO.findLast();

        assertTrue(!featuredGameInfo.getBannedChampions().isEmpty() && featuredGameInfo.getBannedChampions().size() == 2);
        assertTrue(!featuredGameInfo.getParticipants().isEmpty() && featuredGameInfo.getParticipants().size() == 2);
        assertTrue(featuredGameInfo.getObservers() != null);
        featuredGameInfoDAO.deleteAll(featuredGameInfoDAO.findAll());
        assertTrue(featuredGameInfoDAO.findAll().isEmpty());

    }
}
