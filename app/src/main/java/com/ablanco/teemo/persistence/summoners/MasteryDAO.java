package com.ablanco.teemo.persistence.summoners;

import com.ablanco.teemo.model.summoners.Mastery;
import com.ablanco.teemo.model.summoners.MasteryPage;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MasteryDAO extends BaseReferencedDAO<Mastery, MasteryPage> {

    public MasteryDAO() {
        super(Mastery.class);
    }
}
