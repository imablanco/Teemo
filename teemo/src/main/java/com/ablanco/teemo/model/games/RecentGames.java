package com.ablanco.teemo.model.games;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class RecentGames extends BaseObject {

    private Long summonerId;
    private List<Game> games;

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
