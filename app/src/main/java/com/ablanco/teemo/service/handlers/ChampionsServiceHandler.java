package com.ablanco.teemo.service.handlers;

import android.content.Context;
import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.persistence.champions.ChampionListDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.ChampionsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitChampionsServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ChampionsServiceHandler extends BaseRetrofitServiceClass<RetrofitChampionsServiceHandler> implements ChampionsServiceI {


    public ChampionsServiceHandler(Context context, RetrofitChampionsServiceHandler handler) {
        super(context, handler);
    }

    @Override
    public void getChampions(final ServiceResponseListener<ChampionList> listener) {

        BaseServiceAsyncTask<ChampionList> task = new BaseServiceAsyncTask<ChampionList>(listener){
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    ChampionListDAO dao = new ChampionListDAO();

                    ChampionList cache = dao.findLast();

                    if(cache != null && !dao.hasExpired(cache)){
                        return cache;
                    }else if(!RateLimiter.getInstance().isLimited()){


                        if(cache != null){
                            dao.deleteAll(dao.findAll());
                        }

                        Call<ChampionList> call = mHandler.getChampions(APIConfigurationContext.REGION());
                        final Response<ChampionList> response = call.execute();

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
