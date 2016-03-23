package com.ablanco.teemo.service.handlers;

import android.content.Context;
import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.games.RecentGames;
import com.ablanco.teemo.persistence.games.RecentGamesDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.GamesServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitGamesServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class GamesServiceHandler extends BaseRetrofitServiceClass<RetrofitGamesServiceHandler> implements GamesServiceI {

    public GamesServiceHandler(Context context, RetrofitGamesServiceHandler handler) {
        super(context, handler);
    }

    @Override
    public void getRecentGames(final long summonerId, ServiceResponseListener<RecentGames> listener) {

        BaseServiceAsyncTask<RecentGames> task = new BaseServiceAsyncTask<RecentGames>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    RecentGamesDAO dao = new RecentGamesDAO();

                    RecentGames cache = dao.finBySummonerId(summonerId);

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<RecentGames> call = mHandler.getRecentGames(APIConfigurationContext.REGION, summonerId);
                        final Response<RecentGames> response = call.execute();

                        if(response.isSuccessful()){

                            dao.save(response.body());

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
