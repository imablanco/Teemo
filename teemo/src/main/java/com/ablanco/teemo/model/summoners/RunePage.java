package com.ablanco.teemo.model.summoners;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RunePage extends BaseObject {
    private Boolean current;
    private Long id;
    private List<RuneSlot> slots;
    private String name;

    public Boolean isCurrent() {
        return current;
    }

    public void setCurrent(Boolean current) {
        this.current = current;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<RuneSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<RuneSlot> slots) {
        this.slots = slots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
