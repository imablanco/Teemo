package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.status.Shard;
import com.ablanco.teemo.model.status.ShardStatus;
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public interface StatusServiceI {

    void getShards(ServiceResponseListener<List<Shard>> listener);
    void getShardStatus(String region, ServiceResponseListener<ShardStatus> listener);
}
