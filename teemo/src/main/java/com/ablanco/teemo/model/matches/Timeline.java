package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class Timeline extends BaseObject {

    private Long frameInterval;
    private List<Frame> frames;

    public Long getFrameInterval() {
        return frameInterval;
    }

    public void setFrameInterval(Long frameInterval) {
        this.frameInterval = frameInterval;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }
}
