package com.ablanco.teemo.model.featuredgames;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public class Participant extends BaseObject {

    private Boolean bot;
    private Long championId;
    private Long profileIconId;
    private Long spell1Id;
    private Long spell2Id;
    private String summonerName;
    private Long teamId;

    public Boolean isBot() {
        return bot;
    }

    public void setBot(Boolean bot) {
        this.bot = bot;
    }

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public Long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public Long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(Long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public Long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(Long spell2Id) {
        this.spell2Id = spell2Id;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
