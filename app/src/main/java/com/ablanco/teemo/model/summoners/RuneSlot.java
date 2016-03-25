package com.ablanco.teemo.model.summoners;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RuneSlot extends BaseObject {

    private Integer runeId;
    private Integer runeSlotId;

    public Integer getRuneId() {
        return runeId;
    }

    public void setRuneId(Integer runeId) {
        this.runeId = runeId;
    }

    public Integer getRuneSlotId() {
        return runeSlotId;
    }

    public void setRuneSlotId(Integer runeSlotId) {
        this.runeSlotId = runeSlotId;
    }
}
