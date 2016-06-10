package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.championmastery.ChampionMasteryDto;
import com.ablanco.teemo.persistence.championmastery.ChampionMasteryDtoDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.ChampionMasteryServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitChampionMasteryServiceHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 9/6/16
 * TonsOfDamage
 */
public class ChampionMasteryServiceHandler extends BaseRetrofitServiceClass<RetrofitChampionMasteryServiceHandler> implements ChampionMasteryServiceI {

    public ChampionMasteryServiceHandler(RetrofitChampionMasteryServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getChampionMastery(final String platformId, final Long playerId, final Long championId, ServiceResponseListener<ChampionMasteryDto> listener) {
        BaseServiceAsyncTask<ChampionMasteryDto> task = new BaseServiceAsyncTask<ChampionMasteryDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    ChampionMasteryDtoDAO dao = new ChampionMasteryDtoDAO();

                    ChampionMasteryDto cache = dao.findByChampionIdAndPlayerId(championId, playerId);

                    if (cache != null && !dao.hasExpired(cache)) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        if (cache != null) {
                            dao.delete(cache);
                        }

                        Call<ChampionMasteryDto> call = mHandler.getChampionMastery(platformId, playerId, championId);
                        final Response<ChampionMasteryDto> response = call.execute();

                        if (response.isSuccessful() && response.code() != 204) {

                            dao.save(response.body());

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
    public void getChampionsMasteryByPlayer(final String platformId, final Long playerId, ServiceResponseListener<List<ChampionMasteryDto>> listener) {
        BaseServiceAsyncTask<List<ChampionMasteryDto>> task = new BaseServiceAsyncTask<List<ChampionMasteryDto>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    if (!RateLimiter.getInstance().isLimited()) {


                        Call<List<ChampionMasteryDto>> call = mHandler.getChampionsMasteryByPlayer(platformId, playerId);
                        final Response<List<ChampionMasteryDto>> response = call.execute();

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
    public void getChampionsMasteryScore(final String platformId, final Long playerId, ServiceResponseListener<Integer> listener) {
        BaseServiceAsyncTask<Integer> task = new BaseServiceAsyncTask<Integer>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    if (!RateLimiter.getInstance().isLimited()) {

                        Call<Integer> call = mHandler.getChampionsMasteryScore(platformId, playerId);
                        final Response<Integer> response = call.execute();

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
    public void getTopChampionsMastery(final String platformId, final Long playerId, final Integer count, ServiceResponseListener<List<ChampionMasteryDto>> listener) {
        BaseServiceAsyncTask<List<ChampionMasteryDto>> task = new BaseServiceAsyncTask<List<ChampionMasteryDto>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    if (!RateLimiter.getInstance().isLimited()) {


                        Call<List<ChampionMasteryDto>> call = mHandler.getTopChampionsMastery(platformId, playerId, count);
                        final Response<List<ChampionMasteryDto>> response = call.execute();

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
