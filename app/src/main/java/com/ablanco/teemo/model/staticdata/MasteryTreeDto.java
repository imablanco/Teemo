package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MasteryTreeDto extends BaseObject {

    private List<MasteryTreeListDto> Defense, Offense, Utility;

    public List<MasteryTreeListDto> getDefense() {
        return Defense;
    }

    public void setDefense(List<MasteryTreeListDto> defense) {
        Defense = defense;
    }

    public List<MasteryTreeListDto> getOffense() {
        return Offense;
    }

    public void setOffense(List<MasteryTreeListDto> offense) {
        Offense = offense;
    }

    public List<MasteryTreeListDto> getUtility() {
        return Utility;
    }

    public void setUtility(List<MasteryTreeListDto> utility) {
        Utility = utility;
    }
}
