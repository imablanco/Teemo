package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MetaDataDto extends BaseObject {

    private Boolean isRune;

    private String tier, type;

    public Boolean getIsRune() {
        return isRune;
    }

    public void setIsRune(Boolean isRune) {
        this.isRune = isRune;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
