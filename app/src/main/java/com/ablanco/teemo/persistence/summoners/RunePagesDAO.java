package com.ablanco.teemo.persistence.summoners;

import android.database.Cursor;

import com.ablanco.teemo.model.summoners.RunePage;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RunePagesDAO extends BaseDAO<RunePages> {

    public RunePagesDAO() {
        super(RunePages.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_MINUTE;
    }

    @Override
    public long save(RunePages object) {
        long id = super.save(object);

        if(id > -1){
            RunePageDAO runePageDAO = new RunePageDAO();

            List<RunePage> runePages = runePageDAO.findFromParent(object);

            runePageDAO.deleteAll(runePages);

            runePageDAO.saveAll(object.getPages(), object);
        }

        return id;
    }

    @Override
    public void delete(RunePages object) {

        RunePageDAO runePageDAO = new RunePageDAO();

        List<RunePage> runePages = runePageDAO.findFromParent(object);

        runePageDAO.deleteAll(runePages);

        super.delete(object);
    }

    @Override
    public RunePages fromCursor(Cursor c) {
        RunePages object = super.fromCursor(c);

        if(object != null){
            RunePageDAO runePageDAO = new RunePageDAO();

            List<RunePage> runePages = runePageDAO.findFromParent(object);

            object.setPages(runePages);
        }

        return object;
    }

    public RunePages finBySummonerId(long summonerId){
        return findFirst("summonerId = ?", new String[]{String.valueOf(summonerId)}, null, null);
    }
}
