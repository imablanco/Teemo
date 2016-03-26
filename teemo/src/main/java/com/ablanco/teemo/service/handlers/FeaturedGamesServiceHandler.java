package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.featuredgames.FeaturedGames;
import com.ablanco.teemo.persistence.featuredgames.FeaturedGamesDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.FeaturedGamesServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitFeaturedGamesServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class FeaturedGamesServiceHandler extends BaseRetrofitServiceClass<RetrofitFeaturedGamesServiceHandler> implements FeaturedGamesServiceI {

    public FeaturedGamesServiceHandler(RetrofitFeaturedGamesServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getFeaturedGames(ServiceResponseListener<FeaturedGames> listener) {
        BaseServiceAsyncTask<FeaturedGames> task = new BaseServiceAsyncTask<FeaturedGames>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    FeaturedGamesDAO dao = new FeaturedGamesDAO();

                    FeaturedGames cache = dao.findFirst();

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<FeaturedGames> call = mHandler.getFeaturedGames();
                        final Response<FeaturedGames> response = call.execute();

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
