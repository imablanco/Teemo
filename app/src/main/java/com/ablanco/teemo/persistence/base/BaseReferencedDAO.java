package com.ablanco.teemo.persistence.base;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ablanco.teemo.model.BaseObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Generic DAO for a class that is referenced only by one field in a single class.
 * @param <T>
 * @param <K>    Class type that references this table
 */
public class BaseReferencedDAO<T extends BaseObject, K extends BaseObject> extends BaseDAO<T> {

    protected BaseReferencedDAO(Class<T> clazz) {
        super(clazz);
    }

    @Override
    public String createTable() {
        String base = super.createTable();
        return base.substring(0, base.length() - 2) + ", " + DBHelper.FK + " INTEGER )";
    }

    /**
     * Save an object and associate it to the given parent
     * @param object
     * @param parent
     * @return
     */
    public long save(T object, K parent) {
        long id = -1;
        if (object != null) {

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

            //add fk
            values.put(DBHelper.FK, parent.get_id());

            SQLiteDatabase db = DBContext.getDB();
            if(null != db) {
                id = db.insertWithOnConflict(DBHelper.getTableName(type), null, values,
                        SQLiteDatabase.CONFLICT_REPLACE);
            }
            object.set_id(id);
        }
        return id;
    }//save

    /**
     * Save a collection of objects in a single transaction and associate all of them with
     * the given parent
     * @param objects
     * @param parent
     */
    public void saveAll(Collection<T> objects, K parent) {
        if(null != objects) {
            SQLiteDatabase sqLiteDatabase = DBContext.getDB();
            if(null != sqLiteDatabase) {
                try {
                    sqLiteDatabase.beginTransaction();
                    for (T object : objects) {
                        save(object, parent);
                    }
                    sqLiteDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    Log.i("Persistence", "Error in saving in transaction " + e.getMessage());
                } finally {
                    sqLiteDatabase.endTransaction();
                }
            }
        }
    }//saveAll

    /**
     * Get all tho objects referenced by the given parent.
     * @param parent
     * @return
     */
    public List<T> findFromParent(K parent) {
        return find(DBHelper.FK + "=?", new String[]{String.valueOf(parent.get_id())}, null, null, null);
    }

}
