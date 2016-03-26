package com.ablanco.teemo.persistence.summoners;

import android.database.Cursor;

import com.ablanco.teemo.model.summoners.Mastery;
import com.ablanco.teemo.model.summoners.MasteryPage;
import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MasteryPageDAO extends BaseReferencedDAO<MasteryPage, MasteryPages> {

    public MasteryPageDAO() {
        super(MasteryPage.class);
    }

    @Override
    public long save(MasteryPage object, MasteryPages parent) {
        long id =  super.save(object, parent);

        if(id > -1){
            MasteryDAO masteryDAO = new MasteryDAO();

            List<Mastery> masteries = masteryDAO.findFromParent(object);

            masteryDAO.deleteAll(masteries);
            masteryDAO.saveAll(object.getMasteries(), object);
        }

        return id;
    }

    @Override
    public void delete(MasteryPage object) {
        MasteryDAO masteryDAO = new MasteryDAO();

        List<Mastery> masteries = masteryDAO.findFromParent(object);

        masteryDAO.deleteAll(masteries);

        super.delete(object);
    }

    @Override
    public MasteryPage fromCursor(Cursor c) {
        MasteryPage object =  super.fromCursor(c);

        if(object != null){
            MasteryDAO masteryDAO = new MasteryDAO();

            List<Mastery> masteries = masteryDAO.findFromParent(object);

            object.setMasteries(masteries);
        }

        return object;
    }
}
