package com.ablanco.teemo.persistence.currentgame;

import com.ablanco.teemo.model.currentgame.BannedChampion;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class BannedChampionDAO extends BaseComplexReferencedDAO<BannedChampion> {

    public BannedChampionDAO() {
        super(BannedChampion.class);
    }
}
