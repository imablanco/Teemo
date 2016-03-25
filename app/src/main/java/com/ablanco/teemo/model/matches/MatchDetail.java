package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchDetail extends BaseObject {

    private Integer mapId;
    private Long matchCreation, matchDuration;
    private Long matchId;

    private String matchMode, matchType, matchVersion, platformId, queueType, region, season;
    private List<ParticipantIdentity> participantIdentities;
    private List<MatchParticipant> participants;
    private List<MatchTeam> teams;
    private Timeline timeline;

    //search criteria fields
    private Boolean includeTimeline;

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Long getMatchCreation() {
        return matchCreation;
    }

    public void setMatchCreation(Long matchCreation) {
        this.matchCreation = matchCreation;
    }

    public Long getMatchDuration() {
        return matchDuration;
    }

    public void setMatchDuration(Long matchDuration) {
        this.matchDuration = matchDuration;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchVersion() {
        return matchVersion;
    }

    public void setMatchVersion(String matchVersion) {
        this.matchVersion = matchVersion;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public List<ParticipantIdentity> getParticipantIdentities() {
        return participantIdentities;
    }

    public void setParticipantIdentities(List<ParticipantIdentity> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

    public List<MatchParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<MatchParticipant> participants) {
        this.participants = participants;
    }

    public List<MatchTeam> getTeams() {
        return teams;
    }

    public void setTeams(List<MatchTeam> teams) {
        this.teams = teams;
    }

    public Timeline getTimeline() {
        return timeline;
    }

    public void setTimeline(Timeline timeline) {
        this.timeline = timeline;
    }

    public Boolean getIncludeTimeline() {
        return includeTimeline;
    }

    public void setIncludeTimeline(Boolean includeTimeline) {
        this.includeTimeline = includeTimeline;
    }
}
