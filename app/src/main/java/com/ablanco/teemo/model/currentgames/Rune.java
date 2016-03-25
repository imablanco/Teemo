package com.ablanco.teemo.model.currentgames;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class Rune extends BaseObject {

    private Long runeId;
    private Integer count;

    public Long getRuneId() {
        return runeId;
    }

    public void setRuneId(Long runeId) {
        this.runeId = runeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
