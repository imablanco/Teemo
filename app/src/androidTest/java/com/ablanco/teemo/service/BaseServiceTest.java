package com.ablanco.teemo.service;

import android.test.AndroidTestCase;

import com.ablanco.teemo.Teemo;
import com.ablanco.teemo.TestConstants;
import com.ablanco.teemo.statics.Regions;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class BaseServiceTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        Teemo.setArmedAndReady(getContext(), TestConstants.DEV_API_KEY, Regions.REGION_EUW);
    }
}
