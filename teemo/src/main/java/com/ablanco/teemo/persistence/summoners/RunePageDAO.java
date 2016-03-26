package com.ablanco.teemo.persistence.summoners;

import android.database.Cursor;

import com.ablanco.teemo.model.summoners.RunePage;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.model.summoners.RuneSlot;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RunePageDAO extends BaseReferencedDAO<RunePage, RunePages> {

    public RunePageDAO() {
        super(RunePage.class);
    }

    @Override
    public long save(RunePage object, RunePages parent) {
        long id = super.save(object, parent);

        if (id > -1) {
            RuneSlotDAO runeSlotDAO = new RuneSlotDAO();
            List<RuneSlot> runeSlots = runeSlotDAO.findFromParent(object);

            runeSlotDAO.deleteAll(runeSlots);
            runeSlotDAO.saveAll(object.getSlots(), object);
        }

        return id;
    }

    @Override
    public void delete(RunePage object) {
        RuneSlotDAO runeSlotDAO = new RuneSlotDAO();
        List<RuneSlot> runeSlots = runeSlotDAO.findFromParent(object);

        runeSlotDAO.deleteAll(runeSlots);

        super.delete(object);
    }

    @Override
    public RunePage fromCursor(Cursor c) {
        RunePage object = super.fromCursor(c);

        if(object != null){
            RuneSlotDAO runeSlotDAO = new RuneSlotDAO();
            List<RuneSlot> runeSlots = runeSlotDAO.findFromParent(object);

            object.setSlots(runeSlots);
        }

        return object;
    }
}
