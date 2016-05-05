package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.model.matches.MatchParticipant;
import com.ablanco.teemo.model.matches.MatchTeam;
import com.ablanco.teemo.model.matches.ParticipantIdentity;
import com.ablanco.teemo.model.matches.Timeline;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchDetailDAO extends BaseDAO<MatchDetail> {

    public MatchDetailDAO() {
        super(MatchDetail.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_NEVER;
    }

    public long save(MatchDetail object, Boolean includeTimeline) {
        object.setIncludeTimeline(includeTimeline);
        long id = super.save(object);

        if(id > -1){
            ParticipantIdentityDAO participantIdentityDAO = new ParticipantIdentityDAO();
            List<ParticipantIdentity> participantIdentities = participantIdentityDAO.findFromParent(object);

            participantIdentityDAO.deleteAll(participantIdentities);
            participantIdentityDAO.saveAll(object.getParticipantIdentities(), object);

            TimelineDAO timelineDAO = new TimelineDAO();
            List<Timeline> timelines = timelineDAO.findFromParent(object);
            timelineDAO.deleteAll(timelines);
            timelineDAO.save(object.getTimeline(), object);

            MatchParticipantDAO matchParticipantDAO = new MatchParticipantDAO();
            List<MatchParticipant> matchParticipants = matchParticipantDAO.findFromParent(object);

            matchParticipantDAO.deleteAll(matchParticipants);
            matchParticipantDAO.saveAll(object.getParticipants(), object);

            MatchTeamDAO matchTeamDAO = new MatchTeamDAO();
            List<MatchTeam> matchTeams = matchTeamDAO.findFromParent(object);
            matchTeamDAO.deleteAll(matchTeams);
            matchTeamDAO.saveAll(object.getTeams(), object);
        }

        return id;
    }

    @Override
    public void delete(MatchDetail object) {
        ParticipantIdentityDAO participantIdentityDAO = new ParticipantIdentityDAO();
        List<ParticipantIdentity> participantIdentities = participantIdentityDAO.findFromParent(object);
        participantIdentityDAO.deleteAll(participantIdentities);

        TimelineDAO timelineDAO = new TimelineDAO();
        List<Timeline> timelines = timelineDAO.findFromParent(object);
        timelineDAO.deleteAll(timelines);

        MatchParticipantDAO matchParticipantDAO = new MatchParticipantDAO();
        List<MatchParticipant> matchParticipants = matchParticipantDAO.findFromParent(object);
        matchParticipantDAO.deleteAll(matchParticipants);

        MatchTeamDAO matchTeamDAO = new MatchTeamDAO();
        List<MatchTeam> matchTeams = matchTeamDAO.findFromParent(object);
        matchTeamDAO.deleteAll(matchTeams);

        super.delete(object);
    }

    @Override
    public MatchDetail fromCursor(Cursor c) {
        MatchDetail object = super.fromCursor(c);

        if (object != null){
            ParticipantIdentityDAO participantIdentityDAO = new ParticipantIdentityDAO();
            List<ParticipantIdentity> participantIdentities = participantIdentityDAO.findFromParent(object);
            object.setParticipantIdentities(participantIdentities);

            TimelineDAO timelineDAO = new TimelineDAO();
            Timeline timeline = timelineDAO.findFirstFromParent(object);
            object.setTimeline(timeline);

            MatchParticipantDAO matchParticipantDAO = new MatchParticipantDAO();
            List<MatchParticipant> matchParticipants = matchParticipantDAO.findFromParent(object);
            object.setParticipants(matchParticipants);

            MatchTeamDAO matchTeamDAO = new MatchTeamDAO();
            List<MatchTeam> matchTeams = matchTeamDAO.findFromParent(object);
            object.setTeams(matchTeams);
        }

        return object;
    }

    public MatchDetail findByMatchIdAndIncludeTimeLine(Long matchId, boolean includeTimeline){
        int convertedValue = includeTimeline ? 1 : 0;
        return findFirst("matchId = ? AND includeTimeline = ?", new String[]{String.valueOf(matchId), String.valueOf(convertedValue)}, null,null);

    }

}
