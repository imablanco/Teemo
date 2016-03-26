package com.ablanco.teemo.model.matches;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class Event extends BaseObject {

    private String ascendedType, buildingType, eventType, laneType, levelUpType, monsterType, pointCaptured, towerType, wardType;
    private List<Integer> assistingParticipantIds;
    private Integer creatorId, itemAfter, itemBefore, itemId, killerId, participantId, skillSlot, teamId, victimId;
    private Position position;

    public String getAscendedType() {
        return ascendedType;
    }

    public void setAscendedType(String ascendedType) {
        this.ascendedType = ascendedType;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getLaneType() {
        return laneType;
    }

    public void setLaneType(String laneType) {
        this.laneType = laneType;
    }

    public String getLevelUpType() {
        return levelUpType;
    }

    public void setLevelUpType(String levelUpType) {
        this.levelUpType = levelUpType;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public String getPointCaptured() {
        return pointCaptured;
    }

    public void setPointCaptured(String pointCaptured) {
        this.pointCaptured = pointCaptured;
    }

    public String getTowerType() {
        return towerType;
    }

    public void setTowerType(String towerType) {
        this.towerType = towerType;
    }

    public String getWardType() {
        return wardType;
    }

    public void setWardType(String wardType) {
        this.wardType = wardType;
    }

    public List<Integer> getAssistingParticipantIds() {
        return assistingParticipantIds;
    }

    public void setAssistingParticipantIds(List<Integer> assistingParticipantIds) {
        this.assistingParticipantIds = assistingParticipantIds;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getItemAfter() {
        return itemAfter;
    }

    public void setItemAfter(Integer itemAfter) {
        this.itemAfter = itemAfter;
    }

    public Integer getItemBefore() {
        return itemBefore;
    }

    public void setItemBefore(Integer itemBefore) {
        this.itemBefore = itemBefore;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getKillerId() {
        return killerId;
    }

    public void setKillerId(Integer killerId) {
        this.killerId = killerId;
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public Integer getSkillSlot() {
        return skillSlot;
    }

    public void setSkillSlot(Integer skillSlot) {
        this.skillSlot = skillSlot;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getVictimId() {
        return victimId;
    }

    public void setVictimId(Integer victimId) {
        this.victimId = victimId;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
