package com.ablanco.teemo;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class APIConfigurationContext {

    public final static String STATUS_BASE_URL = "http://status.leagueoflegends.com/";
    public final static String BASE_URL_PLACEHOLDER = "https://{0}.api.pvp.net/";
    public final static String STATIC_BASE_URL = "https://global.api.pvp.net/";
    public static String BASE_URL = "";
    public static String API_KEY;
    public static String REGION;

    public static void setRegion(String region){
        if(region != null){
            REGION = region;
            BASE_URL = BASE_URL_PLACEHOLDER.replace("{0}", REGION);
        }

    }
}
