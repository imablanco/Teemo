package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MasteryTreeDto extends BaseObject {

    private List<MasteryTreeListDto> Cunning, Ferocity, Resolve;

    public List<MasteryTreeListDto> getCunning() {
        return Cunning;
    }

    public void setCunning(List<MasteryTreeListDto> cunning) {
        Cunning = cunning;
    }

    public List<MasteryTreeListDto> getFerocity() {
        return Ferocity;
    }

    public void setFerocity(List<MasteryTreeListDto> ferocity) {
        Ferocity = ferocity;
    }

    public List<MasteryTreeListDto> getResolve() {
        return Resolve;
    }

    public void setResolve(List<MasteryTreeListDto> resolve) {
        Resolve = resolve;
    }
}
