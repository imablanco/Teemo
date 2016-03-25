package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.model.matches.MatchPlayer;
import com.ablanco.teemo.model.matches.ParticipantIdentity;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantIdentityDAO extends BaseReferencedDAO<ParticipantIdentity, MatchDetail> {


    public ParticipantIdentityDAO() {
        super(ParticipantIdentity.class);
    }

    @Override
    public long save(ParticipantIdentity object, MatchDetail parent) {
        long id = super.save(object, parent);

        if(id > -1){
            MatchPlayerDAO matchPlayerDAO = new MatchPlayerDAO();
            List<MatchPlayer> matchPlayers = matchPlayerDAO.findFromParent(object);

            matchPlayerDAO.deleteAll(matchPlayers);
            matchPlayerDAO.save(object.getPlayer(), object);
        }

        return id;
    }

    @Override
    public void delete(ParticipantIdentity object) {
        MatchPlayerDAO matchPlayerDAO = new MatchPlayerDAO();
        List<MatchPlayer> matchPlayers = matchPlayerDAO.findFromParent(object);

        matchPlayerDAO.deleteAll(matchPlayers);

        super.delete(object);
    }

    @Override
    public ParticipantIdentity fromCursor(Cursor c) {
        ParticipantIdentity object = super.fromCursor(c);

        if(object != null){
            MatchPlayerDAO matchPlayerDAO = new MatchPlayerDAO();
            MatchPlayer matchPlayers = matchPlayerDAO.findFirstFromParent(object);

            object.setPlayer(matchPlayers);

        }

        return object;
    }
}
