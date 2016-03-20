package com.ablanco.teemo.model;

import com.ablanco.teemo.persistence.ExpirationTime;

import java.util.Date;

/**
 * Created by Álvaro Blanco on 21/03/2016.
 * Teemo
 */
public abstract class BaseObject {

    protected long id;

    protected long expirationTime = ExpirationTime.EXPIRATION_TIME_MINUTE;

    protected Date lastUpdate;

    protected void update(){
        this.lastUpdate = new Date();
    }

    public boolean hasExpired(){
        return System.currentTimeMillis() > lastUpdate.getTime() + expirationTime;
    }
}
