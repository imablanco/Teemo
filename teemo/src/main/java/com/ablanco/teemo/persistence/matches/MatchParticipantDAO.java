package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.model.matches.MatchMastery;
import com.ablanco.teemo.model.matches.MatchParticipant;
import com.ablanco.teemo.model.matches.MatchRune;
import com.ablanco.teemo.model.matches.ParticipantStats;
import com.ablanco.teemo.model.matches.ParticipantTimeline;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchParticipantDAO extends BaseReferencedDAO<MatchParticipant, MatchDetail> {


    public MatchParticipantDAO() {
        super(MatchParticipant.class);
    }

    @Override
    public long save(MatchParticipant object, MatchDetail parent) {
        long id = super.save(object, parent);

        if(id > -1){

            MatchMasteryDAO masteryDAO = new MatchMasteryDAO();
            List<MatchMastery> matchMasteries = masteryDAO.findFromParent(object);
            masteryDAO.deleteAll(matchMasteries);
            masteryDAO.saveAll(object.getMasteries(), object);

            MatchRuneDAO matchRuneDAO = new MatchRuneDAO();
            List<MatchRune> matchRunes = matchRuneDAO.findFromParent(object);
            matchRuneDAO.deleteAll(matchRunes);
            matchRuneDAO.saveAll(object.getRunes(), object);

            ParticipantTimelineDAO participantTimelineDAO = new ParticipantTimelineDAO();
            List<ParticipantTimeline> participantTimelines = participantTimelineDAO.findFromParent(object);
            participantTimelineDAO.deleteAll(participantTimelines);
            participantTimelineDAO.save(object.getTimeline(), object);

            ParticipantStatsDAO participantStatsDAO = new ParticipantStatsDAO();
            List<ParticipantStats> participantStatses = participantStatsDAO.findFromParent(object);
            participantStatsDAO.deleteAll(participantStatses);
            participantStatsDAO.save(object.getStats(), object);

        }

        return id;
    }

    @Override
    public void delete(MatchParticipant object) {

        MatchMasteryDAO masteryDAO = new MatchMasteryDAO();
        List<MatchMastery> matchMasteries = masteryDAO.findFromParent(object);
        masteryDAO.deleteAll(matchMasteries);

        MatchRuneDAO matchRuneDAO = new MatchRuneDAO();
        List<MatchRune> matchRunes = matchRuneDAO.findFromParent(object);
        matchRuneDAO.deleteAll(matchRunes);

        ParticipantTimelineDAO participantTimelineDAO = new ParticipantTimelineDAO();
        List<ParticipantTimeline> participantTimelines = participantTimelineDAO.findFromParent(object);
        participantTimelineDAO.deleteAll(participantTimelines);

        ParticipantStatsDAO participantStatsDAO = new ParticipantStatsDAO();
        List<ParticipantStats> participantStatses = participantStatsDAO.findFromParent(object);
        participantStatsDAO.deleteAll(participantStatses);

        super.delete(object);
    }

    @Override
    public MatchParticipant fromCursor(Cursor c) {
        MatchParticipant object = super.fromCursor(c);

        if(object != null){
            MatchMasteryDAO masteryDAO = new MatchMasteryDAO();
            List<MatchMastery> matchMasteries = masteryDAO.findFromParent(object);
            object.setMasteries(matchMasteries);

            MatchRuneDAO matchRuneDAO = new MatchRuneDAO();
            List<MatchRune> matchRunes = matchRuneDAO.findFromParent(object);
            object.setRunes(matchRunes);

            ParticipantTimelineDAO participantTimelineDAO = new ParticipantTimelineDAO();
            ParticipantTimeline participantTimelines = participantTimelineDAO.findFirstFromParent(object);
            object.setTimeline(participantTimelines);

            ParticipantStatsDAO participantStatsDAO = new ParticipantStatsDAO();
            ParticipantStats participantStatses = participantStatsDAO.findFirstFromParent(object);
            object.setStats(participantStatses);
        }

        return object;
    }
}
