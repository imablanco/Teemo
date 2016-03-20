package com.ablanco.teemo.service.handlers;

import android.content.Context;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.RateLimiter;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.champions.ChampionList;
import com.ablanco.teemo.persistence.RealmContext;
import com.ablanco.teemo.service.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.ChampionsServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitChampionsServiceHandler;

import retrofit2.Call;
import retrofit2.Callback;
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

        ChampionList cache = RealmContext.getInstance(mContext).getQueryBuilder(ChampionList.class).find();

        if(cache != null){
            listener.onResponse(cache);
        }else if(!RateLimiter.getInstance().isLimited()){
            Call<ChampionList> call = mHandler.getChampions(APIConfigurationContext.REGION());
            call.enqueue(new Callback<ChampionList>() {
                @Override
                public void onResponse(Call<ChampionList> call, Response<ChampionList> response) {

                    if(response.isSuccessful()){

                        RealmContext.getInstance(mContext).deleteAll(ChampionList.class);
                        RealmContext.getInstance(mContext).save(response.body());
                        listener.onResponse(response.body());

                    }else {
                        listener.onError(new TeemoException(response));
                    }

                }

                @Override
                public void onFailure(Call<ChampionList> call, Throwable t) {
                    listener.onError(new TeemoException(t));
                }
            });
        }else {
            listener.onError(TeemoException.RATE_LIMITED_EXCEPTION);
        }

    }
}
