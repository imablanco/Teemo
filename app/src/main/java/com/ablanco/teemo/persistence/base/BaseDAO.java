package com.ablanco.teemo.persistence.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.ablanco.teemo.model.BaseObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Álvaro Blanco on 21/03/2016.
 * Teemo
 */
public abstract class BaseDAO<T extends BaseObject> {

    /**
     * Field to use class type methods
     */
    protected final Class<T> type;

    protected long expirationTime = DBHelper.REFRESH_FREQUENCY_ALWAYS;


    public BaseDAO(Class<T> clazz) {
        this.type = clazz;

        // TODO: 22/03/2016 add this in future
        //this.type = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }


    /**
     * Compose the SQL code to create the table for the given type
     *
     * @return
     */
    public String createTable() {

        List<Field> fields = new ArrayList<Field>();
        fields = DBHelper.getClassFields(fields, type);
        String tableName = DBHelper.getTableName(type);

        StringBuilder sb = new StringBuilder("CREATE TABLE ");
        sb.append(tableName)
                .append(" ( " + DBHelper.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ");

        for (Field column : fields) {
            String columnName = column.getName();
            String columnType = DBHelper.getColumnType(column);

            if (columnType != null) {
                if (columnName.equalsIgnoreCase(DBHelper.ID)) {
                    continue;
                }

                sb.append(", '").append(columnName).append("' ").append(columnType);

            }
        }

        sb.append(" )");

        return sb.toString();
    }//createTable


    /**
     * Return SQL code to update this table form oldVersion to new Version
     *
     * @param oldVersion
     * @param newVersion
     * @return
     */
    public String upgradeTable(int oldVersion, int newVersion) {
        String tableName = DBHelper.getTableName(type);

        StringBuilder sb = new StringBuilder("DROP TABLE IF EXISTS ");
        sb.append(tableName);
        return sb.toString(); // nothing to do in version 1
    }


    /**
     * Clear the current type table
     */
    public void clearTable() {
        DBHelper.clearTable(DBHelper.getTableName(type));
    }


    /**
     * Save an object into the DB. If the object exits in DB update it.
     *
     * @param object
     * @return
     */
    public long save(T object) {
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
     * Save a collection of objects into a single transaction
     *
     * @param objects
     */
    public void saveAll(Collection<T> objects) {
        SQLiteDatabase sqLiteDatabase = DBContext.getDB();
        if(null != sqLiteDatabase) {
            try {
                sqLiteDatabase.beginTransaction();
                for (T object : objects) {
                    save(object);
                }
                sqLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                Log.i("Persistence", "Error in saving in transaction " + e.getMessage());
            } finally {
                sqLiteDatabase.endTransaction();
            }
        }
    }//saveAll


    /**
     * Delete an object from de DB. The object must be stored in the DB previously, as it uses its ID.
     *
     * @param object
     */
    public void delete(T object) {
        SQLiteDatabase db = DBContext.getDB();
        if(null != db) db.delete(DBHelper.getTableName(type), DBHelper.ID + "=?", new String[]{object.get_id().toString()});
    }//delete


    /**
     * Delete a collections of objects into a single transaction
     *
     * @param objects
     */
    public void deleteAll(Collection<T> objects) {
        SQLiteDatabase sqLiteDatabase = DBContext.getDB();
        if(null != sqLiteDatabase) {
            try {
                sqLiteDatabase.beginTransaction();
                for (T object : objects) {
                    delete(object);
                }
                sqLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                Log.i("Persistence", "Error in deleting in transaction " + e.getMessage());
            } finally {
                sqLiteDatabase.endTransaction();
            }
        }
    }//saveAll


    /**
     * Transform a DB row into an object
     *
     * @param c The DB cursor of a query
     * @return
     */
    public T fromCursor(Cursor c) {
        try {
            List<Field> columns = new ArrayList<Field>();
            columns = DBHelper.getClassFields(columns, type);

            T object = (T) type.getDeclaredConstructors()[0].newInstance();
            for (Field column : columns) {
                String columnType = DBHelper.getColumnType(column);
                if (columnType != null) {
                    DBHelper.setFieldValueFromCursor(c, column, object);
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns all the objects of the current type
     *
     * @return
     */
    public List<T> findAll() {
        return find(null, null, null, null);
    }

    public T findFirst() {
        List<T> results =  find(null, null, null, null);
        if(results.isEmpty()){
            return null;
        }else {
            return results.get(0);
        }
    }

    public T findLast() {
        List<T> results =  find(null, null, null, null);
        if(results.isEmpty()){
            return null;
        }else {
            return results.get(results.size() - 1);
        }
    }

    /**
     * Generic SQL query method
     *
     * @param whereClause
     * @param whereArgs
     * @param groupBy
     * @param limit
     * @return
     */
    public List<T> find(String whereClause, String[] whereArgs, String groupBy, String limit) {

        SQLiteDatabase sqLiteDatabase = DBContext.getDB();
        List<T> toRet = new ArrayList<T>();
        Cursor c = null;
        if(null != sqLiteDatabase) {
            try {
                c = sqLiteDatabase.query(DBHelper.getTableName(type), null, whereClause, whereArgs,
                        groupBy, null, "lastUpdate DESC", limit);
            } catch (Exception e) {
                String msg = e.getClass().getName() + " " + e.getMessage();
                e.printStackTrace();
            }
            try {
                if (c != null) {
                    while (c.moveToNext()) {
                        toRet.add(fromCursor(c));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != c)
                    c.close();
            }
        }
        return toRet;
    }//find

    /**
     * Generic SQL query method
     *
     * @param whereClause
     * @param whereArgs
     * @param groupBy
     * @param limit
     * @return
     */
    public T findLast(String whereClause, String[] whereArgs, String groupBy, String limit) {

        SQLiteDatabase sqLiteDatabase = DBContext.getDB();
        List<T> toRet = new ArrayList<T>();
        Cursor c = null;
        if(null != sqLiteDatabase) {
            try {
                c = sqLiteDatabase.query(DBHelper.getTableName(type), null, whereClause, whereArgs,
                        groupBy, null, "lastUpdate DESC", limit);
            } catch (Exception e) {
                String msg = e.getClass().getName() + " " + e.getMessage();
                e.printStackTrace();
            }
            try {
                if (c != null) {
                    while (c.moveToNext()) {
                        toRet.add(fromCursor(c));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != c)
                    c.close();
            }
        }
        return toRet.isEmpty() ? null : toRet.get(toRet.size() - 1);
    }//find

    public T findFirst(String whereClause, String[] whereArgs, String groupBy, String limit) {

        SQLiteDatabase sqLiteDatabase = DBContext.getDB();
        List<T> toRet = new ArrayList<T>();
        Cursor c = null;
        if(null != sqLiteDatabase) {
            try {
                c = sqLiteDatabase.query(DBHelper.getTableName(type), null, whereClause, whereArgs,
                        groupBy, null, "lastUpdate DESC", limit);
            } catch (Exception e) {
                String msg = e.getClass().getName() + " " + e.getMessage();
                e.printStackTrace();
            }
            try {
                if (c != null) {
                    while (c.moveToNext()) {
                        toRet.add(fromCursor(c));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (null != c)
                    c.close();
            }
        }
        return toRet.isEmpty() ? null : toRet.get(0);
    }//find

    public boolean hasExpired(BaseObject obj) {
        if (obj.getLastUpdate() == null) {
            return true;
        } else {
            Date d = new Date();
            return d.getTime() - obj.getLastUpdate().getTime() > expirationTime;
        }
    }//hasExpired

    public boolean hasExpired(List<? extends  BaseObject> list) {
        boolean expired = false;
        if (list != null && list.size() > 0) {
            int i = 0;
            while (!expired && i < list.size()) {
                expired = hasExpired(list.get(i));
                i++;
            }
        } else {
            return true;
        }
        return expired;
    }//hasExpired
}
