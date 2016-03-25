package com.ablanco.teemo.model;

import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.constants.Season;
import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.persistence.base.DBHelper;
import com.ablanco.teemo.persistence.matchlist.MatchListDAO;

import java.util.Arrays;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchListModelTest extends BaseModelTest {

    public void testMatchListModel(){
        MatchList matchList = new MatchList();

        matchList.setSummonerId(TestConstants.SUMMONER_ID);

        MatchListDAO matchListDAO = new MatchListDAO();

        matchListDAO.save(matchList,null, DBHelper.storeStringArray(Arrays.asList(Season.PRESEASON2014, Season.PRESEASON2015)), (long) 3, null, null);

        matchListDAO.starQuery(TestConstants.SUMMONER_ID);

        matchListDAO.queryWithSeasons(Arrays.asList(Season.PRESEASON2014, Season.PRESEASON2015));
        matchListDAO.queryWithBeginTime(3l);

        assertTrue(matchListDAO.find() != null);
    }
}
