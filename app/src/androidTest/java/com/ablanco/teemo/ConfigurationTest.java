package com.ablanco.teemo;

import android.test.AndroidTestCase;

import com.ablanco.teemo.statics.Regions;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class ConfigurationTest extends AndroidTestCase {

    public void testNoApiKeyError(){
        try {
            Teemo.setArmedAndReady(getContext());
            assertTrue(false);
        }catch (IllegalStateException e){
            assertTrue(true);
        }
    }

    public void testNoApiKeyWithRegionError(){
        try {
            Teemo.setArmedAndReady(getContext(), Regions.REGION_EUW);
            assertTrue(false);
        }catch (IllegalStateException e){
            assertTrue(true);
        }
    }

    public void testApiKeyNoRegionError(){
        try {
            Teemo.setArmedAndReady(getContext(),TestConstants.DEV_API_KEY);
            Teemo.getInstance(getContext()).getChampionsHandler();
            assertTrue(false);
        }catch (IllegalStateException e){
            assertTrue(true);
        }
    }

    public void testLazyRegion(){
        try {
            Teemo.setArmedAndReady(getContext(),TestConstants.DEV_API_KEY, null);
            Teemo.getInstance(getContext()).setRegion(getContext(), Regions.REGION_EUW);
            Teemo.getInstance(getContext()).getChampionsHandler();
            assertTrue(true);
        }catch (IllegalStateException e){
            assertTrue(false);
        }
    }
}
