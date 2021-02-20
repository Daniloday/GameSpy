package com.missclick.gamespy2;

import android.app.Application;

import com.missclick.gamespy2.id.dager.AppComponent;
import com.missclick.gamespy2.id.dager.AppModule;
import com.missclick.gamespy2.id.dager.DaggerAppComponent;

public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initializeDagger();
    }

    private AppComponent initializeDagger(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}