package com.ablanco.teemo.persistence.games;

import com.ablanco.teemo.model.games.Game;
import com.ablanco.teemo.model.games.Player;
import com.ablanco.teemo.persistence.base.BaseReferencedDAO;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class PlayerDAO extends BaseReferencedDAO<Player, Game> {

    public PlayerDAO() {
        super(Player.class);
    }

}
