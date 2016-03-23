package com.ablanco.teemo.model.currentgames;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class Rune extends BaseObject {

    private long runeId;
    private int count;

    public long getRuneId() {
        return runeId;
    }

    public void setRuneId(long runeId) {
        this.runeId = runeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
