package com.ablanco.teemo.persistence.base;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ablanco.teemo.persistence.champions.ChampionDAO;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;
import com.ablanco.teemo.persistence.common.BannedChampionDAO;
import com.ablanco.teemo.persistence.currentgame.CurrentGameInfoDAO;
import com.ablanco.teemo.persistence.currentgame.CurrentGameParticipantDAO;
import com.ablanco.teemo.persistence.currentgame.MasteryDAO;
import com.ablanco.teemo.persistence.currentgame.ObserverDAO;
import com.ablanco.teemo.persistence.currentgame.RuneDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGameInfoDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGamesDAO;
import com.ablanco.teemo.persistence.featuredgames.ParticipantDAO;


/**
 * Database wrapper. It has singleton pattern. Only one instance of SQLiteDabatase is created.
 * It has basic methods to init and close the access to the DB. They should be call from Application class.
 */
public class DBContext extends SQLiteOpenHelper {

    private static final String DB_NAME = "Teemo";
    private static final int DB_VERSION = 1;

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
        sqLiteDatabase.execSQL(new BannedChampionDAO().createTable());
        sqLiteDatabase.execSQL(new CurrentGameInfoDAO().createTable());
        sqLiteDatabase.execSQL(new CurrentGameParticipantDAO().createTable());
        sqLiteDatabase.execSQL(new MasteryDAO().createTable());
        sqLiteDatabase.execSQL(new ObserverDAO().createTable());
        sqLiteDatabase.execSQL(new RuneDAO().createTable());
        sqLiteDatabase.execSQL(new FeaturedGamesDAO().createTable());
        sqLiteDatabase.execSQL(new FeaturedGameInfoDAO().createTable());
        sqLiteDatabase.execSQL(new ParticipantDAO().createTable());

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(new ChampionListDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ChampionDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new BannedChampionDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new CurrentGameInfoDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new CurrentGameParticipantDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MasteryDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ObserverDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new RuneDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new FeaturedGamesDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new FeaturedGameInfoDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantDAO().upgradeTable(oldVersion, newVersion));

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
        new BannedChampionDAO().clearTable();
        new CurrentGameInfoDAO().clearTable();
        new CurrentGameParticipantDAO().clearTable();
        new MasteryDAO().clearTable();
        new ObserverDAO().clearTable();
        new RuneDAO().clearTable();
        new FeaturedGamesDAO().clearTable();
        new FeaturedGameInfoDAO().clearTable();
        new ParticipantDAO().clearTable();

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
