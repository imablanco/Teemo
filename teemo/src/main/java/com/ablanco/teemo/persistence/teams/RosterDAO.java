package com.ablanco.teemo.persistence.teams;

import android.database.Cursor;

import com.ablanco.teemo.model.teams.Roster;
import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.model.teams.TeamMemberInfo;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class RosterDAO extends BaseReferencedDAO<Roster, Team> {

    public RosterDAO() {
        super(Roster.class);
    }

    @Override
    public long save(Roster object, Team parent) {
        long id =  super.save(object, parent);

        if(id > -1){
            TeamMemberInfoDAO dao = new TeamMemberInfoDAO();

            List<TeamMemberInfo> teamMemberInfos = dao.findFromParent(object);

            dao.deleteAll(teamMemberInfos);
            dao.saveAll(object.getMemberList(), object);
        }

        return id;
    }

    @Override
    public void delete(Roster object) {
        TeamMemberInfoDAO dao = new TeamMemberInfoDAO();

        List<TeamMemberInfo> teamMemberInfos = dao.findFromParent(object);

        dao.deleteAll(teamMemberInfos);

        super.delete(object);
    }

    @Override
    public Roster fromCursor(Cursor c) {
        Roster roster = super.fromCursor(c);

        if (roster != null){
            TeamMemberInfoDAO dao = new TeamMemberInfoDAO();
            List<TeamMemberInfo> teamMemberInfos = dao.findFromParent(roster);

            roster.setMemberList(teamMemberInfos);
        }

        return roster;
    }
}
