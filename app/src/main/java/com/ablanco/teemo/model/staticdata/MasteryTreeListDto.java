package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MasteryTreeListDto extends BaseObject{

    private List<MasteryTreeItemDto> masteryTreeItems;

    public List<MasteryTreeItemDto> getMasteryTreeItems() {
        return masteryTreeItems;
    }

    public void setMasteryTreeItems(List<MasteryTreeItemDto> masteryTreeItems) {
        this.masteryTreeItems = masteryTreeItems;
    }
}
