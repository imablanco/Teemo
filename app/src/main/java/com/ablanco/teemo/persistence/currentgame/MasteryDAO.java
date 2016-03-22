package com.ablanco.teemo.persistence.currentgame;

import com.ablanco.teemo.model.currentgame.Mastery;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class MasteryDAO extends BaseComplexReferencedDAO<Mastery> {

    public MasteryDAO() {
        super(Mastery.class);
    }
}
