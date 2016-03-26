package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.leagues.League;
import com.ablanco.teemo.persistence.base.DBHelper;
import com.ablanco.teemo.persistence.leagues.LeagueDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.LeaguesServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitLeaguesServiceHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class LeaguesServiceHandler extends BaseRetrofitServiceClass<RetrofitLeaguesServiceHandler> implements LeaguesServiceI {

    public LeaguesServiceHandler(RetrofitLeaguesServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getLeaguesBySummoners(final List<String> summoners, final boolean onlyEntry, ServiceResponseListener<Map<String, List<League>>> listener) {

        BaseServiceAsyncTask<Map<String, List<League>>> task = new BaseServiceAsyncTask<Map<String, List<League>>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    LeagueDAO dao = new LeagueDAO();

                    Map<String, List<League>> cache = new HashMap<>();

                    List<League> leagues;

                    for (String summonerId : summoners) {

                        leagues = dao.findBySummonerOrTeamIdAndOnlyEntry(summonerId, onlyEntry);
                        if (!leagues.isEmpty() && !dao.hasExpired(leagues)) {
                            cache.put(summonerId, leagues);
                        }
                    }

                    if (cache.size() == summoners.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {


                        for (List<League> leagueList : cache.values()) {
                            dao.deleteAll(leagueList);
                        }


                        Call<Map<String, List<League>>> call = onlyEntry ? mHandler.getLeaguesBySummonersWithOnlyOwnEntries(APIConfigurationContext.REGION, DBHelper.storeStringArray(summoners)) : mHandler.getLeaguesBySummonersWithAllEntries(APIConfigurationContext.REGION, DBHelper.storeStringArray(summoners));
                        final Response<Map<String, List<League>>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, List<League>> entry : response.body().entrySet()) {
                                for (League league : entry.getValue()) {
                                    dao.save(league, entry.getKey(), onlyEntry);

                                }

                            }


                            return response.body();

                        } else {

                            if (response.code() == TeemoException.CODE_RATE_LIMIT_EXCEEDED) {
                                RateLimiter.getInstance().updateLimitRateExceeded(response);
                            }

                            return new TeemoException(response);
                        }

                    } else {
                        return TeemoException.RATE_LIMITED_EXCEPTION;
                    }

                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }


    @Override
    public void getLeaguesByTeams(final List<String> teams, final boolean onlyEntry, ServiceResponseListener<Map<String, List<League>>> listener) {
        BaseServiceAsyncTask<Map<String, List<League>>> task = new BaseServiceAsyncTask<Map<String, List<League>>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    LeagueDAO dao = new LeagueDAO();

                    Map<String, List<League>> cache = new HashMap<>();

                    List<League> leagues;

                    for (String teamId : teams) {

                        leagues = dao.findBySummonerOrTeamIdAndOnlyEntry(teamId, onlyEntry);
                        if (!leagues.isEmpty() && !dao.hasExpired(leagues)) {
                            cache.put(teamId, leagues);
                        }
                    }

                    if (cache.size() == teams.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {


                        for (List<League> leagueList : cache.values()) {
                            dao.deleteAll(leagueList);
                        }


                        Call<Map<String, List<League>>> call = onlyEntry ? mHandler.getActiveLeaguesByTeamsWithOnlyOwnEntries(APIConfigurationContext.REGION, DBHelper.storeStringArray(teams)) : mHandler.getLeaguesByTeamsWithAllEntries(APIConfigurationContext.REGION, DBHelper.storeStringArray(teams));
                        final Response<Map<String, List<League>>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, List<League>> entry : response.body().entrySet()) {
                                for (League league : entry.getValue()) {
                                    dao.save(league, entry.getKey(), onlyEntry);

                                }

                            }


                            return response.body();

                        } else {

                            if (response.code() == TeemoException.CODE_RATE_LIMIT_EXCEEDED) {
                                RateLimiter.getInstance().updateLimitRateExceeded(response);
                            }

                            return new TeemoException(response);
                        }

                    } else {
                        return TeemoException.RATE_LIMITED_EXCEPTION;
                    }

                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }


    @Override
    public void getChallengerLeagues(ServiceResponseListener<League> listener) {
        BaseServiceAsyncTask<League> task = new BaseServiceAsyncTask<League>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    if (!RateLimiter.getInstance().isLimited()) {


                        Call<League> call = mHandler.getChallengerLeagues(APIConfigurationContext.REGION);
                        final Response<League> response = call.execute();

                        if (response.isSuccessful()) {
                            return response.body();

                        } else {

                            if (response.code() == TeemoException.CODE_RATE_LIMIT_EXCEEDED) {
                                RateLimiter.getInstance().updateLimitRateExceeded(response);
                            }

                            return new TeemoException(response);
                        }

                    } else {
                        return TeemoException.RATE_LIMITED_EXCEPTION;
                    }

                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    @Override
    public void getMasterLeagues(ServiceResponseListener<League> listener) {
        BaseServiceAsyncTask<League> task = new BaseServiceAsyncTask<League>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    if (!RateLimiter.getInstance().isLimited()) {


                        Call<League> call = mHandler.getMasterLeagues(APIConfigurationContext.REGION);
                        final Response<League> response = call.execute();

                        if (response.isSuccessful()) {
                            return response.body();

                        } else {

                            if (response.code() == TeemoException.CODE_RATE_LIMIT_EXCEEDED) {
                                RateLimiter.getInstance().updateLimitRateExceeded(response);
                            }

                            return new TeemoException(response);
                        }

                    } else {
                        return TeemoException.RATE_LIMITED_EXCEPTION;
                    }

                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
