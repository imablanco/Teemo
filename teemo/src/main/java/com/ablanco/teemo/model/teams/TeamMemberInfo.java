package com.ablanco.teemo.model.teams;

import com.ablanco.teemo.model.BaseObject;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamMemberInfo extends BaseObject {

    private Long inviteDate;
    private Long joinDate;
    private Long playerId;

    private String status;

    public Long getInviteDate() {
        return inviteDate;
    }

    public void setInviteDate(Long inviteDate) {
        this.inviteDate = inviteDate;
    }

    public Long getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Long joinDate) {
        this.joinDate = joinDate;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
