package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.matchlist.MatchList;
import com.ablanco.teemo.persistence.base.DBHelper;
import com.ablanco.teemo.persistence.matchlist.MatchListDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.MatchListServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitMatchListServiceHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class MatchListServiceHandler extends BaseRetrofitServiceClass<RetrofitMatchListServiceHandler> implements MatchListServiceI {

    public MatchListServiceHandler(RetrofitMatchListServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getMatchListBySummonerId(final long summonerId, final List<String> championIds, final List<String> seasons, final List<String> rankedQueues, final Long beginTime, final Long endTime, final Integer beginIndex, final Integer endIndex, ServiceResponseListener<MatchList> listener) {
        BaseServiceAsyncTask<MatchList> task = new BaseServiceAsyncTask<MatchList>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    MatchListDAO dao = new MatchListDAO();

                    dao.starQuery(summonerId);

                    if(championIds != null && !championIds.isEmpty()){
                        dao.queryWithChampionIds(championIds);
                    }

                    if(rankedQueues != null && !rankedQueues.isEmpty()){
                        dao.queryWithRankedQueues(rankedQueues);
                    }

                    if(seasons != null && !seasons.isEmpty()){
                        dao.queryWithSeasons(seasons);
                    }

                    if(beginTime != null){
                        dao.queryWithBeginTime(beginTime);
                    }

                    if(endTime != null){
                        dao.queryWithEndTime(endTime);
                    }

                    if(beginIndex != null){
                        dao.queryWithBeginIndex(beginIndex);
                    }

                    if(endIndex != null){
                        dao.queryWithEndIndex(endIndex);
                    }

                    MatchList cache = dao.find();

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<MatchList> call = mHandler.getMatchListBySummonerId(APIConfigurationContext.REGION, summonerId, DBHelper.storeStringArray(championIds), DBHelper.storeStringArray(rankedQueues), DBHelper.storeStringArray(seasons), beginTime, endTime, beginIndex, endIndex);
                        final Response<MatchList> response = call.execute();

                        if(response.isSuccessful()){

                            dao.save(response.body(), DBHelper.storeStringArray(championIds), DBHelper.storeStringArray(seasons), beginTime, endTime, DBHelper.storeStringArray(seasons));

                            return response.body();

                        }else {

                            if(response.code() == TeemoException.CODE_RATE_LIMIT_EXCEEDED){
                                RateLimiter.getInstance().updateLimitRateExceeded(response);
                            }

                            return new TeemoException(response);
                        }

                    }else {
                        return TeemoException.RATE_LIMITED_EXCEPTION;
                    }

                }catch (Exception e){
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
