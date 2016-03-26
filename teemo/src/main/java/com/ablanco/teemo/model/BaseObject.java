package com.ablanco.teemo.model;

import java.util.Date;

/**
 * Created by Álvaro Blanco on 21/03/2016.
 * Teemo
 */
public abstract class BaseObject {

    protected Long _id = null;
    protected Date lastUpdate = null;

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date creationDate) {
        this.lastUpdate = creationDate;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }
}
