package com.ablanco.teemo.model.games;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class Game extends BaseObject {

    private Integer championId;
    private Long createDate;
    private List<Player> fellowPlayers;
    private Long gameId;
    private String gameMode;
    private String gameType;
    private Boolean invalid;
    private Integer ipEarned;
    private Integer level;
    private Integer mapId;
    private Integer spell1;
    private Integer spell2;
    private RawStats stats;
    private String subType;
    private Integer teamId;

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public List<Player> getFellowPlayers() {
        return fellowPlayers;
    }

    public void setFellowPlayers(List<Player> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public Boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(Boolean invalid) {
        this.invalid = invalid;
    }

    public Integer getIpEarned() {
        return ipEarned;
    }

    public void setIpEarned(Integer ipEarned) {
        this.ipEarned = ipEarned;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMapId() {
        return mapId;
    }

    public void setMapId(Integer mapId) {
        this.mapId = mapId;
    }

    public Integer getSpell1() {
        return spell1;
    }

    public void setSpell1(Integer spell1) {
        this.spell1 = spell1;
    }

    public Integer getSpell2() {
        return spell2;
    }

    public void setSpell2(Integer spell2) {
        this.spell2 = spell2;
    }

    public RawStats getStats() {
        return stats;
    }

    public void setStats(RawStats stats) {
        this.stats = stats;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
