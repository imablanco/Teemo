package com.ablanco.teemo.constants;

import android.text.TextUtils;

/**
 * Created by Álvaro Blanco Cabrero on 26/3/16
 * Teemo
 */
public class StaticAPIQueryParams {

    /**
     * Champions API
     */
    public class Champions{
        public static final String ALL = "all";
        public static final String ALLYTIPS = "allytips";
        public static final String ALTIMAGES = "altimages";
        public static final String BLURB = "blurb";
        public static final String ENEMYTIPS = "enemytips";
        public static final String IMAGE = "image";
        public static final String INFO = "info";
        public static final String LORE = "lore";
        public static final String PARTYPE = "partype";
        public static final String PASSIVE = "passive";
        public static final String RECOMMENDED = "recommended";
        public static final String SKINS = "skins";
        public static final String SPELLS = "spells";
        public static final String STATS = "stats";
        public static final String TAGS = "tags";
    }


    /**
     * Items API
     */
    public class Items{
        public static final String all = "all";
        public static final String colloq = "colloq";
        public static final String consumeOnFull = "consumeOnFull";
        public static final String consumed = "consumed";
        public static final String depth = "depth";
        public static final String effect = "effect";
        public static final String from = "from";
        public static final String gold = "gold";
        public static final String groups = "groups";
        public static final String hideFromAll = "hideFromAll";
        public static final String image = "image";
        public static final String inStore = "inStore";
        public static final String into = "into";
        public static final String maps = "maps";
        public static final String requiredChampion = "requiredChampion";
        public static final String sanitizedDescription = "sanitizedDescription";
        public static final String specialRecipe = "specialRecipe";
        public static final String stacks = "stacks";
        public static final String stats = "stats";
        public static final String tags = "tags";
        public static final String lore = "lore";
        public static final String tree = "tree";
    }

    /**
     * Mastery API
     */
    public class Masteries{
        public static final String all = "all";
        public static final String image = "image";
        public static final String masteryTree = "masteryTree";
        public static final String prereq = "prereq";
        public static final String ranks = "ranks";
        public static final String sanitizedDescription = "sanitizedDescription";
        public static final String tree = "tree";
    }

    /**
     * Rune API
     */
    public class Runes{
        public static final String all = "all";
        public static final String basic = "basic";
        public static final String colloq = "colloq";
        public static final String consumeOnFull = "consumeOnFull";
        public static final String consumed = "consumed";
        public static final String depth = "depth";
        public static final String from = "from";
        public static final String gold = "gold";
        public static final String hideFromAll = "hideFromAll";
        public static final String image = "image";
        public static final String inStore = "inStore";
        public static final String into = "into";
        public static final String requiredChampion = "requiredChampion";
        public static final String sanitizedDescription = "sanitizedDescription";
        public static final String specialRecipe = "specialRecipe";
        public static final String stacks = "stacks";
        public static final String stats = "stats";
        public static final String tags = "tags";
    }

    /**
     * SummonerSpells API
     */
    public class SummonerSpells{
        public static final String all = "all";
        public static final String cooldown = "cooldown";
        public static final String cooldownBurn = "cooldownBurn";
        public static final String cost = "cost";
        public static final String costBurn = "costBurn";
        public static final String costType = "costType";
        public static final String effect = "effect";
        public static final String effectBurn = "effectBurn";
        public static final String hideFromAll = "hideFromAll";
        public static final String image = "image";
        public static final String key = "key";
        public static final String leveltip = "leveltip";
        public static final String maxrank = "maxrank";
        public static final String range = "range";
        public static final String rangeBurn = "rangeBurn";
        public static final String resource = "resource";
        public static final String sanitizedDescription = "sanitizedDescription";
        public static final String sanitizedTooltip = "sanitizedTooltip";
        public static final String tooltip = "tooltip";
        public static final String vars = "vars";
    }


    public static class StaticQueryParamsBuilder{

        private StringBuilder mStringBuilder;

        public StaticQueryParamsBuilder(){
            this.mStringBuilder = new StringBuilder();
        }

        public StaticQueryParamsBuilder include(String param){
            if(!TextUtils.isEmpty(this.mStringBuilder)){
                mStringBuilder.append(",");
            }

            mStringBuilder.append(param);

            return this;
        }

        public String build(){
            return mStringBuilder.toString();
        }
    }
}
