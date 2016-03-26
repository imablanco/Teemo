package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.staticdata.ChampionListDto;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.StaticDataServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitStaticDataServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class StaticDataServiceHandler extends BaseRetrofitServiceClass<RetrofitStaticDataServiceHandler> implements StaticDataServiceI {

    public StaticDataServiceHandler(RetrofitStaticDataServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getChampions(final String locale, final String version, final Boolean dataById, final String champData, ServiceResponseListener<ChampionListDto> listener) {

        BaseServiceAsyncTask<ChampionListDto> task = new BaseServiceAsyncTask<ChampionListDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<ChampionListDto> call = mHandler.getChampions(APIConfigurationContext.REGION,locale, version, dataById, champData);
                    final Response<ChampionListDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
