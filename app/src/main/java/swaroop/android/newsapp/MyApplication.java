package swaroop.android.newsapp;

import android.app.Application;
import android.content.Context;

import com.squareup.picasso.Picasso;

import swaroop.android.newsapp.di.component.ApplicationComponent;
import swaroop.android.newsapp.di.component.DaggerApplicationComponent;
import swaroop.android.newsapp.di.component.DaggerNetworkComponent;
import swaroop.android.newsapp.di.component.NetworkComponent;
import swaroop.android.newsapp.di.module.ApplicationModule;
import swaroop.android.newsapp.network.APIInterface;

public class MyApplication extends Application {

    protected NetworkComponent networkComponent;

    private APIInterface apiInterface;
    private Picasso picasso;

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        apiInterface = networkComponent.getApiInterface();
        picasso = networkComponent.getPicasso();
    }


    public NetworkComponent component() {
        return networkComponent;
    }

    public APIInterface getApiInterface() {
        return apiInterface;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
