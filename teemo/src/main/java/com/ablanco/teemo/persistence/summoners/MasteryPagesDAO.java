package com.ablanco.teemo.persistence.summoners;

import android.database.Cursor;

import com.ablanco.teemo.model.summoners.MasteryPage;
import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MasteryPagesDAO extends BaseDAO<MasteryPages> {

    public MasteryPagesDAO() {
        super(MasteryPages.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_HALF_HOUR;
    }

    @Override
    public long save(MasteryPages object) {
        long id = super.save(object);

        if(id > -1){
            MasteryPageDAO masteryPageDAO = new MasteryPageDAO();
            List<MasteryPage> masteryPages = masteryPageDAO.findFromParent(object);

            masteryPageDAO.deleteAll(masteryPages);
            masteryPageDAO.saveAll(object.getPages(), object);
        }

        return id;
    }

    @Override
    public void delete(MasteryPages object) {
        MasteryPageDAO masteryPageDAO = new MasteryPageDAO();
        List<MasteryPage> masteryPages = masteryPageDAO.findFromParent(object);

        masteryPageDAO.deleteAll(masteryPages);

        super.delete(object);
    }

    @Override
    public MasteryPages fromCursor(Cursor c) {
        MasteryPages object = super.fromCursor(c);

        if(object != null){
            MasteryPageDAO masteryPageDAO = new MasteryPageDAO();
            List<MasteryPage> masteryPages = masteryPageDAO.findFromParent(object);

            object.setPages(masteryPages);
        }

        return object;
    }

    public MasteryPages finBySummonerId(long summonerId){
        return findFirst("summonerId = ?", new String[]{String.valueOf(summonerId)}, null, null);
    }
}
