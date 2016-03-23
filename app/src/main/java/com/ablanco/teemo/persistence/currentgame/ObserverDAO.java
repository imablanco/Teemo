package com.ablanco.teemo.persistence.currentgame;

import com.ablanco.teemo.model.currentgame.Observer;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class ObserverDAO extends BaseComplexReferencedDAO<Observer> {

    public ObserverDAO() {
        super(Observer.class);
    }
}
