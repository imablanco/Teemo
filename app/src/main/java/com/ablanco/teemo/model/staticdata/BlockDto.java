package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class BlockDto extends BaseObject {

    private List<BlockItemDto> items;
    private Boolean recMatch;
    private String type;

    public List<BlockItemDto> getItems() {
        return items;
    }

    public void setItems(List<BlockItemDto> items) {
        this.items = items;
    }

    public Boolean getRecMatch() {
        return recMatch;
    }

    public void setRecMatch(Boolean recMatch) {
        this.recMatch = recMatch;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
