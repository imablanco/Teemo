package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;
import com.ablanco.teemo.model.summoners.Mastery;

import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MasteryListDto extends BaseObject {
    private Map<String, Mastery> data;
    private MasteryTreeDto tree;
    private String type, version;


    public Map<String, Mastery> getData() {
        return data;
    }

    public void setData(Map<String, Mastery> data) {
        this.data = data;
    }

    public MasteryTreeDto getTree() {
        return tree;
    }

    public void setTree(MasteryTreeDto tree) {
        this.tree = tree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
