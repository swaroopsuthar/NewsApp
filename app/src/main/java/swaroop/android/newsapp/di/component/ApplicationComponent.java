package swaroop.android.newsapp.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import swaroop.android.newsapp.di.qualifiers.ApplicationContext;
import swaroop.android.newsapp.di.module.ApplicationModule;
import swaroop.android.newsapp.di.scope.ApplicationScope;

@ApplicationScope
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    @ApplicationContext
    Context getContext();

    Application getApplication();

}
