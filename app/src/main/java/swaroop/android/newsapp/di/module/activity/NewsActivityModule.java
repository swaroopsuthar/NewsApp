package swaroop.android.newsapp.di.module.activity;

import dagger.Module;
import dagger.Provides;
import swaroop.android.newsapp.di.scope.activity.NewsActivityScope;
import swaroop.android.newsapp.ui.NewsActivity;

@Module
public class NewsActivityModule {

    private final NewsActivity newsActivity;

    public NewsActivityModule(NewsActivity newsActivity) {
        this.newsActivity = newsActivity;
    }

    @Provides
    @NewsActivityScope
    public NewsActivity newsActivity() {
        return  newsActivity;
    }
}
