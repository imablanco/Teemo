package com.ablanco.teemo.service.handlers;

import android.content.Context;
import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.currentgames.CurrentGameInfo;
import com.ablanco.teemo.persistence.currentgames.CurrentGameInfoDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.CurrentGameInfoServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitCurrentGameInfoServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 22/3/16
 * Teemo
 */
public class CurrentGameInfoServiceHandler extends BaseRetrofitServiceClass<RetrofitCurrentGameInfoServiceHandler> implements CurrentGameInfoServiceI {


    public CurrentGameInfoServiceHandler(Context context, RetrofitCurrentGameInfoServiceHandler handler) {
        super(context, handler);
    }

    @Override
    public void getCurrentGameInfoByPlatform(final String platformId, final long summonerId, ServiceResponseListener<CurrentGameInfo> listener) {
        BaseServiceAsyncTask<CurrentGameInfo> task = new BaseServiceAsyncTask<CurrentGameInfo>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    CurrentGameInfoDAO dao = new CurrentGameInfoDAO();

                    CurrentGameInfo cache = dao.findFirstByPlatformAndSummonerId(platformId, summonerId);

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){

                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<CurrentGameInfo> call = mHandler.getCurrentGameInfo(platformId, summonerId);
                        final Response<CurrentGameInfo> response = call.execute();

                        if(response.isSuccessful()){

                            dao.save(response.body(), summonerId);

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
