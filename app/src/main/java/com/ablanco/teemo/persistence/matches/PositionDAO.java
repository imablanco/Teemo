package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.Event;
import com.ablanco.teemo.model.matches.Position;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class PositionDAO extends BaseReferencedDAO<Position, Event> {


    public PositionDAO() {
        super(Position.class);
    }
}
