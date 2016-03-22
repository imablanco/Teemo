package com.ablanco.teemo;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class APIConfigurationContext {

    public static String BASE_URL = "https://{0}.api.pvp.net";
    public static String API_KEY;
    public static String REGION;
    public static String PLATFORM;

    public static void setRegion(String region){
        REGION = region;
        PLATFORM = region.concat("1");
        BASE_URL = BASE_URL.replace("{0}", REGION);
    }
}
