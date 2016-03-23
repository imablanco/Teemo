package com.ablanco.teemo.service.interfaces;

import com.ablanco.teemo.model.featuredgames.FeaturedGames;
import com.ablanco.teemo.service.base.ServiceResponseListener;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public interface FeaturedGamesServiceI {

    //Get a list of featured games
    void getFeaturedGames(ServiceResponseListener<FeaturedGames> listener);
}
