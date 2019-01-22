package swaroop.android.newsapp;

import android.app.Application;
import android.content.Context;

import swaroop.android.newsapp.di.component.ApplicationComponent;
import swaroop.android.newsapp.di.component.DaggerApplicationComponent;
import swaroop.android.newsapp.di.module.ApplicationModule;

public class MyApplication extends Application {

    protected ApplicationComponent applicationComponent;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        //applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
