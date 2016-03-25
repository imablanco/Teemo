package com.ablanco.teemo.persistence.currentgames;

import com.ablanco.teemo.model.currentgames.CurrentGamesMastery;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class CurrentGamesMasteryDAO extends BaseComplexReferencedDAO<CurrentGamesMastery> {

    public CurrentGamesMasteryDAO() {
        super(CurrentGamesMastery.class);
    }
}
