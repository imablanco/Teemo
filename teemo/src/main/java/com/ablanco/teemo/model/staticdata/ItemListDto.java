package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class ItemListDto extends BaseObject {

    private BasicDataDto basic;
    private Map<String, ItemDto> data;
    private List<GroupDto> groups;
    private List<ItemTreeDto> tree;

    private String type, version;

    public BasicDataDto getBasic() {
        return basic;
    }

    public void setBasic(BasicDataDto basic) {
        this.basic = basic;
    }

    public Map<String, ItemDto> getData() {
        return data;
    }

    public void setData(Map<String, ItemDto> data) {
        this.data = data;
    }

    public List<GroupDto> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDto> groups) {
        this.groups = groups;
    }

    public List<ItemTreeDto> getTree() {
        return tree;
    }

    public void setTree(List<ItemTreeDto> tree) {
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
