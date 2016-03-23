package com.ablanco.teemo.model;

import com.ablanco.teemo.model.games.Game;
import com.ablanco.teemo.model.games.Player;
import com.ablanco.teemo.model.games.RawStats;
import com.ablanco.teemo.model.games.RecentGames;
import com.ablanco.teemo.persistence.games.GameDAO;
import com.ablanco.teemo.persistence.games.RecentGamesDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Álvaro Blanco Cabrero on 23/3/16
 * Teemo
 */
public class GamesModelTest extends BaseModelTest{

    public void testRecentGameModel(){

        RecentGames recentGames = new RecentGames();
        recentGames.setSummonerId(1);

        List<Game> games = new ArrayList<>();
        games.add(new Game());
        games.add(new Game());

        recentGames.setGames(games);

        RecentGamesDAO recentGamesDAO = new RecentGamesDAO();

        recentGamesDAO.save(recentGames);

        assertTrue(!recentGamesDAO.findAll().isEmpty());
        assertTrue(recentGamesDAO.finBySummonerId(1).getGames().size() == 2);
        recentGamesDAO.deleteAll(recentGamesDAO.findAll());
        assertTrue(recentGamesDAO.findAll().isEmpty());
    }

    public void testGameModel(){

        RecentGames recentGames = new RecentGames();
        recentGames.setSummonerId(1);

        List<Game> games = new ArrayList<>();

        Game game = new Game();
        game.setStats(new RawStats());
        game.setGameId(1);
        List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());

        game.setFellowPlayers(players);

        games.add(game);
        recentGames.setGames(games);

        new RecentGamesDAO().save(recentGames);

        GameDAO gameDAO = new GameDAO();

        assertTrue(gameDAO.findFirst() != null);
        assertTrue(gameDAO.findFirst().getGameId() == 1);
        assertTrue(!gameDAO.findFirst().getFellowPlayers().isEmpty());
        assertTrue(gameDAO.findFirst().getFellowPlayers().size() == 2);
        assertTrue(gameDAO.findFirst().getStats() != null);

    }

}
