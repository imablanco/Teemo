package com.ablanco.teemo.persistence.base;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ablanco.teemo.persistence.champions.ChampionDAO;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;


/**
 * Database wrapper. It has singleton pattern. Only one instance of SQLiteDabatase is created.
 * It has basic methods to init and close the access to the DB. They should be call from Application class.
 */
public class DBContext extends SQLiteOpenHelper {

    private static final String DB_NAME = "DigitalPlatformClient";
    private static final int DB_VERSION = 22;

    /**
     * Singleton
     */
    private static DBContext instance = null;
    /**
     * Access to database
     */
    private SQLiteDatabase sqLiteDatabase = null;


    public DBContext(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(new ChampionListDAO().createTable());
        sqLiteDatabase.execSQL(new ChampionDAO().createTable());

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(new ChampionListDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ChampionDAO().upgradeTable(oldVersion, newVersion));

        // re create database
        onCreate(sqLiteDatabase);
    }


    /**
     * Inits the singleton object. It should be called from an Application class.
     *
     * @param ctx
     */
    public synchronized static void initDb(Context ctx) {
        instance = new DBContext(ctx);
    }//initDb


    /**
     * Gets access to the DB.
     *
     * @return
     */
    public synchronized static SQLiteDatabase getDB() {
        if (instance != null) {
            if (instance.sqLiteDatabase == null) {
                instance.sqLiteDatabase = instance.getWritableDatabase();
            }
            return instance.sqLiteDatabase;
        }
        return null;
    }//getDb


    /**
     * Clear all the tables in the DB
     */
    public synchronized static void clearDb() {
        new ChampionListDAO().clearTable();
        new ChampionDAO().clearTable();

    }//clearDb


    /**
     * Close the DB connection and destroy the singleton.
     */
    public synchronized static void finishDb() {
        if (instance == null) {
            return;
        }
        if (instance.sqLiteDatabase != null) {
            instance.sqLiteDatabase.close();
        }
        instance = null;
    }//finishDb


}
