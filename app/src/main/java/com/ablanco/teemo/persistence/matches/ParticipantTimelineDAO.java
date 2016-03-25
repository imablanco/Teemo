package com.ablanco.teemo.persistence.matches;

import android.database.Cursor;

import com.ablanco.teemo.model.matches.MatchParticipant;
import com.ablanco.teemo.model.matches.ParticipantTimeline;
import com.ablanco.teemo.model.matches.ParticipantTimelineData;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class ParticipantTimelineDAO extends BaseReferencedDAO<ParticipantTimeline, MatchParticipant> {

    private final String ancientGolemAssistsPerMinCounts = "ancientGolemAssistsPerMinCounts";
    private final String ancientGolemKillsPerMinCounts = "ancientGolemKillsPerMinCounts";
    private final String assistedLaneDeathsPerMinDeltas = "assistedLaneDeathsPerMinDeltas";
    private final String assistedLaneKillsPerMinDeltas = "assistedLaneKillsPerMinDeltas";
    private final String baronAssistsPerMinCounts = "baronAssistsPerMinCounts";
    private final String baronKillsPerMinCounts = "baronKillsPerMinCounts";
    private final String creepsPerMinDeltas = "creepsPerMinDeltas";
    private final String csDiffPerMinDeltas = "csDiffPerMinDeltas";
    private final String damageTakenDiffPerMinDeltas = "damageTakenDiffPerMinDeltas";
    private final String damageTakenPerMinDeltas = "damageTakenPerMinDeltas";
    private final String dragonAssistsPerMinCounts = "dragonAssistsPerMinCounts";
    private final String dragonKillsPerMinCounts = "dragonKillsPerMinCounts";
    private final String elderLizardAssistsPerMinCounts = "elderLizardAssistsPerMinCounts";
    private final String elderLizardKillsPerMinCounts = "elderLizardKillsPerMinCounts";
    private final String goldPerMinDeltas = "goldPerMinDeltas";
    private final String inhibitorAssistsPerMinCounts = "inhibitorAssistsPerMinCounts";
    private final String inhibitorKillsPerMinCounts = "inhibitorKillsPerMinCounts";
    private final String towerAssistsPerMinCounts = "towerAssistsPerMinCounts";
    private final String towerKillsPerMinCounts = "towerKillsPerMinCounts";
    private final String towerKillsPerMinDeltas = "towerKillsPerMinDeltas";
    private final String vilemawAssistsPerMinCounts = "vilemawAssistsPerMinCounts";
    private final String vilemawKillsPerMinCounts = "vilemawKillsPerMinCounts";
    private final String wardsPerMinDeltas = "wardsPerMinDeltas";
    private final String xpDiffPerMinDeltas = "xpDiffPerMinDeltas";
    private final String xpPerMinDeltas = "xpPerMinDeltas";

    public ParticipantTimelineDAO() {
        super(ParticipantTimeline.class);
    }

    @Override
    public long save(ParticipantTimeline object, MatchParticipant parent) {
        long id = super.save(object, parent);

        if(id > -1){

            ParticipantTimelineDataDAO dao = new ParticipantTimelineDataDAO();
            ParticipantTimelineData ancientGolemAssistsPerMinCounts = dao.findFirstFromParent(object, this.ancientGolemAssistsPerMinCounts);
            ParticipantTimelineData ancientGolemKillsPerMinCounts = dao.findFirstFromParent(object, this.ancientGolemKillsPerMinCounts);
            ParticipantTimelineData assistedLaneDeathsPerMinDeltas = dao.findFirstFromParent(object, this.assistedLaneDeathsPerMinDeltas);
            ParticipantTimelineData assistedLaneKillsPerMinDeltas = dao.findFirstFromParent(object, this.assistedLaneKillsPerMinDeltas);
            ParticipantTimelineData baronAssistsPerMinCounts = dao.findFirstFromParent(object, this.baronAssistsPerMinCounts);
            ParticipantTimelineData baronKillsPerMinCounts = dao.findFirstFromParent(object, this.baronKillsPerMinCounts);
            ParticipantTimelineData creepsPerMinDeltas = dao.findFirstFromParent(object, this.creepsPerMinDeltas);
            ParticipantTimelineData csDiffPerMinDeltas = dao.findFirstFromParent(object, this.csDiffPerMinDeltas);
            ParticipantTimelineData damageTakenDiffPerMinDeltas = dao.findFirstFromParent(object, this.damageTakenDiffPerMinDeltas);
            ParticipantTimelineData damageTakenPerMinDeltas = dao.findFirstFromParent(object, this.damageTakenPerMinDeltas);
            ParticipantTimelineData dragonAssistsPerMinCounts = dao.findFirstFromParent(object, this.dragonAssistsPerMinCounts);
            ParticipantTimelineData dragonKillsPerMinCounts = dao.findFirstFromParent(object, this.dragonKillsPerMinCounts);
            ParticipantTimelineData elderLizardAssistsPerMinCounts = dao.findFirstFromParent(object, this.elderLizardAssistsPerMinCounts);
            ParticipantTimelineData elderLizardKillsPerMinCounts = dao.findFirstFromParent(object, this.elderLizardKillsPerMinCounts);
            ParticipantTimelineData goldPerMinDeltas = dao.findFirstFromParent(object, this.goldPerMinDeltas);
            ParticipantTimelineData inhibitorAssistsPerMinCounts = dao.findFirstFromParent(object, this.inhibitorAssistsPerMinCounts);
            ParticipantTimelineData inhibitorKillsPerMinCounts = dao.findFirstFromParent(object, this.inhibitorKillsPerMinCounts);
            ParticipantTimelineData towerAssistsPerMinCounts = dao.findFirstFromParent(object, this.towerAssistsPerMinCounts);
            ParticipantTimelineData towerKillsPerMinCounts = dao.findFirstFromParent(object, this.towerKillsPerMinCounts);
            ParticipantTimelineData towerKillsPerMinDeltas = dao.findFirstFromParent(object, this.towerKillsPerMinDeltas);
            ParticipantTimelineData vilemawAssistsPerMinCounts = dao.findFirstFromParent(object, this.vilemawAssistsPerMinCounts);
            ParticipantTimelineData vilemawKillsPerMinCounts = dao.findFirstFromParent(object, this.vilemawKillsPerMinCounts);
            ParticipantTimelineData wardsPerMinDeltas = dao.findFirstFromParent(object, this.wardsPerMinDeltas);
            ParticipantTimelineData xpDiffPerMinDeltas = dao.findFirstFromParent(object, this.xpDiffPerMinDeltas);
            ParticipantTimelineData xpPerMinDeltas = dao.findFirstFromParent(object, this.xpPerMinDeltas);

            dao.delete(ancientGolemAssistsPerMinCounts);
            dao.delete(ancientGolemKillsPerMinCounts);
            dao.delete(assistedLaneDeathsPerMinDeltas);
            dao.delete(assistedLaneKillsPerMinDeltas);
            dao.delete(baronAssistsPerMinCounts);
            dao.delete(baronKillsPerMinCounts);
            dao.delete(creepsPerMinDeltas);
            dao.delete(csDiffPerMinDeltas);
            dao.delete(damageTakenDiffPerMinDeltas);
            dao.delete(damageTakenPerMinDeltas);
            dao.delete(dragonAssistsPerMinCounts);
            dao.delete(dragonKillsPerMinCounts);
            dao.delete(elderLizardAssistsPerMinCounts);
            dao.delete(elderLizardKillsPerMinCounts);
            dao.delete(goldPerMinDeltas);
            dao.delete(inhibitorAssistsPerMinCounts);
            dao.delete(inhibitorKillsPerMinCounts);
            dao.delete(towerAssistsPerMinCounts);
            dao.delete(towerKillsPerMinCounts);
            dao.delete(towerKillsPerMinDeltas);
            dao.delete(vilemawAssistsPerMinCounts);
            dao.delete(vilemawKillsPerMinCounts);
            dao.delete(wardsPerMinDeltas);
            dao.delete(xpDiffPerMinDeltas);
            dao.delete(xpPerMinDeltas);

            dao.save(ancientGolemAssistsPerMinCounts, object, this.ancientGolemAssistsPerMinCounts);
            dao.save(ancientGolemKillsPerMinCounts, object, this.ancientGolemKillsPerMinCounts);
            dao.save(assistedLaneDeathsPerMinDeltas, object, this.assistedLaneDeathsPerMinDeltas);
            dao.save(assistedLaneKillsPerMinDeltas, object, this.assistedLaneKillsPerMinDeltas);
            dao.save(baronAssistsPerMinCounts, object, this.baronAssistsPerMinCounts);
            dao.save(baronKillsPerMinCounts, object, this.baronKillsPerMinCounts);
            dao.save(creepsPerMinDeltas, object, this.creepsPerMinDeltas);
            dao.save(csDiffPerMinDeltas, object, this.csDiffPerMinDeltas);
            dao.save(damageTakenDiffPerMinDeltas, object, this.damageTakenDiffPerMinDeltas);
            dao.save(damageTakenPerMinDeltas, object, this.damageTakenPerMinDeltas);
            dao.save(dragonAssistsPerMinCounts, object, this.dragonAssistsPerMinCounts);
            dao.save(dragonKillsPerMinCounts, object, this.dragonKillsPerMinCounts);
            dao.save(elderLizardAssistsPerMinCounts, object, this.elderLizardAssistsPerMinCounts);
            dao.save(elderLizardKillsPerMinCounts, object, this.elderLizardKillsPerMinCounts);
            dao.save(goldPerMinDeltas, object, this.goldPerMinDeltas);
            dao.save(inhibitorAssistsPerMinCounts, object, this.inhibitorAssistsPerMinCounts);
            dao.save(inhibitorKillsPerMinCounts, object, this.inhibitorKillsPerMinCounts);
            dao.save(towerAssistsPerMinCounts, object, this.towerAssistsPerMinCounts);
            dao.save(towerKillsPerMinCounts, object, this.towerKillsPerMinCounts);
            dao.save(towerKillsPerMinDeltas, object, this.towerKillsPerMinDeltas);
            dao.save(vilemawAssistsPerMinCounts, object, this.vilemawAssistsPerMinCounts);
            dao.save(vilemawKillsPerMinCounts, object, this.vilemawKillsPerMinCounts);
            dao.save(wardsPerMinDeltas, object, this.wardsPerMinDeltas);
            dao.save(xpDiffPerMinDeltas, object, this.xpDiffPerMinDeltas);
            dao.save(xpPerMinDeltas, object, this.xpPerMinDeltas);

        }

        return id;
    }

    @Override
    public void delete(ParticipantTimeline object) {

        ParticipantTimelineDataDAO dao = new ParticipantTimelineDataDAO();
        ParticipantTimelineData ancientGolemAssistsPerMinCounts = dao.findFirstFromParent(object, this.ancientGolemAssistsPerMinCounts);
        ParticipantTimelineData ancientGolemKillsPerMinCounts = dao.findFirstFromParent(object, this.ancientGolemKillsPerMinCounts);
        ParticipantTimelineData assistedLaneDeathsPerMinDeltas = dao.findFirstFromParent(object, this.assistedLaneDeathsPerMinDeltas);
        ParticipantTimelineData assistedLaneKillsPerMinDeltas = dao.findFirstFromParent(object, this.assistedLaneKillsPerMinDeltas);
        ParticipantTimelineData baronAssistsPerMinCounts = dao.findFirstFromParent(object, this.baronAssistsPerMinCounts);
        ParticipantTimelineData baronKillsPerMinCounts = dao.findFirstFromParent(object, this.baronKillsPerMinCounts);
        ParticipantTimelineData creepsPerMinDeltas = dao.findFirstFromParent(object, this.creepsPerMinDeltas);
        ParticipantTimelineData csDiffPerMinDeltas = dao.findFirstFromParent(object, this.csDiffPerMinDeltas);
        ParticipantTimelineData damageTakenDiffPerMinDeltas = dao.findFirstFromParent(object, this.damageTakenDiffPerMinDeltas);
        ParticipantTimelineData damageTakenPerMinDeltas = dao.findFirstFromParent(object, this.damageTakenPerMinDeltas);
        ParticipantTimelineData dragonAssistsPerMinCounts = dao.findFirstFromParent(object, this.dragonAssistsPerMinCounts);
        ParticipantTimelineData dragonKillsPerMinCounts = dao.findFirstFromParent(object, this.dragonKillsPerMinCounts);
        ParticipantTimelineData elderLizardAssistsPerMinCounts = dao.findFirstFromParent(object, this.elderLizardAssistsPerMinCounts);
        ParticipantTimelineData elderLizardKillsPerMinCounts = dao.findFirstFromParent(object, this.elderLizardKillsPerMinCounts);
        ParticipantTimelineData goldPerMinDeltas = dao.findFirstFromParent(object, this.goldPerMinDeltas);
        ParticipantTimelineData inhibitorAssistsPerMinCounts = dao.findFirstFromParent(object, this.inhibitorAssistsPerMinCounts);
        ParticipantTimelineData inhibitorKillsPerMinCounts = dao.findFirstFromParent(object, this.inhibitorKillsPerMinCounts);
        ParticipantTimelineData towerAssistsPerMinCounts = dao.findFirstFromParent(object, this.towerAssistsPerMinCounts);
        ParticipantTimelineData towerKillsPerMinCounts = dao.findFirstFromParent(object, this.towerKillsPerMinCounts);
        ParticipantTimelineData towerKillsPerMinDeltas = dao.findFirstFromParent(object, this.towerKillsPerMinDeltas);
        ParticipantTimelineData vilemawAssistsPerMinCounts = dao.findFirstFromParent(object, this.vilemawAssistsPerMinCounts);
        ParticipantTimelineData vilemawKillsPerMinCounts = dao.findFirstFromParent(object, this.vilemawKillsPerMinCounts);
        ParticipantTimelineData wardsPerMinDeltas = dao.findFirstFromParent(object, this.wardsPerMinDeltas);
        ParticipantTimelineData xpDiffPerMinDeltas = dao.findFirstFromParent(object, this.xpDiffPerMinDeltas);
        ParticipantTimelineData xpPerMinDeltas = dao.findFirstFromParent(object, this.xpPerMinDeltas);

        dao.delete(ancientGolemAssistsPerMinCounts);
        dao.delete(ancientGolemKillsPerMinCounts);
        dao.delete(assistedLaneDeathsPerMinDeltas);
        dao.delete(assistedLaneKillsPerMinDeltas);
        dao.delete(baronAssistsPerMinCounts);
        dao.delete(baronKillsPerMinCounts);
        dao.delete(creepsPerMinDeltas);
        dao.delete(csDiffPerMinDeltas);
        dao.delete(damageTakenDiffPerMinDeltas);
        dao.delete(damageTakenPerMinDeltas);
        dao.delete(dragonAssistsPerMinCounts);
        dao.delete(dragonKillsPerMinCounts);
        dao.delete(elderLizardAssistsPerMinCounts);
        dao.delete(elderLizardKillsPerMinCounts);
        dao.delete(goldPerMinDeltas);
        dao.delete(inhibitorAssistsPerMinCounts);
        dao.delete(inhibitorKillsPerMinCounts);
        dao.delete(towerAssistsPerMinCounts);
        dao.delete(towerKillsPerMinCounts);
        dao.delete(towerKillsPerMinDeltas);
        dao.delete(vilemawAssistsPerMinCounts);
        dao.delete(vilemawKillsPerMinCounts);
        dao.delete(wardsPerMinDeltas);
        dao.delete(xpDiffPerMinDeltas);
        dao.delete(xpPerMinDeltas);

        super.delete(object);
    }

    @Override
    public ParticipantTimeline fromCursor(Cursor c) {
        ParticipantTimeline object = super.fromCursor(c);

        if(object != null){

            ParticipantTimelineDataDAO dao = new ParticipantTimelineDataDAO();
            object.setAncientGolemAssistsPerMinCounts(dao.findFirstFromParent(object, this.ancientGolemAssistsPerMinCounts));
            object.setAncientGolemKillsPerMinCounts(dao.findFirstFromParent(object, this.ancientGolemKillsPerMinCounts));
            object.setAssistedLaneDeathsPerMinDeltas(dao.findFirstFromParent(object, this.assistedLaneDeathsPerMinDeltas));
            object.setAssistedLaneKillsPerMinDeltas(dao.findFirstFromParent(object, this.assistedLaneKillsPerMinDeltas));
            object.setBaronAssistsPerMinCounts(dao.findFirstFromParent(object, this.baronAssistsPerMinCounts));
            object.setBaronKillsPerMinCounts(dao.findFirstFromParent(object, this.baronKillsPerMinCounts));
            object.setCreepsPerMinDeltas(dao.findFirstFromParent(object, this.creepsPerMinDeltas));
            object.setDamageTakenDiffPerMinDeltas(dao.findFirstFromParent(object, this.damageTakenDiffPerMinDeltas));
            object.setDamageTakenPerMinDeltas(dao.findFirstFromParent(object, this.damageTakenPerMinDeltas));
            object.setDragonAssistsPerMinCounts(dao.findFirstFromParent(object, this.dragonAssistsPerMinCounts));
            object.setDragonKillsPerMinCounts(dao.findFirstFromParent(object, this.dragonKillsPerMinCounts));
            object.setElderLizardAssistsPerMinCounts(dao.findFirstFromParent(object, this.elderLizardAssistsPerMinCounts));
            object.setElderLizardKillsPerMinCounts(dao.findFirstFromParent(object, this.elderLizardKillsPerMinCounts));
            object.setGoldPerMinDeltas(dao.findFirstFromParent(object, this.goldPerMinDeltas));
            object.setInhibitorAssistsPerMinCounts(dao.findFirstFromParent(object, this.inhibitorAssistsPerMinCounts));
            object.setInhibitorKillsPerMinCounts(dao.findFirstFromParent(object, this.inhibitorKillsPerMinCounts));
            object.setTowerAssistsPerMinCounts(dao.findFirstFromParent(object, this.towerAssistsPerMinCounts));
            object.setTowerKillsPerMinCounts(dao.findFirstFromParent(object, this.towerKillsPerMinCounts));
            object.setTowerKillsPerMinDeltas(dao.findFirstFromParent(object, this.towerKillsPerMinDeltas));
            object.setVilemawAssistsPerMinCounts(dao.findFirstFromParent(object, this.vilemawAssistsPerMinCounts));
            object.setVilemawKillsPerMinCounts(dao.findFirstFromParent(object, this.vilemawKillsPerMinCounts));
            object.setWardsPerMinDeltas(dao.findFirstFromParent(object, this.wardsPerMinDeltas));
            object.setXpDiffPerMinDeltas(dao.findFirstFromParent(object, this.xpDiffPerMinDeltas));
            object.setXpPerMinDeltas(dao.findFirstFromParent(object, this.xpPerMinDeltas));
        }

        return object;
    }
}
