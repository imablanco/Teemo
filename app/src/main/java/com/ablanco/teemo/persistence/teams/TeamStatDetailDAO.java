package com.ablanco.teemo.persistence.teams;

import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.model.teams.TeamStatDetail;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamStatDetailDAO extends BaseReferencedDAO<TeamStatDetail, Team> {

    public TeamStatDetailDAO() {
        super(TeamStatDetail.class);
    }
}
