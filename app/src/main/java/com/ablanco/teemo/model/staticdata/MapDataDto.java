package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MapDataDto extends BaseObject {

    private Map<String, MapDetailsDto> data;
    private String type;
    private String version;

    public Map<String, MapDetailsDto> getData() {
        return data;
    }

    public void setData(Map<String, MapDetailsDto> data) {
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
