package com.ablanco.teemo.model.featuredgames;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public class FeaturedGames extends BaseObject {

    private Long clientRefreshInterval;
    private List<FeaturedGameInfo> gameList;

    public Long getClientRefreshInterval() {
        return clientRefreshInterval;
    }

    public void setClientRefreshInterval(Long clientRefreshInterval) {
        this.clientRefreshInterval = clientRefreshInterval;
    }

    public List<FeaturedGameInfo> getGameList() {
        return gameList;
    }

    public void setGameList(List<FeaturedGameInfo> gameList) {
        this.gameList = gameList;
    }
}
