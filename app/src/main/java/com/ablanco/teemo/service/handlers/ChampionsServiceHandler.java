package com.ablanco.teemo.service.handlers;

import android.content.Context;

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
    public void getChallenges(final ServiceResponseListener<ChampionList> listener) {
        Call<ChampionList> call = mHandler.getChallenges("euw"); // TODO: 20/03/2016 centralize region
        call.enqueue(new Callback<ChampionList>() {
            @Override
            public void onResponse(Call<ChampionList> call, Response<ChampionList> response) {

                // TODO: 20/03/2016 we should handle error cases
                RealmContext.getInstance(mContext).saveData(response.body());
                listener.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<ChampionList> call, Throwable t) {
                listener.onError(new Exception(t));
            }
        });
    }
}
