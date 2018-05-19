package com.androidtutz.anushka.findtheday.app;

import android.app.Application;

import com.androidtutz.anushka.findtheday.components.ApplicationComponent;
import com.androidtutz.anushka.findtheday.components.DaggerApplicationComponent;
import com.androidtutz.anushka.findtheday.modules.ChooserModule;

public class MyApp extends Application {

    private static MyApp myApp;
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        applicationComponent= DaggerApplicationComponent.builder()
                            .chooserModule(new ChooserModule())
                            .build();
    }

    public static MyApp getMyApp() {
        return myApp;
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
