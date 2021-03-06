package com.ablanco.teemo.model.summoners;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RunePages extends BaseObject {

    private List<RunePage> pages;
    private Long summonerId;

    public List<RunePage> getPages() {
        return pages;
    }

    public void setPages(List<RunePage> pages) {
        this.pages = pages;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }
}
