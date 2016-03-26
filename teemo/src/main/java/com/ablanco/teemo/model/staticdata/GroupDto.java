package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class GroupDto extends BaseObject {

    private String MaxGroupOwnable;
    private String key;

    public String getMaxGroupOwnable() {
        return MaxGroupOwnable;
    }

    public void setMaxGroupOwnable(String maxGroupOwnable) {
        MaxGroupOwnable = maxGroupOwnable;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
