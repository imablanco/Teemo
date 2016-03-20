package com.ablanco.teemo.persistence;

import android.content.Context;

import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmQuery;

/**
 * Created by Álvaro Blanco on 20/03/2016.
 * Teemo
 */
public class RealmContext{

    private static final String REALM_DB_NAME = "teemo.db";
    private Realm mRealm;
    private static RealmContext mInstance;

    public static RealmContext getInstance(Context context){
        if(mInstance == null){
            mInstance = new RealmContext(context);
        }

        return mInstance;
    }

    private RealmContext(Context context) {
        mRealm = Realm.getInstance(
                new RealmConfiguration.Builder(context)
                        .name(REALM_DB_NAME)
                        .build());
    }

    public void deleteAll(final Class<? extends RealmObject> clazz){
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.clear(clazz);
            }
        });
    }

    public void save(RealmObject data) {
        save(data, null);
    }

    public void save(final RealmObject data, final Realm.Transaction.Callback callback) {


        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(data);

            }
        }, callback);
    }

    public <T extends RealmObject> List<T> findAll(Class<T> realmObjectClass) {
        return mRealm.where(realmObjectClass).findAll();
    }

    public <T extends RealmObject> T findFirst(Class<T> realmObjectClass) {
        return mRealm.where(realmObjectClass).findFirst();
    }

    public <T extends RealmObject> QueryBuilder<T> getQueryBuilder(Class<T> tClass){
        return new QueryBuilder<>(tClass);
    }

    public class QueryBuilder<T extends RealmObject>{

        private RealmQuery<T> mQuery;

        public QueryBuilder(Class<T> tClass){
            this.mQuery = mRealm.where(tClass);
        }

        public QueryBuilder<T> where(String field, String value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Boolean value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Byte value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Double value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Float value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Date value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Integer value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Long value){
            mQuery.equalTo(field, value);
            return this;
        }

        public QueryBuilder<T> where(String field, Short value){
            mQuery.equalTo(field, value);
            return this;
        }

        public T find(){
            return mQuery.findFirst();
        }

        public List<T> findAll(){
            return mQuery.findAll();
        }
    }

}
