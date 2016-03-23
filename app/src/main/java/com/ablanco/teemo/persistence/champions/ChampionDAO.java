package com.ablanco.teemo.persistence.champions;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 21/3/16
 * Teemo
 */
public class ChampionDAO extends BaseComplexReferencedDAO<Champion> {

    public ChampionDAO() {
        super(Champion.class);
    }

    public Champion findById(long id){
        return findFirst("id = ?", new String[]{String.valueOf(id)}, null, null);

    }

}
