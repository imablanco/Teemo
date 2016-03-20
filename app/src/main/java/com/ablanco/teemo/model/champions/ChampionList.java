package com.ablanco.teemo.model.champions;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionList extends RealmObject {

    private RealmList<Champion> champions;

    public RealmList<Champion> getChampions() {
        return champions;
    }

    public void setChampions(RealmList<Champion> champions) {
        this.champions = champions;
    }
}
