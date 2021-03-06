package com.ablanco.teemo.model;

import com.ablanco.teemo.model.common.BannedChampion;
import com.ablanco.teemo.model.currentgames.CurrentGameInfo;
import com.ablanco.teemo.model.currentgames.CurrentGameParticipant;
import com.ablanco.teemo.model.currentgames.Observer;
import com.ablanco.teemo.persistence.currentgames.CurrentGameInfoDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public class CurrentGameInfoModelTest extends BaseModelTest {

    public void testCurrentGameInfoModel(){

        int summonerId = 1;
        String platformId = "EUW1";

        List<BannedChampion> bannedChampions = new ArrayList<>();
        bannedChampions.add(new BannedChampion());
        bannedChampions.add(new BannedChampion());

        List<CurrentGameParticipant> participants = new ArrayList<>();
        participants.add(new CurrentGameParticipant());
        participants.add(new CurrentGameParticipant());

        Observer observer = new Observer();
        observer.setEncryptionKey(getClass().getSimpleName());


        CurrentGameInfo currentGameInfo = new CurrentGameInfo();
        currentGameInfo.setBannedChampions(bannedChampions);
        currentGameInfo.setParticipants(participants);
        currentGameInfo.setPlatformId(platformId);
        currentGameInfo.setObservers(observer);

        CurrentGameInfoDAO dao = new CurrentGameInfoDAO();

        dao.save(currentGameInfo, summonerId);

        assertTrue(!dao.findByPlatformAndSummonerId(platformId, summonerId).isEmpty());

        currentGameInfo = dao.findFirstByPlatformAndSummonerId(platformId, summonerId);

        assertTrue(currentGameInfo != null);
        assertTrue(currentGameInfo.getSummonerId() == 1);
        assertTrue(currentGameInfo.getObservers().getEncryptionKey().equals(getClass().getSimpleName()));
        assertTrue(!currentGameInfo.getBannedChampions().isEmpty() && currentGameInfo.getBannedChampions().size() == 2);
        assertTrue(!currentGameInfo.getParticipants().isEmpty() && currentGameInfo.getParticipants().size() == 2);
        assertTrue(currentGameInfo.getObservers() != null);
        dao.delete(currentGameInfo);

        assertTrue(dao.findAll().isEmpty());
    }
}
