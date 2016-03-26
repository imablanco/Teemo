package com.ablanco.teemo.persistence.currentgames;

import com.ablanco.teemo.model.currentgames.CurrentGameInfo;
import com.ablanco.teemo.model.currentgames.CurrentGameParticipant;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class CurrentGameParticipantDAO extends BaseReferencedDAO<CurrentGameParticipant, CurrentGameInfo> {
    public CurrentGameParticipantDAO() {
        super(CurrentGameParticipant.class);
    }
}
