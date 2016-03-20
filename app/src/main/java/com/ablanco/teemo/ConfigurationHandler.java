package com.ablanco.teemo;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ConfigurationHandler {

    private static final String BASE_URL = "https://{0}.api.pvp.net";
    private String mBaseUrl;
    private String mApiKey;
    private String mRegion;

    public String geRegion() {
        return mRegion == null ? "" : mRegion;
    }

    public void setRegion(String region) {
        this.mRegion = region;
        this.mBaseUrl = BASE_URL.replace("{0}", mRegion != null ? mRegion : "");
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        this.mApiKey = apiKey;
    }
}
