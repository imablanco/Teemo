package com.ablanco.teemo.service.handlers;

import android.content.Context;
import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.matches.MatchDetail;
import com.ablanco.teemo.persistence.matches.MatchDetailDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.MatchesServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitMatchesServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class MatchesServiceHandler extends BaseRetrofitServiceClass<RetrofitMatchesServiceHandler> implements MatchesServiceI {

    public MatchesServiceHandler(Context context, RetrofitMatchesServiceHandler handler) {
        super(context, handler);
    }


    @Override
    public void getMatch(final long matchId, final boolean includeTimeline, ServiceResponseListener<MatchDetail> listener) {
        BaseServiceAsyncTask<MatchDetail> task = new BaseServiceAsyncTask<MatchDetail>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    MatchDetailDAO dao = new MatchDetailDAO();

                    MatchDetail cache = dao.findByMatchIdAndIncludeTimeLine(matchId, includeTimeline);

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.delete(cache);
                        }

                        Call<MatchDetail> call = mHandler.getMatch(APIConfigurationContext.REGION, matchId, includeTimeline);
                        final Response<MatchDetail> response = call.execute();

                        if(response.isSuccessful()){

                            dao.save(response.body(), includeTimeline);

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
