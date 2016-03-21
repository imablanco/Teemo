package com.ablanco.teemo;

import java.util.Date;

import retrofit2.Response;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class RateLimiter {

    private final static String RETRY_AFTER = "Retry-After";
    private final static String RATE_LIMIT_TYPE = "X-Rate-Limit-Type";
    private final static String RATE_LIMIT_TYPE_USER = "user";
    private final static String RATE_LIMIT_TYPE_SERVICE = "service";

    private static RateLimiter mInstance;

    private boolean mIsLimited = false;

    private Date availableAt;

    public static RateLimiter getInstance() {
        if (mInstance == null) {
            mInstance = new RateLimiter();
        }

        return mInstance;
    }

    private RateLimiter() {
    }

    public void updateLimitRateExceeded(Response response) {
        if (!response.isSuccessful() && response.code() == TeemoException.CODE_RATE_LIMIT_EXCEEDED && response.headers() != null) {

            mIsLimited = true;

            String type = response.headers().get(RATE_LIMIT_TYPE);
            String retryAfter = response.headers().get(RETRY_AFTER);

            // TODO: 20/03/2016 dont use type at this moment

            int retryAfterInMillis = (retryAfter != null ? Integer.parseInt(retryAfter) : 1) * 1000;

            //set a future date to allow Client to make more API calls
            availableAt = new Date(System.currentTimeMillis() + retryAfterInMillis);

        }
    }

    public boolean isLimited() {
        if (mIsLimited && availableAt != null) {
            if(System.currentTimeMillis() > availableAt.getTime()) {
                mIsLimited = false;
            }else {
                mIsLimited = true;
            }
        }
        return mIsLimited;
    }


}
