package com.ablanco.teemo.persistence.base;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ablanco.teemo.persistence.champions.ChampionDAO;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;
import com.ablanco.teemo.persistence.common.BannedChampionDAO;
import com.ablanco.teemo.persistence.currentgames.CurrentGameInfoDAO;
import com.ablanco.teemo.persistence.currentgames.CurrentGameParticipantDAO;
import com.ablanco.teemo.persistence.currentgames.CurrentGamesMasteryDAO;
import com.ablanco.teemo.persistence.currentgames.ObserverDAO;
import com.ablanco.teemo.persistence.currentgames.RuneDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGameInfoDAO;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGamesDAO;
import com.ablanco.teemo.persistence.featuredgames.ParticipantDAO;
import com.ablanco.teemo.persistence.games.GameDAO;
import com.ablanco.teemo.persistence.games.PlayerDAO;
import com.ablanco.teemo.persistence.games.RawStatsDAO;
import com.ablanco.teemo.persistence.games.RecentGamesDAO;
import com.ablanco.teemo.persistence.languages.LanguageStringDAO;
import com.ablanco.teemo.persistence.leagues.LeagueDAO;
import com.ablanco.teemo.persistence.leagues.LeagueEntryDAO;
import com.ablanco.teemo.persistence.leagues.MiniSeriesDAO;
import com.ablanco.teemo.persistence.matches.EventDAO;
import com.ablanco.teemo.persistence.matches.FrameDAO;
import com.ablanco.teemo.persistence.matches.MatchBannedChampionDAO;
import com.ablanco.teemo.persistence.matches.MatchDetailDAO;
import com.ablanco.teemo.persistence.matches.MatchMasteryDAO;
import com.ablanco.teemo.persistence.matches.MatchParticipantDAO;
import com.ablanco.teemo.persistence.matches.MatchPlayerDAO;
import com.ablanco.teemo.persistence.matches.MatchRuneDAO;
import com.ablanco.teemo.persistence.matches.MatchTeamDAO;
import com.ablanco.teemo.persistence.matches.ParticipantFrameDAO;
import com.ablanco.teemo.persistence.matches.ParticipantIdentityDAO;
import com.ablanco.teemo.persistence.matches.ParticipantStatsDAO;
import com.ablanco.teemo.persistence.matches.ParticipantTimelineDAO;
import com.ablanco.teemo.persistence.matches.ParticipantTimelineDataDAO;
import com.ablanco.teemo.persistence.matches.PositionDAO;
import com.ablanco.teemo.persistence.matches.TimelineDAO;
import com.ablanco.teemo.persistence.matchlist.MatchListDAO;
import com.ablanco.teemo.persistence.matchlist.MatchReferenceDAO;
import com.ablanco.teemo.persistence.stats.AggregatedStatsDAO;
import com.ablanco.teemo.persistence.stats.ChampionStatsDAO;
import com.ablanco.teemo.persistence.stats.PlayerStatsSummaryDAO;
import com.ablanco.teemo.persistence.stats.PlayerStatsSummaryListDAO;
import com.ablanco.teemo.persistence.stats.RankedStatsDAO;
import com.ablanco.teemo.persistence.summoners.MasteryDAO;
import com.ablanco.teemo.persistence.summoners.MasteryPageDAO;
import com.ablanco.teemo.persistence.summoners.MasteryPagesDAO;
import com.ablanco.teemo.persistence.summoners.RunePageDAO;
import com.ablanco.teemo.persistence.summoners.RunePagesDAO;
import com.ablanco.teemo.persistence.summoners.RuneSlotDAO;
import com.ablanco.teemo.persistence.summoners.SummonerDAO;
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
    private static final int DB_VERSION = 9;

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
        sqLiteDatabase.execSQL(new CurrentGamesMasteryDAO().createTable());
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
        sqLiteDatabase.execSQL(new RuneSlotDAO().createTable());
        sqLiteDatabase.execSQL(new RunePageDAO().createTable());
        sqLiteDatabase.execSQL(new RunePagesDAO().createTable());
        sqLiteDatabase.execSQL(new MasteryDAO().createTable());
        sqLiteDatabase.execSQL(new MasteryPageDAO().createTable());
        sqLiteDatabase.execSQL(new MasteryPagesDAO().createTable());
        sqLiteDatabase.execSQL(new SummonerDAO().createTable());
        sqLiteDatabase.execSQL(new MatchListDAO().createTable());
        sqLiteDatabase.execSQL(new MatchReferenceDAO().createTable());
        sqLiteDatabase.execSQL(new EventDAO().createTable());
        sqLiteDatabase.execSQL(new FrameDAO().createTable());
        sqLiteDatabase.execSQL(new MatchBannedChampionDAO().createTable());
        sqLiteDatabase.execSQL(new MatchDetailDAO().createTable());
        sqLiteDatabase.execSQL(new MatchMasteryDAO().createTable());
        sqLiteDatabase.execSQL(new MatchParticipantDAO().createTable());
        sqLiteDatabase.execSQL(new MatchPlayerDAO().createTable());
        sqLiteDatabase.execSQL(new MatchRuneDAO().createTable());
        sqLiteDatabase.execSQL(new ParticipantFrameDAO().createTable());
        sqLiteDatabase.execSQL(new ParticipantIdentityDAO().createTable());
        sqLiteDatabase.execSQL(new ParticipantStatsDAO().createTable());
        sqLiteDatabase.execSQL(new ParticipantTimelineDAO().createTable());
        sqLiteDatabase.execSQL(new ParticipantTimelineDataDAO().createTable());
        sqLiteDatabase.execSQL(new PositionDAO().createTable());
        sqLiteDatabase.execSQL(new TimelineDAO().createTable());
        sqLiteDatabase.execSQL(new MatchTeamDAO().createTable());
        sqLiteDatabase.execSQL(new LanguageStringDAO().createTable());

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(new ChampionListDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ChampionDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new BannedChampionDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new CurrentGameInfoDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new CurrentGameParticipantDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new CurrentGamesMasteryDAO().upgradeTable(oldVersion, newVersion));
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
        sqLiteDatabase.execSQL(new RuneSlotDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new RunePageDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new RunePagesDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MasteryDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MasteryPageDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MasteryPagesDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new SummonerDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchListDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchReferenceDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new EventDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new FrameDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantFrameDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new EventDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new FrameDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchBannedChampionDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchDetailDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchMasteryDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchParticipantDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchPlayerDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchRuneDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantFrameDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantIdentityDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantStatsDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantTimelineDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new ParticipantTimelineDataDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new PositionDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new TimelineDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new MatchTeamDAO().upgradeTable(oldVersion, newVersion));
        sqLiteDatabase.execSQL(new LanguageStringDAO().upgradeTable(oldVersion, newVersion));

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
        new CurrentGamesMasteryDAO().clearTable();
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
        new RuneSlotDAO().clearTable();
        new RunePageDAO().clearTable();
        new RunePagesDAO().clearTable();
        new MasteryDAO().clearTable();
        new MasteryPageDAO().clearTable();
        new MasteryPagesDAO().clearTable();
        new SummonerDAO().clearTable();
        new MatchListDAO().clearTable();
        new MatchReferenceDAO().clearTable();
        new EventDAO().clearTable();
        new FrameDAO().clearTable();
        new ParticipantFrameDAO().clearTable();
        new EventDAO().clearTable();
        new FrameDAO().clearTable();
        new MatchBannedChampionDAO().clearTable();
        new MatchDetailDAO().clearTable();
        new MatchMasteryDAO().clearTable();
        new MatchParticipantDAO().clearTable();
        new MatchPlayerDAO().clearTable();
        new MatchRuneDAO().clearTable();
        new MatchTeamDAO().clearTable();
        new ParticipantFrameDAO().clearTable();
        new ParticipantIdentityDAO().clearTable();
        new ParticipantStatsDAO().clearTable();
        new ParticipantTimelineDAO().clearTable();
        new PositionDAO().clearTable();
        new TimelineDAO().clearTable();
        new LanguageStringDAO().clearTable();

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
