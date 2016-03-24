package com.ablanco.teemo.model;

import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.model.teams.MatchHistorySummary;
import com.ablanco.teemo.model.teams.Roster;
import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.model.teams.TeamMemberInfo;
import com.ablanco.teemo.model.teams.TeamStatDetail;
import com.ablanco.teemo.persistence.teams.TeamDAO;

import java.util.Collections;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamModelTest extends BaseModelTest {

    public void testTeamModelBySummoner(){

        TeamMemberInfo teamMemberInfo = new TeamMemberInfo();
        teamMemberInfo.setPlayerId(1);

        Roster roster = new Roster();
        roster.setOwnerId(2);

        roster.setMemberList(Collections.singletonList(teamMemberInfo));

        TeamStatDetail teamStatDetail = new TeamStatDetail();
        teamStatDetail.setAverageGamesPlayed(3);

        MatchHistorySummary matchHistorySummary = new MatchHistorySummary();
        matchHistorySummary.setAssists(4);

        Team team = new Team();

        team.setRoster(roster);
        team.setMatchHistory(Collections.singletonList(matchHistorySummary));
        team.setTeamStatDetails(Collections.singletonList(teamStatDetail));

        TeamDAO teamDAO = new TeamDAO();

        teamDAO.save(team, TestConstants.SUMMONER_ID_STRING);

        team = teamDAO.findBySummonerId(TestConstants.SUMMONER_ID_STRING).get(0);

        assertTrue(team.getSummonerId().equals(TestConstants.SUMMONER_ID_STRING));
        assertTrue(team.getFullId() == null);
        assertTrue(team.getRoster().getMemberList().size() == 1);
        assertTrue(team.getRoster().getMemberList().get(0).getPlayerId() == 1);
        assertTrue(team.getRoster().getOwnerId() == 2);
        assertTrue(team.getTeamStatDetails().size() == 1);
        assertTrue(team.getTeamStatDetails().get(0).getAverageGamesPlayed() == 3);
        assertTrue(team.getMatchHistory().size() == 1);
        assertTrue(team.getMatchHistory().get(0).getAssists() == 4);

        teamDAO.deleteAll(teamDAO.findBySummonerId(TestConstants.SUMMONER_ID_STRING));

        assertTrue(teamDAO.findAll().size() == 0);

    }

    public void testTeamModelByTeamId(){

        TeamMemberInfo teamMemberInfo = new TeamMemberInfo();
        teamMemberInfo.setPlayerId(10);

        Roster roster = new Roster();
        roster.setOwnerId(11);

        roster.setMemberList(Collections.singletonList(teamMemberInfo));

        TeamStatDetail teamStatDetail = new TeamStatDetail();
        teamStatDetail.setAverageGamesPlayed(12);

        MatchHistorySummary matchHistorySummary = new MatchHistorySummary();
        matchHistorySummary.setAssists(13);

        Team team = new Team();

        team.setRoster(roster);
        team.setMatchHistory(Collections.singletonList(matchHistorySummary));
        team.setTeamStatDetails(Collections.singletonList(teamStatDetail));

        team.setFullId(TestConstants.TEAM_ID);

        TeamDAO teamDAO = new TeamDAO();

        teamDAO.save(team);

        team = teamDAO.findByTeamId(TestConstants.TEAM_ID);

        assertTrue(team.getFullId().equals(TestConstants.TEAM_ID));
        assertTrue(team.getSummonerId() == null);
        assertTrue(team.getRoster().getMemberList().size() == 1);
        assertTrue(team.getRoster().getMemberList().get(0).getPlayerId() == 10);
        assertTrue(team.getTeamStatDetails().size() == 1);
        assertTrue(team.getRoster().getOwnerId() == 11);
        assertTrue(team.getTeamStatDetails().get(0).getAverageGamesPlayed() == 12);
        assertTrue(team.getMatchHistory().size() == 1);
        assertTrue(team.getMatchHistory().get(0).getAssists() == 13);

        teamDAO.delete(teamDAO.findByTeamId(TestConstants.TEAM_ID));

        assertTrue(teamDAO.findAll().size() == 0);

    }
}
