package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.Event;
import com.ablanco.teemo.model.matches.Frame;
import com.ablanco.teemo.model.matches.ParticipantFrame;
import com.ablanco.teemo.model.matches.Timeline;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class FrameDAO extends BaseReferencedDAO<Frame, Timeline> {

    public FrameDAO() {
        super(Frame.class);
    }

    @Override
    public long save(Frame object, Timeline parent) {
        long id = super.save(object, parent);

        if(id > -1){

            EventDAO eventDAO = new EventDAO();
            List<Event> events = eventDAO.findFromParent(object);

            eventDAO.deleteAll(events);
            eventDAO.saveAll(object.getEvents(), object);

            ParticipantFrameDAO participantFrameDAO = new ParticipantFrameDAO();
            List<ParticipantFrame> participantFrames = participantFrameDAO.findFromParent(object);
            participantFrameDAO.deleteAll(participantFrames);
            if(object.getParticipantFrames() != null){
                participantFrameDAO.saveAll(object.getParticipantFrames().values(), object);
            }

        }

        return id;
    }

    @Override
    public void delete(Frame object) {

        EventDAO eventDAO = new EventDAO();
        List<Event> events = eventDAO.findFromParent(object);

        eventDAO.deleteAll(events);

        ParticipantFrameDAO participantFrameDAO = new ParticipantFrameDAO();
        List<ParticipantFrame> participantFrames = participantFrameDAO.findFromParent(object);
        participantFrameDAO.deleteAll(participantFrames);

        super.delete(object);
    }

    @Override
    public Frame fromCursor(Cursor c) {
        Frame object = super.fromCursor(c);

        if(object != null){
            EventDAO eventDAO = new EventDAO();
            List<Event> events = eventDAO.findFromParent(object);
            object.setEvents(events);

            ParticipantFrameDAO participantFrameDAO = new ParticipantFrameDAO();
            List<ParticipantFrame> participantFrames = participantFrameDAO.findFromParent(object);

            Map<String, ParticipantFrame> map = new HashMap<>();
            for (ParticipantFrame participantFrame : participantFrames){
                map.put(String.valueOf(participantFrame.getParticipantId()), participantFrame);
            }

            object.setParticipantFrames(map);
        }

        return object;
    }
}
