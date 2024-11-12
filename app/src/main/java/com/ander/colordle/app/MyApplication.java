package com.ander.colordle.app;

import android.app.Application;

import com.ander.colordle.models.Puntuacion;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class MyApplication extends Application {

    public static AtomicInteger cardID = new AtomicInteger();

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        if (results.size()>0){
            return new AtomicInteger(results.max("id").intValue());
        }else{
            return  new AtomicInteger(0);
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();
        setUpRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        cardID = getIdByTable(realm, Puntuacion.class);
        realm.close();
    }

    private void setUpRealmConfig() {
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

}
