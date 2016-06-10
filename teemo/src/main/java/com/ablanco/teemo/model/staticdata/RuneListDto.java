package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class RuneListDto extends BaseObject {

    private BasicDataDto basic;
    private Map<String, RuneDto> data;

    private String type, version;

    public BasicDataDto getBasic() {
        return basic;
    }

    public void setBasic(BasicDataDto basic) {
        this.basic = basic;
    }

    public Map<String, RuneDto> getData() {
        return data;
    }

    public void setData(Map<String, RuneDto> data) {
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
