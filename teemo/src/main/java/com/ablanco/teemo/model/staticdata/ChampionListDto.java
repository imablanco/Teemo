package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class ChampionListDto extends BaseObject {


    private Map<String, ChampionDto> data;
    private String format;
    private Map<String, String> keys;
    private String type;
    private String version;

    public Map<String, ChampionDto> getData() {
        return data;
    }

    public void setData(Map<String, ChampionDto> data) {
        this.data = data;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Map<String, String> getKeys() {
        return keys;
    }

    public void setKeys(Map<String, String> keys) {
        this.keys = keys;
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
