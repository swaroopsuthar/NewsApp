package swaroop.android.newsapp.di.component.activity;

import dagger.Component;
import swaroop.android.newsapp.di.component.NetworkComponent;
import swaroop.android.newsapp.di.module.activity.NewsActivityModule;
import swaroop.android.newsapp.di.scope.activity.NewsActivityScope;
import swaroop.android.newsapp.ui.NewsActivity;

@NewsActivityScope
@Component(modules = NewsActivityModule.class, dependencies = NetworkComponent.class)
public interface NewsActivityComponent {
    void injectNewsActivity(NewsActivity newsActivity);
}
