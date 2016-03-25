package com.ablanco.teemo.model.teams;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class Team extends BaseObject {

    private Long createDate;
    private Long astGameDate;
    private Long lastJoinDate;
    private Long lastJoinedRankedTeamQueueDate;
    private Long modifyDate;
    private Long secondLastJoinDate;
    private Long thirdLastJoinDate;
    private String fullId;
    private List<MatchHistorySummary> matchHistory;
    private String name, status, tag;
    private Roster roster;
    private List<TeamStatDetail> teamStatDetails;

    //search criteria
    private String summonerId;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public Long getAstGameDate() {
        return astGameDate;
    }

    public void setAstGameDate(Long astGameDate) {
        this.astGameDate = astGameDate;
    }

    public Long getLastJoinDate() {
        return lastJoinDate;
    }

    public void setLastJoinDate(Long lastJoinDate) {
        this.lastJoinDate = lastJoinDate;
    }

    public Long getLastJoinedRankedTeamQueueDate() {
        return lastJoinedRankedTeamQueueDate;
    }

    public void setLastJoinedRankedTeamQueueDate(Long lastJoinedRankedTeamQueueDate) {
        this.lastJoinedRankedTeamQueueDate = lastJoinedRankedTeamQueueDate;
    }

    public Long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getSecondLastJoinDate() {
        return secondLastJoinDate;
    }

    public void setSecondLastJoinDate(Long secondLastJoinDate) {
        this.secondLastJoinDate = secondLastJoinDate;
    }

    public Long getThirdLastJoinDate() {
        return thirdLastJoinDate;
    }

    public void setThirdLastJoinDate(Long thirdLastJoinDate) {
        this.thirdLastJoinDate = thirdLastJoinDate;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public List<MatchHistorySummary> getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(List<MatchHistorySummary> matchHistory) {
        this.matchHistory = matchHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Roster getRoster() {
        return roster;
    }

    public void setRoster(Roster roster) {
        this.roster = roster;
    }

    public List<TeamStatDetail> getTeamStatDetails() {
        return teamStatDetails;
    }

    public void setTeamStatDetails(List<TeamStatDetail> teamStatDetails) {
        this.teamStatDetails = teamStatDetails;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }
}