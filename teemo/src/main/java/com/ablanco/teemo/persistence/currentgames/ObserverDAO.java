package com.ablanco.teemo.persistence.currentgames;

import com.ablanco.teemo.model.currentgames.Observer;
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
