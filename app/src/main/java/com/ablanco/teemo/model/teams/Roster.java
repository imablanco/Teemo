package com.ablanco.teemo.model.teams;

import com.ablanco.teemo.model.BaseObject;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class Roster extends BaseObject {

    private List<TeamMemberInfo> memberList;

    private long ownerId;

    public List<TeamMemberInfo> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<TeamMemberInfo> memberList) {
        this.memberList = memberList;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
}
