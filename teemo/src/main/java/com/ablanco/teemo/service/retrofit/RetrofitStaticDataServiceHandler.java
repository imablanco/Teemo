package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.staticdata.ChampionListDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public interface RetrofitStaticDataServiceHandler {


    @GET("api/lol/static-data/{region}/v1.2/champion")
    Call<ChampionListDto> getChampions(@Path("region") String region, @Query("locale") String locale,
                                       @Query("version") String version,
                                       @Query("dataById") Boolean dataById,
                                       @Query("champData") String champData);
}
