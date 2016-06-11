package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.summoners.MasteryPages;
import com.ablanco.teemo.model.summoners.RunePages;
import com.ablanco.teemo.model.summoners.Summoner;
import com.ablanco.teemo.persistence.base.DBHelper;
import com.ablanco.teemo.persistence.summoners.MasteryPagesDAO;
import com.ablanco.teemo.persistence.summoners.RunePagesDAO;
import com.ablanco.teemo.persistence.summoners.SummonerDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.SummonerServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitSummonerServiceHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 25/3/16
 * Teemo
 */
public class SummonersServiceHandler extends BaseRetrofitServiceClass<RetrofitSummonerServiceHandler> implements SummonerServiceI {

    public SummonersServiceHandler(RetrofitSummonerServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getSummonersByIds(final List<String> summonerIds, ServiceResponseListener<Map<String, Summoner>> listener) {
        BaseServiceAsyncTask<Map<String, Summoner>> task = new BaseServiceAsyncTask<Map<String, Summoner>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    SummonerDAO dao = new SummonerDAO();

                    Map<String, Summoner> cache = new HashMap<>();

                    Summoner summoner;

                    for (String summonerId : summonerIds) {

                        summoner = dao.findById(Long.parseLong(summonerId));
                        if (!dao.hasExpired(summoner)) {
                            cache.put(summonerId, summoner);
                        }
                    }

                    if (cache.size() == summonerIds.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        if(!cache.values().isEmpty()){
                            dao.deleteAll(cache.values());
                        }


                        Call<Map<String, Summoner>> call = mHandler.getSummonersByIds(APIConfigurationContext.REGION, DBHelper.storeStringArray(summonerIds));
                        final Response<Map<String, Summoner>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, Summoner> entry : response.body().entrySet()) {
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

    @Override
    public void getSummonerById(final String summonerId, final ServiceResponseListener<Summoner> listener) {
        getSummonersByIds(Collections.singletonList(summonerId), new ServiceResponseListener<Map<String, Summoner>>() {
            @Override
            public void onResponse(Map<String, Summoner> response) {
                if(response.size() == 1 && response.values().iterator().hasNext() && response.keySet().iterator().hasNext() && response.keySet().iterator().next().equals(summonerId)){
                    listener.onResponse(response.entrySet().iterator().next().getValue());
                }else {
                    listener.onError(new TeemoException(TeemoException.CODE_NOT_FOUND));
                }
            }

            @Override
            public void onError(TeemoException e) {
                listener.onError(e);
            }
        });
    }

    @Override
    public void getSummonersByNames(final List<String> summonerNames, ServiceResponseListener<Map<String, Summoner>> listener) {
        BaseServiceAsyncTask<Map<String, Summoner>> task = new BaseServiceAsyncTask<Map<String, Summoner>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    SummonerDAO dao = new SummonerDAO();

                    Map<String, Summoner> cache = new HashMap<>();

                    Summoner summoner;

                    for (String name : summonerNames) {

                        summoner = dao.findByName(name);
                        if (!dao.hasExpired(summoner)) {
                            cache.put(name, summoner);
                        }
                    }

                    if (cache.size() == summonerNames.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        if(!cache.values().isEmpty()){
                            dao.deleteAll(cache.values());
                        }


                        Call<Map<String, Summoner>> call = mHandler.getSummonersByNames(APIConfigurationContext.REGION, DBHelper.storeStringArray(summonerNames));
                        final Response<Map<String, Summoner>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, Summoner> entry : response.body().entrySet()) {
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

    @Override
    public void getSummonerByName(final String summonerName, final ServiceResponseListener<Summoner> listener) {
        getSummonersByNames(Collections.singletonList(summonerName), new ServiceResponseListener<Map<String, Summoner>>() {
            @Override
            public void onResponse(Map<String, Summoner> response) {
                if (response.size() == 1 && response.values().iterator().hasNext() && response.keySet().iterator().hasNext() && response.keySet().iterator().next().replaceAll("\\s+","").equalsIgnoreCase(summonerName.replaceAll("\\s+",""))) {
                    listener.onResponse(response.entrySet().iterator().next().getValue());
                } else {
                    listener.onError(new TeemoException(TeemoException.CODE_NOT_FOUND));
                }
            }

            @Override
            public void onError(TeemoException e) {
                listener.onError(e);
            }
        });
    }

    @Override
    public void getSummonersNamesByIds(final List<String> summonerIds, ServiceResponseListener<Map<String, String>> listener) {
        BaseServiceAsyncTask<Map<String, String>> task = new BaseServiceAsyncTask<Map<String, String>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    SummonerDAO dao = new SummonerDAO();

                    //here we will only get valid cache is previously data was saved by calling previous Summoner methods
                    Map<String, String> cache = new HashMap<>();

                    Summoner summoner;

                    for (String summonerId : summonerIds) {

                        summoner = dao.findById(Long.parseLong(summonerId));
                        if (!dao.hasExpired(summoner)) {
                            cache.put(summonerId, summoner.getName());
                        }
                    }

                    if (cache.size() == summonerIds.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        Call<Map<String, String>> call = mHandler.getSummonersNamesByIds(APIConfigurationContext.REGION, DBHelper.storeStringArray(summonerIds));
                        final Response<Map<String, String>> response = call.execute();

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
    public void getSummonerNameById(final String summonerId, final ServiceResponseListener<String> listener) {
        getSummonersNamesByIds(Collections.singletonList(summonerId), new ServiceResponseListener<Map<String, String>>() {
            @Override
            public void onResponse(Map<String, String> response) {
                if (response.size() == 1 && response.values().iterator().hasNext() && response.keySet().iterator().hasNext() && response.keySet().iterator().next().equals(summonerId)) {
                    listener.onResponse(response.entrySet().iterator().next().getValue());
                } else {
                    listener.onError(new TeemoException(TeemoException.CODE_NOT_FOUND));
                }
            }

            @Override
            public void onError(TeemoException e) {
                listener.onError(e);
            }
        });
    }

    @Override
    public void getSummonerMasteryPages(final String summonerId, final ServiceResponseListener<MasteryPages> listener) {
        getSummonersMasteryPages(Collections.singletonList(summonerId), new ServiceResponseListener<Map<String, MasteryPages>>() {
            @Override
            public void onResponse(Map<String, MasteryPages> response) {
                if (response.size() == 1 && response.values().iterator().hasNext() && response.keySet().iterator().hasNext() && response.keySet().iterator().next().equals(summonerId)) {
                    listener.onResponse(response.entrySet().iterator().next().getValue());
                } else {
                    listener.onError(new TeemoException(TeemoException.CODE_NOT_FOUND));
                }
            }

            @Override
            public void onError(TeemoException e) {
                listener.onError(e);
            }
        });
    }

    @Override
    public void getSummonerRunePages(final String summonerId, final ServiceResponseListener<RunePages> listener) {
        getSummonersRunePages(Collections.singletonList(summonerId), new ServiceResponseListener<Map<String, RunePages>>() {
            @Override
            public void onResponse(Map<String, RunePages> response) {
                if (response.size() == 1 && response.values().iterator().hasNext() && response.keySet().iterator().hasNext() && response.keySet().iterator().next().equals(summonerId)) {
                    listener.onResponse(response.entrySet().iterator().next().getValue());
                } else {
                    listener.onError(new TeemoException(TeemoException.CODE_NOT_FOUND));
                }
            }

            @Override
            public void onError(TeemoException e) {
                listener.onError(e);
            }
        });
    }

    @Override
    public List<Summoner> findSummonersBySuggestion(String nameSuggestion) {
        return new SummonerDAO().findBySuggestion(nameSuggestion);
    }

    @Override
    public void getSummonersMasteryPages(final List<String> summonerIds, ServiceResponseListener<Map<String, MasteryPages>> listener) {
        BaseServiceAsyncTask<Map<String, MasteryPages>> task = new BaseServiceAsyncTask<Map<String, MasteryPages>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    MasteryPagesDAO dao = new MasteryPagesDAO();

                    Map<String, MasteryPages> cache = new HashMap<>();

                    MasteryPages masteryPages;

                    for (String id : summonerIds) {

                        masteryPages = dao.finBySummonerId(Long.parseLong(id));
                        if (!dao.hasExpired(masteryPages)) {
                            cache.put(id, masteryPages);
                        }
                    }

                    if (cache.size() == summonerIds.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        if(!cache.values().isEmpty()){
                            dao.deleteAll(cache.values());
                        }


                        Call<Map<String, MasteryPages>> call = mHandler.getSummonerMasteryPages(APIConfigurationContext.REGION, DBHelper.storeStringArray(summonerIds));
                        final Response<Map<String, MasteryPages>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, MasteryPages> entry : response.body().entrySet()) {
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

    @Override
    public void getSummonersRunePages(final List<String> summonerIds, ServiceResponseListener<Map<String, RunePages>> listener) {
        BaseServiceAsyncTask<Map<String, RunePages>> task = new BaseServiceAsyncTask<Map<String, RunePages>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    RunePagesDAO dao = new RunePagesDAO();

                    Map<String, RunePages> cache = new HashMap<>();

                    RunePages runePages;

                    for (String id : summonerIds) {

                        runePages = dao.finBySummonerId(Long.parseLong(id));
                        if (!dao.hasExpired(runePages)) {
                            cache.put(id, runePages);
                        }
                    }

                    if (cache.size() == summonerIds.size()) {
                        return cache;
                    } else if (!RateLimiter.getInstance().isLimited()) {

                        if(!cache.values().isEmpty()){
                            dao.deleteAll(cache.values());
                        }


                        Call<Map<String, RunePages>> call = mHandler.getSummonerRunePages(APIConfigurationContext.REGION, DBHelper.storeStringArray(summonerIds));
                        final Response<Map<String, RunePages>> response = call.execute();

                        if (response.isSuccessful()) {

                            for (Map.Entry<String, RunePages> entry : response.body().entrySet()) {
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
