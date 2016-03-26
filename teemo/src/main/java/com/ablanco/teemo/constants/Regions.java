package com.ablanco.teemo.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class Regions {

    public final static String REGION_EUW = "euw";
    public final static String REGION_BR = "br";
    public final static String REGION_EUNE = "eune";
    public final static String REGION_KR = "kr";
    public final static String REGION_LAN = "lan";
    public final static String REGION_LAS = "las";
    public final static String REGION_NA = "na";
    public final static String REGION_OCE = "oce";
    public final static String REGION_RU = "ru";
    public final static String REGION_TR = "tr";

    public static List<String> getAll(){
        return Arrays.asList(REGION_EUW,REGION_BR, REGION_EUNE, REGION_KR, REGION_LAN, REGION_LAS, REGION_NA, REGION_OCE, REGION_RU, REGION_TR);
    }

}
