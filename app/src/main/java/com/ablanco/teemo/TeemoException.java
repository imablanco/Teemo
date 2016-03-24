package com.ablanco.teemo;

import java.io.IOException;

import retrofit2.Response;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class TeemoException extends Exception{

    public static final int CODE_BAD_REQUEST = 400;
    public static final int CODE_UNAUTHORIZED = 401;
    public static final int CODE_NOT_FOUND = 404;
    public static final int CODE_UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int CODE_RATE_LIMIT_EXCEEDED = 429;
    public static final int CODE_INTERNAL_SERVER_ERROR = 500;
    public static final int CODE_SERVICE_UNAVAILABLE = 503;
    public static final int CODE_UNKNOWN_ERROR = 1;
    public static final int CODE_IO_EXCEPTION = 2;

    public static final String MESSAGE_BAD_REQUEST = "Bad Request";
    public static final String MESSAGE_UNAUTHORIZED = "Unauthorized";
    public static final String MESSAGE_NOT_FOUND = "Not found";
    public static final String MESSAGE_UNSUPPORTED_MEDIA_TYPE = "Unsupported media type";
    public static final String MESSAGE_RATE_LIMIT_EXCEEDED = "Rate limit exceeded";
    public static final String MESSAGE_INTERNAL_SERVER_ERROR = "Internal server error";
    public static final String MESSAGE_SERVICE_UNAVAILABLE = "Service unavailable";
    public static final String MESSAGE_UNKNOWN_ERROR= "Unknown Error";
    public static final String MESSAGE_IO_EXCEPTION= "IO Exception";

    @SuppressWarnings("ThrowableInstanceNeverThrown")
    public static TeemoException RATE_LIMITED_EXCEPTION = new TeemoException(CODE_RATE_LIMIT_EXCEEDED);

    private int mCode;
    private String mMessage;

    public TeemoException(int code) {
        this.mCode = code;
        this.mMessage = getMessageForErrorCode(mCode);
    }


    public TeemoException(Response response) {
        this.mCode = response.code();
        this.mMessage = getMessageForErrorCode(mCode);
    }

    public TeemoException(Throwable t){
        super(t);
        if(t instanceof IOException){
            this.mCode = CODE_IO_EXCEPTION;
            this.mMessage = MESSAGE_IO_EXCEPTION;
        }else {
            this.mCode = CODE_UNKNOWN_ERROR;
            this.mMessage = MESSAGE_UNKNOWN_ERROR;
        }
    }

    public int getCode() {
        return mCode;
    }

    @Override
    public String getMessage() {
        return mMessage;
    }

    private String getMessageForErrorCode(int code){
        switch (code){
            case CODE_BAD_REQUEST:
                return MESSAGE_BAD_REQUEST;
            case CODE_UNAUTHORIZED:
                return MESSAGE_UNAUTHORIZED;
            case CODE_NOT_FOUND:
                return MESSAGE_NOT_FOUND;
            case CODE_UNSUPPORTED_MEDIA_TYPE:
                return MESSAGE_UNSUPPORTED_MEDIA_TYPE;
            case CODE_RATE_LIMIT_EXCEEDED:
                return MESSAGE_RATE_LIMIT_EXCEEDED;
            case CODE_INTERNAL_SERVER_ERROR:
                return MESSAGE_INTERNAL_SERVER_ERROR;
            case CODE_SERVICE_UNAVAILABLE:
                return MESSAGE_SERVICE_UNAVAILABLE;
            default:
                return MESSAGE_UNKNOWN_ERROR;

        }
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TeemoException && ((TeemoException) o).getCode() == mCode && ((TeemoException) o).getMessage().equals(mMessage);
    }
}
