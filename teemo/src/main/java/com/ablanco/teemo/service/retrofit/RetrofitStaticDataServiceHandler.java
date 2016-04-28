package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.staticdata.ChampionDto;
import com.ablanco.teemo.model.staticdata.ChampionListDto;
import com.ablanco.teemo.model.staticdata.ItemDto;
import com.ablanco.teemo.model.staticdata.ItemListDto;
import com.ablanco.teemo.model.staticdata.LanguageStringsDto;
import com.ablanco.teemo.model.staticdata.MapDataDto;
import com.ablanco.teemo.model.staticdata.MasteryDto;
import com.ablanco.teemo.model.staticdata.MasteryListDto;
import com.ablanco.teemo.model.staticdata.RealmDto;
import com.ablanco.teemo.model.staticdata.RuneDto;
import com.ablanco.teemo.model.staticdata.RuneListDto;
import com.ablanco.teemo.model.staticdata.SummonerSpellDto;
import com.ablanco.teemo.model.staticdata.SummonerSpellListDto;

import java.util.List;

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
    Call<ChampionListDto> getChampions(@Path("region") String region,
                                       @Query("locale") String locale,
                                       @Query("version") String version,
                                       @Query("dataById") Boolean dataById,
                                       @Query("champData") String champData);

    @GET("api/lol/static-data/{region}/v1.2/champion/{id}")
    Call<ChampionDto> getChampionById(@Path("region") String region,
                                      @Path("id") Integer id,
                                      @Query("locale") String locale,
                                      @Query("version") String version,
                                      @Query("champData") String champData);

    @GET("api/lol/static-data/{region}/v1.2/item")
    Call<ItemListDto> getItems(@Path("region") String region,
                               @Query("locale") String locale,
                               @Query("version") String version,
                               @Query("itemListData") String itemListData);

    @GET("api/lol/static-data/{region}/v1.2/item/{id}")
    Call<ItemDto> getItemById(@Path("region") String region,
                              @Path("id") Integer id,
                              @Query("locale") String locale,
                              @Query("version") String version,
                              @Query("itemData") String itemData);

    @GET("api/lol/static-data/{region}/v1.2/language-strings")
    Call<LanguageStringsDto> getLanguageStrings(@Path("region") String region,
                                                @Query("locale") String locale,
                                                @Query("version") String version);

    @GET("api/lol/static-data/{region}/v1.2/map")
    Call<MapDataDto> getMapData(@Path("region") String region,
                                @Query("locale") String locale,
                                @Query("version") String version);

    @GET("api/lol/static-data/{region}/v1.2/mastery")
    Call<MasteryListDto> getMasteries(@Path("region") String region,
                                      @Query("locale") String locale,
                                      @Query("version") String version,
                                      @Query("masteryListData") String masteryListData);

    @GET("api/lol/static-data/{region}/v1.2/mastery/{id}")
    Call<MasteryDto> getMasteryById(@Path("region") String region,
                                    @Path("id") Integer id,
                                    @Query("locale") String locale,
                                    @Query("version") String version,
                                    @Query("masteryData") String masteryData);

    @GET("api/lol/static-data/{region}/v1.2/realm")
    Call<RealmDto> getRealms(@Path("region") String region);

    @GET("api/lol/static-data/{region}/v1.2/rune")
    Call<RuneListDto> getRunes(@Path("region") String region,
                               @Query("locale") String locale,
                               @Query("version") String version,
                               @Query("runeListData") String runeListData);

    @GET("api/lol/static-data/{region}/v1.2/rune/{id}")
    Call<RuneDto> getRuneById(@Path("region") String region,
                              @Path("id") Integer id,
                              @Query("locale") String locale,
                              @Query("version") String version,
                              @Query("runeData") String runeData);

    @GET("api/lol/static-data/{region}/v1.2/summoner-spell")
    Call<SummonerSpellListDto> getSummonerSpells(@Path("region") String region,
                                                 @Query("locale") String locale,
                                                 @Query("version") String version,
                                                 @Query("dataById") Boolean dataById,
                                                 @Query("spellData") String spellData);

    @GET("api/lol/static-data/{region}/v1.2/summoner-spell/{id}")
    Call<SummonerSpellDto> getSummonerSpellById(@Path("region") String region,
                                                @Path("id") Integer id,
                                                @Query("locale") String locale,
                                                @Query("version") String version,
                                                @Query("spellData") String spellData);


    @GET("api/lol/static-data/{region}/v1.2/versions")
    Call<List<String>> getVersions(@Path("region") String region);
}
