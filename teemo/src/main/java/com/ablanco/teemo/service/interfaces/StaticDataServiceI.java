package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.staticdata.ChampionListDto;
import com.ablanco.teemo.service.base.ServiceResponseListener;

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
     * @param champData Tags to return additional data. Only type, version, data, id, key, name, and title are returned by default if this parameter isn't specified. To return all additional data, use the tag 'all'.
     * @return
     */

    void getChampions(String locale,String version,Boolean dataById,String champData, ServiceResponseListener<ChampionListDto> listener);

}
