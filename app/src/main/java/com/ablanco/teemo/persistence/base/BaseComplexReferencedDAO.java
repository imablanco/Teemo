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
 * Generic DAO for a class that can be referenced from multiple fields in multiple classes
 * @param <T>
 */
public class BaseComplexReferencedDAO<T extends BaseObject> extends BaseDAO<T> {

    protected BaseComplexReferencedDAO(Class<T> clazz) {
        super(clazz);
    }

    @Override
    public String createTable() {
        String base = super.createTable();
        return base.substring(0, base.length() - 2) + ", " + DBHelper.FK + " INTEGER, "
                + DBHelper.FTABLE + " TEXT, " + DBHelper.FFIELD + " TEXT )";
    }

    /**
     * Save an object and associate it to the given field in the given parent.
     * @param object    Object to save
     * @param parent    Object that references this object
     * @param field     Field of the parent that references this object
     * @return
     */
    public long save(T object, BaseObject parent, String field) {
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
            values.put(DBHelper.FTABLE, DBHelper.getTableName(parent.getClass()));
            values.put(DBHelper.FFIELD, field);

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
     * Save a collection of objects in a single transaction and associate it
     * to the given field in the given parent.
     * @param objects
     * @param parent
     * @param field
     */
    public void saveAll(Collection<T> objects, BaseObject parent, String field) {
        if(null != objects) {
            SQLiteDatabase sqLiteDatabase = DBContext.getDB();
            if(null != sqLiteDatabase) {
                try {
                    sqLiteDatabase.beginTransaction();
                    for (T object : objects) {
                        save(object, parent, field);
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
     * Retrieve the list of objects referenced by the given field of the given parent
     * @param parent
     * @param field
     * @return
     */
    public List<T> findFromParent(BaseObject parent, String field) {
        return find(DBHelper.FK + "= ? AND " + DBHelper.FTABLE + " LIKE ? AND " + DBHelper.FFIELD + " LIKE ?",
                new String[]{String.valueOf(parent.get_id()), DBHelper.getTableName(parent.getClass()), field}, null, null, null);
    }

}
