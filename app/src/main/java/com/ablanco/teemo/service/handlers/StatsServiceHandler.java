package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.stats.PlayerStatsSummaryList;
import com.ablanco.teemo.model.stats.RankedStats;
import com.ablanco.teemo.persistence.stats.PlayerStatsSummaryListDAO;
import com.ablanco.teemo.persistence.stats.RankedStatsDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.StatsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitStatsServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class StatsServiceHandler extends BaseRetrofitServiceClass<RetrofitStatsServiceHandler> implements StatsServiceI {

    public StatsServiceHandler(RetrofitStatsServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getRankedStatsBySummonerAndSeason(final long summonerId, final String season, ServiceResponseListener<RankedStats> listener) {

        BaseServiceAsyncTask<RankedStats> task = new BaseServiceAsyncTask<RankedStats>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    RankedStatsDAO dao = new RankedStatsDAO();

                    RankedStats cache = dao.findBySummonerIdandSeason(summonerId, season);

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<RankedStats> call = mHandler.getRankedStatsBySummoner(APIConfigurationContext.REGION, summonerId, season);
                        final Response<RankedStats> response = call.execute();

                        if(response.isSuccessful()){

                            dao.save(response.body(), season);

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

    @Override
    public void getPlayerStatsSummaryBySummonerAndSeason(final long summonerId, final String season,ServiceResponseListener<PlayerStatsSummaryList> listener) {
        BaseServiceAsyncTask<PlayerStatsSummaryList> task = new BaseServiceAsyncTask<PlayerStatsSummaryList>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    PlayerStatsSummaryListDAO dao = new PlayerStatsSummaryListDAO();

                    PlayerStatsSummaryList cache = dao.findBySummonerIdandSeason(summonerId, season);

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<PlayerStatsSummaryList> call = mHandler.getPlayerStatsSummaryBySummoner(APIConfigurationContext.REGION, summonerId, season);
                        final Response<PlayerStatsSummaryList> response = call.execute();

                        if(response.isSuccessful()){

                            dao.save(response.body(), season);

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
