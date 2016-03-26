package com.ablanco.teemo.model;

import com.ablanco.teemo.model.matches.Event;
import com.ablanco.teemo.model.matches.Frame;
import com.ablanco.teemo.model.matches.MatchBannedChampion;
import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.model.matches.MatchMastery;
import com.ablanco.teemo.model.matches.MatchParticipant;
import com.ablanco.teemo.model.matches.MatchPlayer;
import com.ablanco.teemo.model.matches.MatchRune;
import com.ablanco.teemo.model.matches.MatchTeam;
import com.ablanco.teemo.model.matches.ParticipantFrame;
import com.ablanco.teemo.model.matches.ParticipantIdentity;
import com.ablanco.teemo.model.matches.ParticipantStats;
import com.ablanco.teemo.model.matches.ParticipantTimeline;
import com.ablanco.teemo.model.matches.ParticipantTimelineData;
import com.ablanco.teemo.model.matches.Timeline;
import com.ablanco.teemo.persistence.matches.EventDAO;
import com.ablanco.teemo.persistence.matches.FrameDAO;
import com.ablanco.teemo.persistence.matches.MatchDetailDAO;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchesModelTest extends BaseModelTest{

    public void testEvent(){

        Event event = new Event();

        event.setAssistingParticipantIds(Arrays.asList(1,2,3,4,5,6,7,8,9));

        EventDAO eventDAO = new EventDAO();

        Frame frame = new Frame();
        frame.set_id(1l);

        eventDAO.save(event, frame);

        assertTrue(!eventDAO.findFirstFromParent(frame).getAssistingParticipantIds().isEmpty());
    }

    public void testFrame(){

        Frame frame = new Frame();

        Event event = new Event();
        event.setAssistingParticipantIds(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        Map<String, ParticipantFrame> frameMap = new HashMap<>();

        ParticipantFrame participantFrame = new ParticipantFrame();
        participantFrame.setParticipantId(1);

        frameMap.put("1", participantFrame);

        participantFrame = new ParticipantFrame();

        participantFrame.setParticipantId(2);

        frameMap.put("2", participantFrame);

        frame.setEvents(Collections.singletonList(event));
        frame.setParticipantFrames(frameMap);

        FrameDAO frameDAO = new FrameDAO();

        Timeline timeline = new Timeline();
        timeline.set_id(2l);

        frameDAO.save(frame, timeline);

        frame = frameDAO.findFirstFromParent(timeline);

        assertTrue(frame != null);
        assertTrue(frame.getEvents().get(0).getAssistingParticipantIds().size() == 9);
        assertTrue(frame.getParticipantFrames().get("1").getParticipantId() == 1);
        assertTrue(frame.getParticipantFrames().get("2").getParticipantId() == 2);

    }

    public void testMatchDetail(){

        //first build from bottom classes tu upper classes

        //ParticipantIdentity first
        ParticipantIdentity participantIdentity = new ParticipantIdentity();
        participantIdentity.setParticipantId(1);
        MatchPlayer matchPlayer = new MatchPlayer();
        matchPlayer.setSummonerId(2l);
        participantIdentity.setPlayer(matchPlayer);

        //MatchParticipant
        MatchParticipant matchParticipant = new MatchParticipant();
        matchParticipant.setParticipantId(3);

        ParticipantTimeline participantTimeline = new ParticipantTimeline();

        ParticipantTimelineData data = new ParticipantTimelineData();
        data.setTenToTwenty(4.0);

        participantTimeline.setAncientGolemKillsPerMinCounts(data);

        ParticipantStats participantStats = new ParticipantStats();
        participantStats.setAssists(5l);

        MatchMastery matchMastery = new MatchMastery();
        matchMastery.setMasteryId(6l);

        MatchRune matchRune = new MatchRune();
        matchRune.setRuneId(7l);

        matchParticipant.setTimeline(participantTimeline);
        matchParticipant.setStats(participantStats);
        matchParticipant.setMasteries(Collections.singletonList(matchMastery));
        matchParticipant.setRunes(Collections.singletonList(matchRune));


        //team
        MatchTeam team = new MatchTeam();

        MatchBannedChampion matchBannedChampion = new MatchBannedChampion();
        matchBannedChampion.setChampionId(8);

        team.setBans(Collections.singletonList(matchBannedChampion));

        //timeline

        Timeline timeline = new Timeline();

        Frame frame = new Frame();

        Event event = new Event();
        event.setAssistingParticipantIds(Arrays.asList(1, 2, 3, 4, 5));

        ParticipantFrame participantFrame = new ParticipantFrame();
        participantFrame.setParticipantId(9);

        frame.setEvents(Collections.singletonList(event));
        frame.setParticipantFrames(Collections.singletonMap("9", participantFrame));

        timeline.setFrames(Collections.singletonList(frame));

        MatchDetail matchDetail = new MatchDetail();

        matchDetail.setTeams(Collections.singletonList(team));
        matchDetail.setTimeline(timeline);
        matchDetail.setParticipants(Collections.singletonList(matchParticipant));
        matchDetail.setParticipantIdentities(Collections.singletonList(participantIdentity));
        matchDetail.setMatchId(10l);

        MatchDetailDAO dao = new MatchDetailDAO();
        dao.save(matchDetail, true);

        matchDetail = dao.findByMatchIdAndIncludeTimeLine(10l, true);
        assertTrue(matchDetail.getMatchId() == 10l);
    }
}
