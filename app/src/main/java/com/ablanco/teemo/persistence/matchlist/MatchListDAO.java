package com.ablanco.teemo.persistence.matchlist;

import android.database.Cursor;

import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.model.matchlist.MatchReference;
import com.ablanco.teemo.persistence.base.BaseDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchListDAO extends BaseDAO<MatchList> {

    public MatchListDAO() {
        super(MatchList.class);
    }

    public long save(MatchList object, String championIds, long beginTime, long endTime) {

        long id = super.save(object);

        if(id > -1){

            MatchReferenceDAO matchReferenceDAO = new MatchReferenceDAO();
            List<MatchReference> matchReferences = matchReferenceDAO.findFromParent(object);
            matchReferenceDAO.deleteAll(matchReferences);
            matchReferenceDAO.saveAll(object.getMatches(), object);
        }

        return id;
    }

    @Override
    public void delete(MatchList object) {

        MatchReferenceDAO matchReferenceDAO = new MatchReferenceDAO();
        List<MatchReference> matchReferences = matchReferenceDAO.findFromParent(object);
        matchReferenceDAO.deleteAll(matchReferences);

        super.delete(object);
    }

    @Override
    public MatchList fromCursor(Cursor c) {
        MatchList object = super.fromCursor(c);

        if(object != null){
            MatchReferenceDAO matchReferenceDAO = new MatchReferenceDAO();
            List<MatchReference> matchReferences = matchReferenceDAO.findFromParent(object);
            object.setMatches(matchReferences);
        }
        return object;
    }

}
