package com.ablanco.teemo.persistence.matchlist;

import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.model.matchlist.MatchReference;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchReferenceDAO extends BaseReferencedDAO<MatchReference, MatchList> {

    public MatchReferenceDAO() {
        super(MatchReference.class);
    }

}
