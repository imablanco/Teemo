package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantTimelineData extends BaseObject {

    private Double tenToTwenty, thirtyToEnd, twentyToThirty, zeroToTen;

    public Double getTenToTwenty() {
        return tenToTwenty;
    }

    public void setTenToTwenty(Double tenToTwenty) {
        this.tenToTwenty = tenToTwenty;
    }

    public Double getThirtyToEnd() {
        return thirtyToEnd;
    }

    public void setThirtyToEnd(Double thirtyToEnd) {
        this.thirtyToEnd = thirtyToEnd;
    }

    public Double getTwentyToThirty() {
        return twentyToThirty;
    }

    public void setTwentyToThirty(Double twentyToThirty) {
        this.twentyToThirty = twentyToThirty;
    }

    public Double getZeroToTen() {
        return zeroToTen;
    }

    public void setZeroToTen(Double zeroToTen) {
        this.zeroToTen = zeroToTen;
    }
}
