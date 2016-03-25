package com.ablanco.teemo.model.matchlist;

import com.ablanco.teemo.constants.Season;
import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchReference extends BaseObject {

    private Long champion;

    /**
     * {@link com.ablanco.teemo.constants.Lane}
     */
    private String lane;

    private Long matchId;

    private String platformId;

    /**
     * {@link com.ablanco.teemo.constants.Queue}
     */
    private String queue;

    private String region;

    /**
     * {@link com.ablanco.teemo.constants.Role}
     */
    private String role;

    /**
     * {@link Season}
     */
    private String season;

    private Long timestamp;

    public Long getChampion() {
        return champion;
    }

    public void setChampion(Long champion) {
        this.champion = champion;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
