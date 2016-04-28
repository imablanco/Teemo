package com.ablanco.teemo.persistence.base;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ablanco.teemo.model.BaseObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * An utilities class that helps DAO objects
 */
public class DBHelper {

    public static final String ID = "_id";
    public static final String FK = "fk"; //foreign key
    public static final String FFIELD = "ffield"; //foreign field name
    public static final String FTABLE = "ftable"; //foreign table name

    public static final long REFRESH_FREQUENCY_ALWAYS = 0;
    public static final long REFRESH_FREQUENCY_HALF_MINUTE = 30000;
    public static final long REFRESH_FREQUENCY_MINUTE = 60000;
    public static final long REFRESH_FREQUENCY_HALF_HOUR = 1800000;
    public static final long REFRESH_FREQUENCY_HOUR = 3600000;
    public static final long REFRESH_FREQUENCY_DAY = 86400000;
    public static final long REFRESH_FREQUENCY_NEVER = 2592000000L;

    /**
     * Remove all the objects from the given table
     *
     * @param tableName
     */
    public static void clearTable(String tableName) {
        SQLiteDatabase sqLiteDatabase = DBContext.getDB();
        if(null != sqLiteDatabase) sqLiteDatabase.delete(tableName, null, null);
    }//clearTable


    /**
     * Get the list of fields of the given type. It calls recursively to obtain superclasses fields.
     *
     * @param fields
     * @param type
     * @return
     */
    public static List<Field> getClassFields(List<Field> fields, Class<?> type) {

        Collections.addAll(fields, type.getDeclaredFields());

        if (type.getSuperclass() != null) {
            fields = getClassFields(fields, type.getSuperclass());
        }

        return fields;
    }


    /**
     * Maps a Java Class to the name of the table.
     *
     * @param table the generic Class that defines a database table
     * @return The class' simple name with first character converted to lower
     */
    public static String getTableName(Class<? extends BaseObject> table) {
        return table.getSimpleName().substring(0, 1).toLowerCase() + table.getSimpleName().substring(1);
    }


    /**
     * Get SQL column type based on Java type. Only valid for basic types!
     *
     * @param column
     * @return
     */
    public static String getColumnType(Field column) {
        //avoid static and transient fields
        if (!Modifier.isStatic(column.getModifiers()) && !Modifier.isTransient(column.getModifiers())) {

            Class<?> type = column.getType();

            if ((type.equals(Boolean.class)) ||
                    (type.equals(Boolean.TYPE)) ||
                    (type.equals(Integer.class)) ||
                    (type.equals(Integer.TYPE)) ||
                    (type.equals(Integer.class)) ||
                    (type.equals(Integer.TYPE)) ||
                    (type.equals(Long.class)) ||
                    (type.equals(Long.TYPE))) {
                return "INTEGER";
            }

            if ((type.equals(Date.class)) ||
                    (type.equals(java.sql.Date.class)) ||
                    (type.equals(Calendar.class))) {
                return "INTEGER NULL";
            }

            if (type.getName().equals("[B")) {
                return "BLOB";
            }

            if ((type.equals(Double.class)) || (type.equals(Double.TYPE)) || (type.equals(Float.class)) ||
                    (type.equals(Float.TYPE))) {
                return "REAL";
            }

            if ((type.equals(String.class)) || (type.equals(Character.TYPE))) {
                return "TEXT";
            }
        }

        return null;
    }//getColumnType


    /**
     * Add the value of the column in the given object to the given values map. It is used to
     * save objects into the DB.
     * @param values
     * @param column
     * @param object
     */
    public static void addFieldValueToColumn(ContentValues values, Field column, Object object) {
        column.setAccessible(true);
        Class<?> columnType = column.getType();
        try {
            String columnName = "'"+column.getName()+"'";
            Object columnValue = column.get(object);


            if (columnType.equals(Short.class) || columnType.equals(short.class)) {
                values.put(columnName, (Short) columnValue);
            } else if (columnType.equals(Integer.class) || columnType.equals(int.class)) {
                values.put(columnName, (Integer) columnValue);
            } else if (columnType.equals(Long.class) || columnType.equals(long.class)) {
                values.put(columnName, (Long) columnValue);
            } else if (columnType.equals(Float.class) || columnType.equals(float.class)) {
                values.put(columnName, (Float) columnValue);
            } else if (columnType.equals(Double.class) || columnType.equals(double.class)) {
                values.put(columnName, (Double) columnValue);
            } else if (columnType.equals(Boolean.class) || columnType.equals(boolean.class)) {
                values.put(columnName, (Boolean) columnValue);
            } else if (Timestamp.class.equals(columnType)) {
                try {
                    Timestamp t = ((Timestamp) column.get(object));
                    values.put(columnName, t.getTimestamp().getTime());
                } catch (NullPointerException e) {
                    values.put(columnName, (Long) null);
                }
            } else if (Date.class.equals(columnType)) {
                try {
                    values.put(columnName, ((Date) column.get(object)).getTime());
                } catch (NullPointerException e) {
                    values.put(columnName, (Long) null);
                }
            } else if (Calendar.class.equals(columnType)) {
                try {
                    values.put(columnName, ((Calendar) column.get(object)).getTimeInMillis());
                } catch (NullPointerException e) {
                    values.put(columnName, (Long) null);
                }
            } else {
                if (columnValue == null) {
                    values.putNull(columnName);
                } else {
                    values.put(columnName, String.valueOf(columnValue));
                }
            }


        } catch (IllegalAccessException e) {

        }
    }//addFieldValueToColumn


    /**
     * Set the value of the column associate to the given field to the object,
     * @param cursor    DB row
     * @param field     Field to assign value
     * @param object    Object to assign value
     */
    public static void setFieldValueFromCursor(Cursor cursor, Field field, Object object) {
        field.setAccessible(true);
        try {
            Class fieldType = field.getType();
            String colName = field.getName();

            int columnIndex = cursor.getColumnIndex(colName);

            if (cursor.isNull(columnIndex)) {
                return;
            }

            if (colName.equalsIgnoreCase(DBHelper.ID)) {
                long cid = cursor.getLong(columnIndex);
                field.set(object, Long.valueOf(cid));
            } else if (fieldType.equals(long.class) || fieldType.equals(Long.class)) {
                field.set(object,
                        cursor.getLong(columnIndex));
            } else if (fieldType.equals(String.class)) {
                String val = cursor.getString(columnIndex);
                field.set(object, val != null && val.equals("null") ? null : val);
            } else if (fieldType.equals(double.class) || fieldType.equals(Double.class)) {
                field.set(object,
                        cursor.getDouble(columnIndex));
            } else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class)) {
                field.set(object,
                        cursor.getString(columnIndex).equals("1"));
            } else if (field.getType().getName().equals("[B")) {
                field.set(object,
                        cursor.getBlob(columnIndex));
            } else if (fieldType.equals(int.class) || fieldType.equals(Integer.class)) {
                field.set(object,
                        cursor.getInt(columnIndex));
            } else if (fieldType.equals(float.class) || fieldType.equals(Float.class)) {
                field.set(object,
                        cursor.getFloat(columnIndex));
            } else if (fieldType.equals(short.class) || fieldType.equals(Short.class)) {
                field.set(object,
                        cursor.getShort(columnIndex));
            } else if (fieldType.equals(Date.class)) {
                long l = cursor.getLong(columnIndex);
                field.set(object, new Date(l));
            } else if (fieldType.equals(Calendar.class)) {
                long l = cursor.getLong(columnIndex);
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(l);
                field.set(object, c);
            }
        } catch (IllegalArgumentException e) {

        } catch (IllegalAccessException e) {

        }
    }//setFieldValueFromCursor

    public static final String storeStringArray(List<String> data){
        if( data == null){
            return null;
        }else if( data.size() == 0){
            return "";
        }else{
            String res = "";
            for( int i = 0; i < data.size(); i++){
                res += data.get(i);
                if( i < data.size()-1){
                    res += ",";
                }
            }
            return res;
        }
    }

    public static List<String> retrieveStringArray(String data){
        if( data == null){
            return null;
        }else{
            String[] parts = data.split(",");
            ArrayList<String> res = new ArrayList<String>();
            for( int i = 0; i < parts.length; i++){
                res.add(parts[i]);
            }
            return res;
        }
    }

    public static <T> String storeDataArray(List<T> data){
        if( data == null){
            return null;
        }else if( data.size() == 0){
            return "";
        }else{
            String res = "";
            for( int i = 0; i < data.size(); i++){
                res += data.get(i);
                if( i < data.size()-1){
                    res += ",";
                }
            }
            return res;
        }
    }

    public static List<Integer> retrieveIntArray(String data){
        if( data == null){
            return null;
        }else{
            String[] parts = data.split(",");
            ArrayList<Integer> res = new ArrayList<Integer>();
            for( int i = 0; i < parts.length; i++){
                res.add(Integer.parseInt(parts[i]));
            }
            return res;
        }
    }

    public static List<Long> retrieveLongArray(String data){
        if( data == null){
            return null;
        }else{
            String[] parts = data.split(",");
            ArrayList<Long> res = new ArrayList<Long>();
            for( int i = 0; i < parts.length; i++){
                res.add(Long.parseLong(parts[i]));
            }
            return res;
        }
    }

}
