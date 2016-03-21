package com.ablanco.teemo.persistence.champions;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 21/3/16
 * Teemo
 */
public class ChampionDAO extends BaseComplexReferencedDAO<Champion> {

    public ChampionDAO() {
        super(Champion.class);
    }

    public Champion findById(long id){
        List<Champion> champions =  find("id = ?", new String[]{String.valueOf(id)}, null, null, null);
        if(!champions.isEmpty()){
            return champions.get(0);
        }else {
            return null;
        }
    }

}
