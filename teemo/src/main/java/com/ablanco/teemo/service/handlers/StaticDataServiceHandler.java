package com.ablanco.teemo.service.handlers;

import android.os.AsyncTask;

import com.ablanco.teemo.APIConfigurationContext;
import com.ablanco.teemo.TeemoException;
import com.ablanco.teemo.model.staticdata.ChampionDto;
import com.ablanco.teemo.model.staticdata.ChampionListDto;
import com.ablanco.teemo.model.staticdata.ItemDto;
import com.ablanco.teemo.model.staticdata.ItemListDto;
import com.ablanco.teemo.model.staticdata.LanguageStringsDto;
import com.ablanco.teemo.model.staticdata.MapDataDto;
import com.ablanco.teemo.model.staticdata.MasteryDto;
import com.ablanco.teemo.model.staticdata.MasteryListDto;
import com.ablanco.teemo.persistence.languages.LanguageStringDAO;
import com.ablanco.teemo.service.base.BaseRetrofitServiceClass;
import com.ablanco.teemo.service.base.BaseServiceAsyncTask;
import com.ablanco.teemo.service.base.ServiceResponseListener;
import com.ablanco.teemo.service.interfaces.StaticDataServiceI;
import com.ablanco.teemo.service.retrofit.RetrofitStaticDataServiceHandler;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class StaticDataServiceHandler extends BaseRetrofitServiceClass<RetrofitStaticDataServiceHandler> implements StaticDataServiceI {

    public StaticDataServiceHandler(RetrofitStaticDataServiceHandler handler) {
        super(handler);
    }

    @Override
    public void getChampions(final String locale, final String version, final Boolean dataById, final String champData, ServiceResponseListener<ChampionListDto> listener) {

        BaseServiceAsyncTask<ChampionListDto> task = new BaseServiceAsyncTask<ChampionListDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<ChampionListDto> call = mHandler.getChampions(APIConfigurationContext.REGION,locale, version, dataById, champData);
                    final Response<ChampionListDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void getChampionById(final Integer id, final String locale, final String version, final String champData, ServiceResponseListener<ChampionDto> listener) {
        BaseServiceAsyncTask<ChampionDto> task = new BaseServiceAsyncTask<ChampionDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<ChampionDto> call = mHandler.getChampionById(APIConfigurationContext.REGION, id,locale, version, champData);
                    final Response<ChampionDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void getItems(final String locale, final String version, final String itemListData, ServiceResponseListener<ItemListDto> listener) {
        BaseServiceAsyncTask<ItemListDto> task = new BaseServiceAsyncTask<ItemListDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<ItemListDto> call = mHandler.getItems(APIConfigurationContext.REGION, locale, version, itemListData);
                    final Response<ItemListDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void getItemById(final Integer id, final String locale, final String version, final String itemListData, ServiceResponseListener<ItemDto> listener) {
        BaseServiceAsyncTask<ItemDto> task = new BaseServiceAsyncTask<ItemDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<ItemDto> call = mHandler.getItemById(APIConfigurationContext.REGION, id, locale, version, itemListData);
                    final Response<ItemDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void getLanguages(final String locale, final String version, ServiceResponseListener<LanguageStringsDto> listener) {

        BaseServiceAsyncTask<LanguageStringsDto> task = new BaseServiceAsyncTask<LanguageStringsDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    LanguageStringDAO languageStringDAO = new LanguageStringDAO();
                    LanguageStringsDto cache = languageStringDAO.findByLocale(locale);

                    if(cache != null && languageStringDAO.hasExpired(cache)){
                        return cache;
                    }else {

                        if(cache != null){
                            languageStringDAO.delete(cache);
                        }

                        Call<LanguageStringsDto> call = mHandler.getLanguageStrings(APIConfigurationContext.REGION, locale, version);
                        final Response<LanguageStringsDto> response = call.execute();

                        if (response.isSuccessful()) {

                            languageStringDAO.save(response.body(), locale);
                            return response.body();
                        } else {
                            return new TeemoException(response);
                        }
                    }

                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);

    }

    @Override
    public void getMapData(final String locale, final String version, ServiceResponseListener<MapDataDto> listener) {
        BaseServiceAsyncTask<MapDataDto> task = new BaseServiceAsyncTask<MapDataDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<MapDataDto> call = mHandler.getMapData(APIConfigurationContext.REGION, locale, version);
                    final Response<MapDataDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void getMasteries(final String locale, final String version, final String masteryListData, ServiceResponseListener<MasteryListDto> listener) {
        BaseServiceAsyncTask<MasteryListDto> task = new BaseServiceAsyncTask<MasteryListDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<MasteryListDto> call = mHandler.getMasteries(APIConfigurationContext.REGION, locale, version, masteryListData);
                    final Response<MasteryListDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @Override
    public void getMasteryById(final Integer id, final String locale, final String version, final String masteryData, ServiceResponseListener<MasteryDto> listener) {
        BaseServiceAsyncTask<MasteryDto> task = new BaseServiceAsyncTask<MasteryDto>(listener) {
            @Override
            protected Object doInBackground(Void... params) {

                try {

                    Call<MasteryDto> call = mHandler.getMasteryById(APIConfigurationContext.REGION, id, locale, version, masteryData);
                    final Response<MasteryDto> response = call.execute();

                    if (response.isSuccessful()) {
                        return response.body();
                    } else {
                        return new TeemoException(response);
                    }


                } catch (Exception e) {
                    return new TeemoException(e);
                }
            }
        };

        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
