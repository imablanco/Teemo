package com.ablanco.teemo.model.champions;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionList extends BaseObject{


    private List<Champion> champions;

    //criteria fields
    private boolean freeToPlay;

    public List<Champion> getChampions() {
        return champions;
    }

    public void setChampions(List<Champion> champions) {
        this.champions = champions;
    }

    public boolean isFreeToPlay() {
        return freeToPlay;
    }

    public void setFreeToPlay(boolean freeToPlay) {
        this.freeToPlay = freeToPlay;
    }

}
