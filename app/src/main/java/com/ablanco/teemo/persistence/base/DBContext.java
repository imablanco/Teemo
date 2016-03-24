package com.ablanco.teemo.persistence.base;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ablanco.teemo.persistence.champions.ChampionDAO;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;
import com.ablanco.teemo.persistence.common.BannedChampionDAO;
import com.ablanco.teemo.persistence.currentgames.CurrentGameInfoDAO;
import com.ablanco.teemo.persistence.currentgames.CurrentGameParticipantDAO;
import com.ablanco.teemo.persistence.currentgames.MasteryDAO;
import com.ablanco.teemo.persistence.currentgames.ObserverDAO;
import com.ablanco.teemo.persistence.currentgames.RuneDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGameInfoDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGamesDAO;
import com.ablanco.teemo.persistence.featuredgames.ParticipantDAO;
import com.ablanco.teemo.persistence.games.GameDAO;
import com.ablanco.teemo.persistence.games.PlayerDAO;
import com.ablanco.teemo.persistence.games.RawStatsDAO;
import com.ablanco.teemo.persistence.games.RecentGamesDAO;
import com.ablanco.teemo.persistence.leagues.LeagueDAO;
import com.ablanco.teemo.persistence.leagues.LeagueEntryDAO;
import com.ablanco.teemo.persistence.leagues.MiniSeriesDAO;
import com.ablanco.teemo.persistence.stats.AggregatedStatsDAO;
import com.ablanco.teemo.persistence.stats.ChampionStatsDAO;
import com.ablanco.teemo.persistence.stats.PlayerStatsSummaryDAO;
import com.ablanco.teemo.persistence.stats.PlayerStatsSummaryListDAO;
import com.ablanco.teemo.persistence.stats.RankedStatsDAO;
import com.ablanco.teemo.persistence.teams.MatchHistorySummaryDAO;
import com.ablanco.teemo.persistence.teams.RosterDAO;
import com.ablanco.teemo.persistence.teams.TeamDAO;
import com.ablanco.teemo.persistence.teams.TeamMemberInfoDAO;
import com.ablanco.teemo.persistence.teams.TeamStatDetailDAO;


/**
 * Database wrapper. It has singleton pattern. Only one instance of SQLiteDabatase is created.
 * It has basic methods to init and close the access to the DB. They should be call from Application class.
 */
public class DBContext extends SQLiteOpenHelper {

    private static final String DB_NAME = "Teemo";
    private static final int DB_VERSION = 2;

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
        sqLiteDatabase.execSQL(new RecentGamesDAO().createTable());
        sqLiteDatabase.execSQL(new GameDAO().createTable());
        sqLiteDatabase.execSQL(new PlayerDAO().createTable());
        sqLiteDatabase.execSQL(new RawStatsDAO().createTable());
        sqLiteDatabase.execSQL(new LeagueDAO().createTable());
        sqLiteDatabase.execSQL(new LeagueEntryDAO().createTable());
        sqLiteDatabase.execSQL(new MiniSeriesDAO().createTable());
        sqLiteDatabase.execSQL(new AggregatedStatsDAO().createTable());
        sqLiteDatabase.execSQL(new ChampionStatsDAO().createTable());
        sqLiteDatabase.execSQL(new PlayerStatsSummaryDAO().createTable());
        sqLiteDatabase.execSQL(new RankedStatsDAO().createTable());
        sqLiteDatabase.execSQL(new PlayerStatsSummaryListDAO().createTable());
        sqLiteDatabase.execSQL(new MatchHistorySummaryDAO().createTable());
        sqLiteDatabase.execSQL(new RosterDAO().createTable());
        sqLiteDatabase.execSQL(new TeamDAO().createTable());
        sqLiteDatabase.execSQL(new TeamMemberInfoDAO().createTable());
        sqLiteDatabase.execSQL(new TeamStatDetailDAO().createTable());

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
        sqLiteDatabase.execSQL(new RecentGamesDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new PlayerDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new GameDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new RawStatsDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new LeagueDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new LeagueEntryDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MiniSeriesDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new AggregatedStatsDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ChampionStatsDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new PlayerStatsSummaryDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new PlayerStatsSummaryListDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new RankedStatsDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchHistorySummaryDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new RosterDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new TeamMemberInfoDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new TeamDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new TeamStatDetailDAO().upgradeTable(oldVersion, newVersion));

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
        new RecentGamesDAO().clearTable();
        new GameDAO().clearTable();
        new PlayerDAO().clearTable();
        new RawStatsDAO().clearTable();
        new LeagueDAO().clearTable();
        new LeagueEntryDAO().clearTable();
        new MiniSeriesDAO().clearTable();
        new AggregatedStatsDAO().clearTable();
        new ChampionStatsDAO().clearTable();
        new PlayerStatsSummaryDAO().clearTable();
        new PlayerStatsSummaryListDAO().clearTable();
        new RawStatsDAO().clearTable();
        new MatchHistorySummaryDAO().clearTable();
        new RosterDAO().clearTable();
        new TeamDAO().clearTable();
        new TeamMemberInfoDAO().clearTable();
        new TeamStatDetailDAO().clearTable();

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
