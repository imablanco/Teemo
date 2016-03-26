package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MapDetailsDto extends BaseObject {

    private ImageDto image;
    private Long mapId;
    private String mapName;
    private List<Long> unpurchasableItemList;

    public ImageDto getImage() {
        return image;
    }

    public void setImage(ImageDto image) {
        this.image = image;
    }

    public Long getMapId() {
        return mapId;
    }

    public void setMapId(Long mapId) {
        this.mapId = mapId;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public List<Long> getUnpurchasableItemList() {
        return unpurchasableItemList;
    }

    public void setUnpurchasableItemList(List<Long> unpurchasableItemList) {
        this.unpurchasableItemList = unpurchasableItemList;
    }
}
