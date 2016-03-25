package com.ablanco.teemo.model.summoners;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class MasteryPages extends BaseObject {

    private List<MasteryPage> pages;
    private long summonerId;

    public List<MasteryPage> getPages() {
        return pages;
    }

    public void setPages(List<MasteryPage> pages) {
        this.pages = pages;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
