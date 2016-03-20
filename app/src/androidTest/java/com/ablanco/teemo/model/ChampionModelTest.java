package com.ablanco.teemo.model;

import android.test.AndroidTestCase;

import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.persistence.RealmContext;

import java.util.List;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionModelTest extends AndroidTestCase{

    public void testGetChampions(){
        List<ChampionList> championList = RealmContext.getInstance(getContext()).findAll(ChampionList.class);
        championList.toString();
    }
}
