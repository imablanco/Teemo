package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.Frame;
import com.ablanco.teemo.model.matches.ParticipantFrame;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantFrameDAO extends BaseReferencedDAO<ParticipantFrame, Frame> {

    public ParticipantFrameDAO() {
        super(ParticipantFrame.class);
    }
}
