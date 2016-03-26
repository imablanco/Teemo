package com.ablanco.teemo.model.staticdata;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class GoldDto extends BaseObject {

    private Integer base;
    private Boolean purchasable;
    private Integer sell;
    private Integer total;

    public Integer getBase() {
        return base;
    }

    public void setBase(Integer base) {
        this.base = base;
    }

    public Boolean getPurchasable() {
        return purchasable;
    }

    public void setPurchasable(Boolean purchasable) {
        this.purchasable = purchasable;
    }

    public Integer getSell() {
        return sell;
    }

    public void setSell(Integer sell) {
        this.sell = sell;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
