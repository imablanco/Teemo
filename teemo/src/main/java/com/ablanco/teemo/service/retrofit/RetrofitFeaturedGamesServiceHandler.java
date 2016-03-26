package com.ablanco.teemo.service.retrofit;

import com.ablanco.teemo.model.featuredgames.FeaturedGames;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public interface RetrofitFeaturedGamesServiceHandler {

    @GET("/observer-mode/rest/featured")
    Call<FeaturedGames> getFeaturedGames();
}
