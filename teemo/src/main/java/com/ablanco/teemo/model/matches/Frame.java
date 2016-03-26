package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class Frame extends BaseObject {

    private List<Event> events;
    private Map<String, ParticipantFrame> participantFrames;

    private Long timestamp;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Map<String, ParticipantFrame> getParticipantFrames() {
        return participantFrames;
    }

    public void setParticipantFrames(Map<String, ParticipantFrame> participantFrames) {
        this.participantFrames = participantFrames;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
