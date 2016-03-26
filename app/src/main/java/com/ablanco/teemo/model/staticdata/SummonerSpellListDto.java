package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class SummonerSpellListDto extends BaseObject {

    private Map<String, SummonerSpellDto> data;
    private String type, version;

    public Map<String, SummonerSpellDto> getData() {
        return data;
    }

    public void setData(Map<String, SummonerSpellDto> data) {
        this.data = data;
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
