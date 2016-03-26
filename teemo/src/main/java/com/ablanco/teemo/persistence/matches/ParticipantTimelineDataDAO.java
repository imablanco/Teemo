package com.ablanco.teemo.persistence.matches;

import com.ablanco.teemo.model.matches.ParticipantTimelineData;
import com.ablanco.teemo.persistence.base.BaseComplexReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantTimelineDataDAO extends BaseComplexReferencedDAO<ParticipantTimelineData> {


    public ParticipantTimelineDataDAO() {
        super(ParticipantTimelineData.class);
    }
}
