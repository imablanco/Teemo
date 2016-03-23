package com.ablanco.teemo.persistence.currentgames;

import android.database.Cursor;

import com.ablanco.teemo.model.common.BannedChampion;
import com.ablanco.teemo.model.currentgames.CurrentGameInfo;
import com.ablanco.teemo.model.currentgames.CurrentGameParticipant;
import com.ablanco.teemo.model.currentgames.Observer;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;
import com.ablanco.teemo.persistence.common.BannedChampionDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class CurrentGameInfoDAO extends BaseDAO<CurrentGameInfo> {

    private static final String BANNED_CHAMPIONS = "bannedChampioms";
    private static final String OBSERVER = "observers";

    public CurrentGameInfoDAO() {
        super(CurrentGameInfo.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HALF_MINUTE;
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
            List<Observer> observers = observerDAO.findFromParent(object, OBSERVER);

            observerDAO.deleteAll(observers);
            observerDAO.save(object.getObservers(), object, OBSERVER);

            CurrentGameParticipantDAO participantDAO = new CurrentGameParticipantDAO();
            List<CurrentGameParticipant> participants = participantDAO.findFromParent(object);

            participantDAO.deleteAll(participants);
            participantDAO.saveAll(object.getParticipants(), object);

        }

        return id;
    }

    @Override
    public void delete(CurrentGameInfo object) {

        BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
        List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);
        bannedChampionDAO.deleteAll(bannedChampions);

        ObserverDAO observerDAO = new ObserverDAO();
        List<Observer> observers = observerDAO.findFromParent(object, OBSERVER);
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
            currentGameInfo.setObservers(new ObserverDAO().findFirstFromParent(currentGameInfo, OBSERVER));
            currentGameInfo.setParticipants(new CurrentGameParticipantDAO().findFromParent(currentGameInfo));
        }

        return currentGameInfo;
    }

    public List<CurrentGameInfo> findByPlatformAndSummonerId(String platformId, long summonerId){
        return find("platformId LIKE ? AND summonerId = ?", new String[]{platformId, String.valueOf(summonerId)}, null, null);
    }

    public CurrentGameInfo findFirstByPlatformAndSummonerId(String platformId, long summonerId){
        List<CurrentGameInfo> currentGameInfos = findByPlatformAndSummonerId(platformId, summonerId);
        return currentGameInfos.isEmpty() ? null : currentGameInfos.get(0);
    }
}
