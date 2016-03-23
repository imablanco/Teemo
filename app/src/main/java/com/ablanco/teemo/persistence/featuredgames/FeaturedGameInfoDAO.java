package com.ablanco.teemo.persistence.featuredgames;

import android.database.Cursor;

import com.ablanco.teemo.model.common.BannedChampion;
import com.ablanco.teemo.model.currentgame.Observer;
import com.ablanco.teemo.model.featuredgames.FeaturedGameInfo;
import com.ablanco.teemo.model.featuredgames.Participant;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.common.BannedChampionDAO;
import com.ablanco.teemo.persistence.currentgame.ObserverDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class FeaturedGameInfoDAO extends BaseDAO<FeaturedGameInfo>{

    private static final String BANNED_CHAMPIONS = "bannedChampioms";
    private static final String OBSERVER = "observers";

    public FeaturedGameInfoDAO() {
        super(FeaturedGameInfo.class);
    }

    @Override
    public long save(FeaturedGameInfo object) {
        long id = super.save(object);

        if(id > -1){

            BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
            List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);
            bannedChampionDAO.deleteAll(bannedChampions);
            bannedChampionDAO.saveAll(object.getBannedChampions(), object, BANNED_CHAMPIONS);

            ParticipantDAO participantDAO = new ParticipantDAO();
            List<Participant> participants = participantDAO.findFromParent(object);
            participantDAO.deleteAll(participants);
            participantDAO.saveAll(object.getParticipants(), object);

            ObserverDAO observerDAO = new ObserverDAO();
            List<Observer> observers = observerDAO.findFromParent(object, OBSERVER);
            observerDAO.deleteAll(observers);
            observerDAO.save(object.getObservers(), object, OBSERVER);

        }

        return id;
    }

    @Override
    public void delete(FeaturedGameInfo object) {

        BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
        List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);
        bannedChampionDAO.deleteAll(bannedChampions);

        ParticipantDAO participantDAO = new ParticipantDAO();
        List<Participant> participants = participantDAO.findFromParent(object);
        participantDAO.deleteAll(participants);

        ObserverDAO observerDAO = new ObserverDAO();
        List<Observer> observers = observerDAO.findFromParent(object, OBSERVER);
        observerDAO.deleteAll(observers);

        super.delete(object);
    }

    @Override
    public FeaturedGameInfo fromCursor(Cursor c) {
        FeaturedGameInfo object =  super.fromCursor(c);

        if(object != null){
            BannedChampionDAO bannedChampionDAO = new BannedChampionDAO();
            List<BannedChampion> bannedChampions = bannedChampionDAO.findFromParent(object, BANNED_CHAMPIONS);

            object.setBannedChampions(bannedChampions);

            ParticipantDAO participantDAO = new ParticipantDAO();
            List<Participant> participants = participantDAO.findFromParent(object);
            object.setParticipants(participants);

            ObserverDAO observerDAO = new ObserverDAO();
            Observer observers = observerDAO.findLastFromParent(object, OBSERVER);
            object.setObservers(observers);
        }

        return object;
    }
}
