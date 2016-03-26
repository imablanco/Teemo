package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.teams.Team;
import com.ablanco.teemo.persistence.base.DBHelper;
import com.ablanco.teemo.persistence.teams.TeamDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.TeamsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitTeamsServiceHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 24/3/16
 * Teemo
 */
public class TeamsServiceHandler extends BaseRetrofitServiceClass<RetrofitTeamsServiceHandler> implements TeamsServiceI{

    public TeamsServiceHandler(RetrofitTeamsServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getTeamsBySummonersIds(final List<String> summonerIds, ServiceResponseListener<Map<String, List<Team>>> listener) {
        BaseServiceAsyncTask<Map<String, List<Team>>> task = new BaseServiceAsyncTask<Map<String, List<Team>>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    TeamDAO dao = new TeamDAO();

                    Map<String, List<Team>> cache = new HashMap<>();

                    List<Team> teams;

                    for (String summonerId : summonerIds) {

                        teams = dao.findBySummonerId(summonerId);
                        if (!teams.isEmpty() && !dao.hasExpired(teams)) {
                            cache.put(summonerId, teams);
                        }
                    }

                    if (cache.size() == summonerIds.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {


                        for (List<Team> teamList : cache.values()) {
                            dao.deleteAll(teamList);
                        }


                        Call<Map<String, List<Team>>> call = mHandler.getTeamsBySummonersIds(APIConfigurationContext.REGION, DBHelper.storeStringArray(summonerIds));
                        final Response<Map<String, List<Team>>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, List<Team>> entry : response.body().entrySet()) {
                                for (Team team : entry.getValue()) {
                                    dao.save(team, entry.getKey());

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
    public void getTeamsByTeamIds(final List<String> teamIds, ServiceResponseListener<Map<String, Team>> listener) {
        BaseServiceAsyncTask<Map<String, Team>> task = new BaseServiceAsyncTask<Map<String, Team>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    TeamDAO dao = new TeamDAO();

                    Map<String, Team> cache = new HashMap<>();

                    Team team;

                    for (String teamId : teamIds) {

                        team = dao.findByTeamId(teamId);
                        if (!dao.hasExpired(team)) {
                            cache.put(teamId, team);
                        }
                    }

                    if (cache.size() == teamIds.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        if(!cache.values().isEmpty()){
                            dao.deleteAll(cache.values());
                        }


                        Call<Map<String, Team>> call = mHandler.getTeamsByTeamIds(APIConfigurationContext.REGION, DBHelper.storeStringArray(teamIds));
                        final Response<Map<String, Team>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, Team> entry : response.body().entrySet()) {
                                dao.save(entry.getValue());
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
}
