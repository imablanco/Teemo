package com.ablanco.teemo.utils;

/**
 * Created by Álvaro Blanco Cabrero on 27/3/16
 * TonsOfDamage
 */
public class ImageUris {

    private final static String REPLACEMENT_0 = "{0}";
    private final static String REPLACEMENT_1 = "{1}";
    private final static String REPLACEMENT_VERSION = "{2}";

    public final static String PROFILE_ICON_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/profileicon/{0}.png";
    public final static String CHAMPION_SPLASH_ART_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/{0}_{1}.jpg";
    public final static String CHAMPION_LOADING_ART_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/{0}_{1}.jpg";
    public final static String CHAMPION_SQUARE_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/champion/{0}";
    public final static String PASSIVE_ABILITY_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/passive/{0}";
    public final static String CHAMPION_ABILITY_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/spell/{0}";
    public final static String SUMMONER_SPELL_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/spell/{0}";
    public final static String ITEM_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/item/{0}.png";
    public final static String MASTERY_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/mastery/{0}";
    public final static String RUNE_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/rune/{0}";
    public final static String SPRITE_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/sprite/{0}";
    public final static String MAP_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/map/map{0}.png";
    public final static String SCORE_BOARD_BASE_URL = "http://ddragon.leagueoflegends.com/cdn/{2}/img/ui/{0}";

    public final static String SCORE_BOARD_CHAMPION_URL = SCORE_BOARD_BASE_URL.replace("{0}", "champion.png");
    public final static String SCORE_BOARD_GOLD_URL     = SCORE_BOARD_BASE_URL.replace("{0}", "gold.png");
    public final static String SCORE_BOARD_ITEM_URLS    = SCORE_BOARD_BASE_URL.replace("{0}", "items.png");
    public final static String SCORE_BOARD_MINION_URL   = SCORE_BOARD_BASE_URL.replace("{0}", "minion.png");
    public final static String SCORE_BOARD_SCORE_URL    = SCORE_BOARD_BASE_URL.replace("{0}", "score.png");
    public final static String SCORE_BOARD_SPELLS_URL   = SCORE_BOARD_BASE_URL.replace("{0}", "spells.png");

    public static String getProfileIcon(String version, String id){
        return PROFILE_ICON_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getChampionSplashArt(String name, int skinNumber){
        return CHAMPION_SPLASH_ART_BASE_URL.replace(REPLACEMENT_0,name).replace(REPLACEMENT_1, String.valueOf(skinNumber));
    }

    public static String getChampionLoadingArt(String name, int skinNumber){
        return CHAMPION_LOADING_ART_BASE_URL.replace(REPLACEMENT_0,name).replace(REPLACEMENT_1, String.valueOf(skinNumber));
    }

    public static String getChampionSquareIcon(String version, String name){
        return CHAMPION_SQUARE_BASE_URL.replace(REPLACEMENT_0, name).replace(REPLACEMENT_VERSION, version);
    }

    public static String getPassiveAbilityIcon(String version, String id){
        return PASSIVE_ABILITY_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getChampionAbilityIcon(String version, String id){
        return CHAMPION_ABILITY_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getSummonerSpellIcon(String version, String id){
        return SUMMONER_SPELL_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getItemIcon(String version, String id){
        return ITEM_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getMasteryIcon(String version, String id){
        return MASTERY_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getRuneIcon(String version, String id){
        return RUNE_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getSpriteImage(String version, String id){
        return SPRITE_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }

    public static String getMapImage(String version, String id){
        return MAP_BASE_URL.replace(REPLACEMENT_0,id).replace(REPLACEMENT_VERSION, version);
    }



}
