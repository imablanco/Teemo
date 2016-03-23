package com.ablanco.teemo.model;

import android.test.AndroidTestCase;

import com.ablanco.teemo.persistence.base.DBContext;

/**
 * Created by Álvaro Blanco on 22/03/2016.
 * Teemo
 */
public class BaseModelTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DBContext.initDb(getContext());
    }

    @Override
    protected void tearDown() throws Exception {
        DBContext.finishDb();
    }
}
