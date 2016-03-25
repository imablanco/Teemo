package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.Frame;
import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.model.matches.Timeline;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class TimelineDAO extends BaseReferencedDAO<Timeline, MatchDetail> {


    public TimelineDAO() {
        super(Timeline.class);
    }

    @Override
    public long save(Timeline object, MatchDetail parent) {
        long id =  super.save(object, parent);

        if(id > -1){

            FrameDAO frameDAO = new FrameDAO();

            List<Frame> frames = frameDAO.findFromParent(object);
            frameDAO.deleteAll(frames);
            frameDAO.saveAll(object.getFrames(), object);
        }

        return id;
    }

    @Override
    public void delete(Timeline object) {

        FrameDAO frameDAO = new FrameDAO();

        List<Frame> frames = frameDAO.findFromParent(object);
        frameDAO.deleteAll(frames);

        super.delete(object);
    }

    @Override
    public Timeline fromCursor(Cursor c) {
        Timeline object = super.fromCursor(c);

        if(object != null){

            FrameDAO frameDAO = new FrameDAO();

            List<Frame> frames = frameDAO.findFromParent(object);
            object.setFrames(frames);
        }

        return object;
    }
}
