package com.ablanco.teemo.service.interfaces;

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
import com.ablanco.teemo.service.base.ServiceResponseListener;

import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public interface StaticDataServiceI {

    /**
     * Retrieves champion list
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param dataById If specified as true, the returned data map will use the champions' IDs as the keys. If not specified or specified as false, the returned data map will use the champions' keys instead.
     * @param champData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Champions} Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @return
     */
    void getChampions(String locale,String version,Boolean dataById,String champData, ServiceResponseListener<ChampionListDto> listener);


    /**
     * Retrieves a champion by its id
     * @param id Champion ID
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param champData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Champions} Tags to return additional data. Only id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @param listener
     */
    void getChampionById(Integer id, String locale, String version, String champData, ServiceResponseListener<ChampionDto> listener);

    /**
     * Retrieves item list
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param itemListData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Items} Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @param listener
     */
    void getItems(String locale, String version, String itemListData, ServiceResponseListener<ItemListDto> listener);

    /**
     * Retrieves item list
     * @param id Id of the item
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param itemData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Items} Tags to return additional data. Only type, version, basic, data, id, name, plaintext, group, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @param listener
     */
    void getItemById(Integer id, String locale, String version, String itemData, ServiceResponseListener<ItemDto> listener);

    /**
     * Retrieves languages list
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     */
    void getLanguages(String locale, String version, ServiceResponseListener<LanguageStringsDto> listener);

    /**
     * Retrieve map data
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param listener
     */
    void getMapData(String locale, String version , ServiceResponseListener<MapDataDto> listener);

    /**
     * Retrieves mastery list
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param masteryListData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Masteries} Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @param listener
     */
    void getMasteries(String locale, String version, String masteryListData, ServiceResponseListener<MasteryListDto> listener);

    /**
     * Retrieves mastery list
     * @param id Mastery ID
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param masteryData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Masteries} Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @param listener
     */
    void getMasteryById(Integer id, String locale, String version, String masteryData, ServiceResponseListener<MasteryDto> listener);

    /**
     * Retrieves realm data
     */
    void getRealms(ServiceResponseListener<RealmDto> listener);

    /**
     * Retrieves runes list
     * @param locale Locale code for returned data (e.g., en_US, es_ES). If not specified, the default locale for the region is used.
     * @param version Data dragon version for returned data. If not specified, the latest version for the region is used. List of valid versions can be obtained from the /versions endpoint.
     * @param runeListData Use {@link com.ablanco.teemo.constants.StaticAPIQueryParams.StaticQueryParamsBuilder} with {@link com.ablanco.teemo.constants.StaticAPIQueryParams.Runes} Tags to return additional data. Only type, version, data, id, name, and description are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @param listener
     */
    void getRunes(String locale, String version, String runeListData, ServiceResponseListener<RuneListDto> listener);

    void getRuneById(Integer id, String locale, String version, String runeData, ServiceResponseListener<RuneDto> listener);

    void getSummonerSpells(String locale,String version,Boolean dataById,String spellData, ServiceResponseListener<SummonerSpellListDto> listener);

    void getSummonerSpell(Integer id, String locale, String version, String spellData, ServiceResponseListener<SummonerSpellDto> listener);

    void getVersions(ServiceResponseListener<List<String>> listServiceResponseListener);

}
