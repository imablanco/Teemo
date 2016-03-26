package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchPlayer extends BaseObject{

    private String matchHistoryUri, summonerName;
    private Integer profileIcon;

    private Long summonerId;

    public String getMatchHistoryUri() {
        return matchHistoryUri;
    }

    public void setMatchHistoryUri(String matchHistoryUri) {
        this.matchHistoryUri = matchHistoryUri;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Integer getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(Integer profileIcon) {
        this.profileIcon = profileIcon;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }
}
