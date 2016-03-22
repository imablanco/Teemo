package com.ablanco.teemo.persistence.currentgame;

import com.ablanco.teemo.model.currentgame.Rune;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class RuneDAO extends BaseComplexReferencedDAO<Rune> {

    public RuneDAO() {
        super(Rune.class);
    }
}
