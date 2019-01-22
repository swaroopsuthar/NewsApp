package swaroop.android.newsapp.di.component;

import dagger.Component;
import swaroop.android.newsapp.MainActivity;
import swaroop.android.newsapp.di.module.ActivityModule;

@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
