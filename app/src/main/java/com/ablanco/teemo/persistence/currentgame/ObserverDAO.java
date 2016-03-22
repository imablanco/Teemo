package com.ablanco.teemo.persistence.currentgame;

import com.ablanco.teemo.model.currentgame.CurrentGameInfo;
import com.ablanco.teemo.model.currentgame.Observer;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class ObserverDAO extends BaseReferencedDAO<Observer, CurrentGameInfo> {

    public ObserverDAO() {
        super(Observer.class);
    }
}
