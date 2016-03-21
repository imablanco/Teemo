package com.ablanco.teemo.persistence.champions;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ablanco.teemo.model.champions.Champion;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBContext;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 21/3/16
 * Teemo
 */
public class ChampionListDAO  extends BaseDAO<ChampionList>{

    private final static String CHAMPIONS = "champions";
    private final static String FREE_TO_PLAY = "freeToPlay";

    public ChampionListDAO() {
        super(ChampionList.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_MINUTE;
    }

    @Override
    public String createTable() {
        String base = super.createTable();
        return base.substring(0, base.length() - 2) + ", " + FREE_TO_PLAY + " INTEGER )";
    }


    public long save(ChampionList object, boolean freeToPlay) {
        long id = -1;
        if(object != null) {

            object.setLastUpdate(new Date());

            List<Field> fields = new ArrayList<Field>();
            fields = DBHelper.getClassFields(fields, type);
            ContentValues values = new ContentValues();

            for (Field column : fields) {
                String columnType = DBHelper.getColumnType(column);
                if (columnType != null) {
                    DBHelper.addFieldValueToColumn(values, column, object);
                }
            }

            values.put(FREE_TO_PLAY, freeToPlay ? 1 : 0);

            SQLiteDatabase db = DBContext.getDB();
            if(null != db) {
                id = db.insertWithOnConflict(DBHelper.getTableName(type), null, values,
                        SQLiteDatabase.CONFLICT_REPLACE);
            }

            object.set_id(id);

            if(id > -1){
                ChampionDAO dao = new ChampionDAO();
                List<Champion> champions = dao.findFromParent(object, CHAMPIONS);
                dao.deleteAll(champions);

                dao.saveAll(object.getChampions(), object, CHAMPIONS);
            }
        }
        return id;
    }

    @Override
    public void delete(ChampionList object) {

        ChampionDAO dao = new ChampionDAO();
        List<Champion> champions = dao.findFromParent(object, CHAMPIONS);
        dao.deleteAll(champions);

        super.delete(object);
    }

    @Override
    public ChampionList fromCursor(Cursor c) {
        ChampionList championList =  super.fromCursor(c);

        if(championList != null){
            ChampionDAO dao = new ChampionDAO();
            List<Champion> champions = dao.findFromParent(championList, CHAMPIONS);
            championList.setChampions(champions);
        }

        return championList;

    }

    public ChampionList findByFreeToPlay(boolean freeToPlay){
        int convertedValue = freeToPlay ? 1 : 0;
        List<ChampionList> championLists = find(FREE_TO_PLAY + " = ?", new String[]{String.valueOf(convertedValue)},null,null,null);
        if(!championLists.isEmpty()){
            return championLists.get(0);
        }else {
            return null;
        }
    }
}
