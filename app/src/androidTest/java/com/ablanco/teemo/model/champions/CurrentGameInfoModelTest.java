package com.ablanco.teemo.model.champions;

import com.ablanco.teemo.model.BaseModelTest;
import com.ablanco.teemo.model.currentgame.BannedChampion;
import com.ablanco.teemo.model.currentgame.CurrentGameInfo;
import com.ablanco.teemo.model.currentgame.CurrentGameParticipant;
import com.ablanco.teemo.persistence.currentgame.CurrentGameInfoDAO;

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


        CurrentGameInfo currentGameInfo = new CurrentGameInfo();
        currentGameInfo.setBannedChampions(bannedChampions);
        currentGameInfo.setParticipants(participants);
        currentGameInfo.setPlatformId(platformId);

        CurrentGameInfoDAO dao = new CurrentGameInfoDAO();

        dao.save(currentGameInfo, summonerId);

        assertTrue(!dao.findByPlatformAndSummonerId(platformId, summonerId).isEmpty());

        CurrentGameInfo currentGameInfo1 = dao.findLastByPlatformAndSummonerId(platformId, summonerId);

        assertTrue(currentGameInfo1 != null);

        assertTrue(!currentGameInfo1.getBannedChampions().isEmpty() && currentGameInfo1.getBannedChampions().size() == 2);
        assertTrue(!currentGameInfo1.getParticipants().isEmpty() && currentGameInfo1.getParticipants().size() == 2);

        dao.delete(currentGameInfo1);
    }
}
