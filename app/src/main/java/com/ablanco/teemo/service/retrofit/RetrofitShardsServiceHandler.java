package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.status.Shard;
import com.ablanco.teemo.model.status.ShardStatus;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public interface RetrofitShardsServiceHandler {

    @GET("shards")
    Call<List<Shard>> getShards();

    @GET("shards/{region}")
    Call<ShardStatus> getShardStatus(@Path("region") String region);
}
