package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.MatchBannedChampion;
import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.model.matches.MatchTeam;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchTeamDAO extends BaseReferencedDAO<MatchTeam, MatchDetail> {


    public MatchTeamDAO() {
        super(MatchTeam.class);
    }

    @Override
    public long save(MatchTeam object, MatchDetail parent) {
        long id = super.save(object, parent);

        if(id > -1){
            MatchBannedChampionDAO matchBannedChampionDAO = new MatchBannedChampionDAO();
            List<MatchBannedChampion> matchBannedChampions = matchBannedChampionDAO.findFromParent(object);

            matchBannedChampionDAO.deleteAll(matchBannedChampions);
            matchBannedChampionDAO.saveAll(object.getBans(), object);
        }

        return id;
    }

    @Override
    public void delete(MatchTeam object) {

        MatchBannedChampionDAO matchBannedChampionDAO = new MatchBannedChampionDAO();
        List<MatchBannedChampion> matchBannedChampions = matchBannedChampionDAO.findFromParent(object);

        matchBannedChampionDAO.deleteAll(matchBannedChampions);
        super.delete(object);
    }

    @Override
    public MatchTeam fromCursor(Cursor c) {
        MatchTeam object = super.fromCursor(c);

        if(object != null){
            MatchBannedChampionDAO matchBannedChampionDAO = new MatchBannedChampionDAO();
            List<MatchBannedChampion> matchBannedChampions = matchBannedChampionDAO.findFromParent(object);

            object.setBans(matchBannedChampions);

        }

        return object;
    }
}
