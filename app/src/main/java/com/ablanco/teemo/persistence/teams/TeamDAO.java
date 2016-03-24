package com.ablanco.teemo.persistence.teams;

import android.database.Cursor;

import com.ablanco.teemo.model.teams.MatchHistorySummary;
import com.ablanco.teemo.model.teams.Roster;
import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.model.teams.TeamStatDetail;
import com.ablanco.teemo.persistence.base.BaseDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamDAO extends BaseDAO<Team> {

    public TeamDAO() {
        super(Team.class);
    }

    @Override
    public long save(Team object){
       return save(object, null);
    }

    public long save(Team object, String summonerId) {

        //summonerID can be null if the query is by teamId
        object.setSummonerId(summonerId);
        long id =  super.save(object);

        if(id > -1){

            MatchHistorySummaryDAO matchHistorySummaryDAO = new MatchHistorySummaryDAO();
            List<MatchHistorySummary> matchHistorySummaries = matchHistorySummaryDAO.findFromParent(object);

            matchHistorySummaryDAO.deleteAll(matchHistorySummaries);
            matchHistorySummaryDAO.saveAll(object.getMatchHistory(), object);

            TeamStatDetailDAO teamStatDetailDAO = new TeamStatDetailDAO();
            List<TeamStatDetail> teamStatDetails = teamStatDetailDAO.findFromParent(object);

            teamStatDetailDAO.deleteAll(teamStatDetails);
            teamStatDetailDAO.saveAll(object.getTeamStatDetails(), object);

            RosterDAO rosterDAO = new RosterDAO();
            List<Roster> rosters = rosterDAO.findFromParent(object);
            rosterDAO.deleteAll(rosters);
            rosterDAO.save(object.getRoster(), object);
        }

        return id;
    }

    @Override
    public void delete(Team object) {

        MatchHistorySummaryDAO matchHistorySummaryDAO = new MatchHistorySummaryDAO();
        List<MatchHistorySummary> matchHistorySummaries = matchHistorySummaryDAO.findFromParent(object);

        matchHistorySummaryDAO.deleteAll(matchHistorySummaries);

        TeamStatDetailDAO teamStatDetailDAO = new TeamStatDetailDAO();
        List<TeamStatDetail> teamStatDetails = teamStatDetailDAO.findFromParent(object);

        teamStatDetailDAO.deleteAll(teamStatDetails);

        RosterDAO rosterDAO = new RosterDAO();
        List<Roster> rosters = rosterDAO.findFromParent(object);
        rosterDAO.deleteAll(rosters);

        super.delete(object);
    }

    @Override
    public Team fromCursor(Cursor c) {
        Team object = super.fromCursor(c);

        if(object != null){
            MatchHistorySummaryDAO matchHistorySummaryDAO = new MatchHistorySummaryDAO();
            List<MatchHistorySummary> matchHistorySummaries = matchHistorySummaryDAO.findFromParent(object);
            object.setMatchHistory(matchHistorySummaries);


            TeamStatDetailDAO teamStatDetailDAO = new TeamStatDetailDAO();
            List<TeamStatDetail> teamStatDetails = teamStatDetailDAO.findFromParent(object);
            object.setTeamStatDetails(teamStatDetails);

            RosterDAO rosterDAO = new RosterDAO();
            Roster roster = rosterDAO.findFirstFromParent(object);
            object.setRoster(roster);
        }

        return object;
    }

    public List<Team> findBySummonerId(String summonerId){
        return find("summonerId LIKE ?", new String[]{summonerId}, null, null);
    }

    public Team findByTeamId(String teamId){
        return findFirst("fullId LIKE ?", new String[]{teamId}, null, null);
    }
}
