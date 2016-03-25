package com.ablanco.teemo.persistence.matchlist;

import android.database.Cursor;

import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.model.matchlist.MatchReference;
import com.ablanco.teemo.persistence.base.BaseDAO;
import com.ablanco.teemo.persistence.base.DBHelper;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchListDAO extends BaseDAO<MatchList> {

    private QueryBuilder<MatchList> matchListQueryBuilder;

    public MatchListDAO() {
        super(MatchList.class);
        expirationTime = DBHelper.REFRESH_FREQUENCY_MINUTE;
    }

    public long save(MatchList object, String championIds, String seasons, Long beginTime, Long endTime, String queues) {

        object.setRankedQueues(queues);
        object.setSeasons(seasons);
        object.setChampionIds(championIds);
        object.setBeginTime(beginTime);
        object.setEndTime(endTime);

        long id = super.save(object);

        if(id > -1){

            MatchReferenceDAO matchReferenceDAO = new MatchReferenceDAO();
            List<MatchReference> matchReferences = matchReferenceDAO.findFromParent(object);
            matchReferenceDAO.deleteAll(matchReferences);
            matchReferenceDAO.saveAll(object.getMatches(), object);
        }

        return id;
    }

    @Override
    public void delete(MatchList object) {

        MatchReferenceDAO matchReferenceDAO = new MatchReferenceDAO();
        List<MatchReference> matchReferences = matchReferenceDAO.findFromParent(object);
        matchReferenceDAO.deleteAll(matchReferences);

        super.delete(object);
    }

    @Override
    public MatchList fromCursor(Cursor c) {
        MatchList object = super.fromCursor(c);

        if(object != null){
            MatchReferenceDAO matchReferenceDAO = new MatchReferenceDAO();
            List<MatchReference> matchReferences = matchReferenceDAO.findFromParent(object);
            object.setMatches(matchReferences);

        }
        return object;
    }

    public QueryBuilder<MatchList> starQuery(Long summonerId){
        matchListQueryBuilder = new QueryBuilder<>(MatchList.class);
        matchListQueryBuilder.where("summonerId", String.valueOf(summonerId));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithChampionIds(List<String> championIds){
        checkStarted();
        matchListQueryBuilder.where("championIds", DBHelper.storeStringArray(championIds));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithSeasons(List<String> seasons){
        checkStarted();
        matchListQueryBuilder.where("seasons", DBHelper.storeStringArray(seasons));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithRankedQueues(List<String> queues){
        checkStarted();
        matchListQueryBuilder.where("rankedQueues", DBHelper.storeStringArray(queues));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithBeginIndex(Integer beginIndex){
        checkStarted();
        matchListQueryBuilder.where("startIndex", String.valueOf(beginIndex));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithEndIndex(Integer endIndex){
        checkStarted();
        matchListQueryBuilder.where("endIndex", String.valueOf(endIndex));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithBeginTime(Long beginTime){
        checkStarted();
        matchListQueryBuilder.where("beginTime", String.valueOf(beginTime));
        return matchListQueryBuilder;
    }

    public QueryBuilder<MatchList> queryWithEndTime(Long endTime){
        checkStarted();
        matchListQueryBuilder.where("endTime", String.valueOf(endTime));
        return matchListQueryBuilder;
    }

    public MatchList find(){
        return matchListQueryBuilder.findFirst();
    }

    private void checkStarted(){
        if(matchListQueryBuilder == null){
            throw new IllegalStateException("Builder not initialized");
        }
    }

}
