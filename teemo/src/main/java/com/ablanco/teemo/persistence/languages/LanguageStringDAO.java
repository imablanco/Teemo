package com.ablanco.teemo.persistence.languages;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ablanco.teemo.model.staticdata.LanguageStringsDto;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBContext;
import com.ablanco.teemo.persistence.base.DBHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class LanguageStringDAO extends BaseDAO<LanguageStringsDto> {

    private static final String DATA_FIELD = "data";

    public LanguageStringDAO() {
        super(LanguageStringsDto.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_NEVER;
    }


    public String createTable() {
        String sql = super.createTable();
        return sql.substring(0, sql.length() -2) + ", " + DATA_FIELD + " TEXT )";
    }

    public long save(LanguageStringsDto object, String locale) {
        long id = -1;
        if (object != null) {

            object.setLocale(locale);
            //update last update date
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

            if (object.getData() != null) {
                values.put(DATA_FIELD, new JSONObject(object.getData()).toString());
            }

            SQLiteDatabase db = DBContext.getDB();
            if(null != db) {
                id = db.insertWithOnConflict(DBHelper.getTableName(type), null, values,
                        SQLiteDatabase.CONFLICT_REPLACE);
            }
            object.set_id(id);

        }
        return id;
    }

    @Override
    public LanguageStringsDto fromCursor(Cursor c) {
        LanguageStringsDto object = super.fromCursor(c);

        if(object != null){
            String data = c.getString(c.getColumnIndex(DATA_FIELD));

            Map<String, String> dataHashMap = new HashMap<>();

            try {
                JSONObject json = new JSONObject(data);
                JSONArray names = json.names();
                for (int i = 0; i < names.length(); i++) {
                    String key = names.getString(i);
                    dataHashMap.put(key, json.optString(key));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            object.setData(dataHashMap);

        }

        return object;
    }

    public LanguageStringsDto findByLocale(String locale){
        return findFirst("locale LIKE ? ", new String[]{locale}, null, null);
    }

}
