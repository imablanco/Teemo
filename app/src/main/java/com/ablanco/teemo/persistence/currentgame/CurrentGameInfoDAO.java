package com.ablanco.teemo.persistence.currentgame;

import android.database.Cursor;

import com.ablanco.teemo.model.currentgame.BannedChampion;
import com.ablanco.teemo.model.currentgame.CurrentGameInfo;
import com.ablanco.teemo.model.currentgame.CurrentGameParticipant;
import com.ablanco.teemo.model.currentgame.Observer;
import com.ablanco.teemo.persistence.base.BaseDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class CurrentGameInfoDAO extends BaseDAO<CurrentGameInfo> {

    private static final String BANNED_CHAMPIONS = "bannedChampioms";

    public CurrentGameInfoDAO() {
        super(CurrentGameInfo.class);
    }


    public long save(CurrentGameInfo object, long summonerId) {

        object.setSummonerId(summonerId);

        long id = super.save(object);
        if(id > -1){

            BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
            List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);

            bannedChampionDAO.deleteAll(bannedChampions);
            bannedChampionDAO.saveAll(object.getBannedChampions(), object, BANNED_CHAMPIONS);

            ObserverDAO observerDAO = new ObserverDAO();
            List<Observer> observers = observerDAO.findFromParent(object);

            observerDAO.deleteAll(observers);
            observerDAO.save(object.getObservers());

            CurrentGameParticipantDAO participantDAO = new CurrentGameParticipantDAO();

            List<CurrentGameParticipant> participants = participantDAO.findFromParent(object);

            participantDAO.deleteAll(participants);
            participantDAO.saveAll(participants, object);

        }

        return id;
    }

    @Override
    public void delete(CurrentGameInfo object) {

        BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
        List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);
        bannedChampionDAO.deleteAll(bannedChampions);

        ObserverDAO observerDAO = new ObserverDAO();
        List<Observer> observers = observerDAO.findFromParent(object);
        observerDAO.deleteAll(observers);

        CurrentGameParticipantDAO participantDAO = new CurrentGameParticipantDAO();
        List<CurrentGameParticipant> participants = participantDAO.findFromParent(object);
        participantDAO.deleteAll(participants);

        super.delete(object);
    }

    @Override
    public CurrentGameInfo fromCursor(Cursor c) {

        CurrentGameInfo currentGameInfo =  super.fromCursor(c);

        if(currentGameInfo != null){
            currentGameInfo.setBannedChampions(new BannedChampionDAO().findFromParent(currentGameInfo, BANNED_CHAMPIONS));
            currentGameInfo.setObservers(new ObserverDAO().findLast());
            currentGameInfo.setParticipants(new CurrentGameParticipantDAO().findFromParent(currentGameInfo));
        }

        return currentGameInfo;
    }

    public List<CurrentGameInfo> findByPlatformAndSummonerId(String platformId, long summonerId){
        return find("platformId LIKE ? AND summonerId = ?", new String[]{platformId, String.valueOf(summonerId)}, null, null, null);
    }

    public CurrentGameInfo findLastByPlatformAndSummonerId(String platformId, long summonerId){
        List<CurrentGameInfo> currentGameInfos = findByPlatformAndSummonerId(platformId, summonerId);
        return currentGameInfos.isEmpty() ? null : currentGameInfos.get(currentGameInfos.size() -1);
    }
}
