package com.ablanco.teemo.persistence.summoners;

import com.ablanco.teemo.model.summoners.RunePage;
import com.ablanco.teemo.model.summoners.RuneSlot;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RuneSlotDAO extends BaseReferencedDAO<RuneSlot, RunePage> {

    public RuneSlotDAO() {
        super(RuneSlot.class);
    }
}
