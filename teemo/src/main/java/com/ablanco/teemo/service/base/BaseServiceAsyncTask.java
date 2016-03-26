package com.ablanco.teemo.service.base;

import android.os.AsyncTask;

import com.ablanco.teemo.TeemoException;

/**
 * Created by Álvaro Blanco Cabrero on 21/3/16
 * Teemo
 */
public class BaseServiceAsyncTask<T> extends AsyncTask<Void, Void, Object> {

    private final ServiceResponseListener<T> listener;

    public BaseServiceAsyncTask(ServiceResponseListener<T> listener) {
        this.listener = listener;
    }

    @Override
    protected Object doInBackground(Void... params) {
        return null;
    }

    @Override
    protected void onPostExecute(Object param) {

        if (listener != null) {
            if (param != null && param instanceof TeemoException) {
                listener.onError((TeemoException) param);
            } else {
                listener.onResponse((T) param);
            }
        }

    }
}
