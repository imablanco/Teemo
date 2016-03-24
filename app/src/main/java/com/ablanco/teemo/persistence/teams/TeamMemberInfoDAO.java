package com.ablanco.teemo.persistence.teams;

import com.ablanco.teemo.model.teams.Roster;
import com.ablanco.teemo.model.teams.TeamMemberInfo;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamMemberInfoDAO extends BaseReferencedDAO<TeamMemberInfo, Roster> {

    public TeamMemberInfoDAO() {
        super(TeamMemberInfo.class);
    }
}
