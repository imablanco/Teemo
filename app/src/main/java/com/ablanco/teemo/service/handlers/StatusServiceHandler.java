package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.status.Shard;
import com.ablanco.teemo.model.status.ShardStatus;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.StatusServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitStatusServiceHandler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 * <p/>
 * This API calls does not count on rate limit so they wont get cached
 */
public class StatusServiceHandler extends BaseRetrofitServiceClass<RetrofitStatusServiceHandler> implements StatusServiceI {


    public StatusServiceHandler(RetrofitStatusServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getShards(ServiceResponseListener<List<Shard>> listener) {
        BaseServiceAsyncTask<List<Shard>> task = new BaseServiceAsyncTask<List<Shard>>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<List<Shard>> call = mHandler.getShards();
                    final Response<List<Shard>> response = call.execute();

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

    @Override
    public void getShardStatus(final String region,ServiceResponseListener<ShardStatus> listener) {
        BaseServiceAsyncTask<ShardStatus> task = new BaseServiceAsyncTask<ShardStatus>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<ShardStatus> call = mHandler.getShardStatus(region);
                    final Response<ShardStatus> response = call.execute();

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
