package swaroop.android.newsapp.di.module.activity;

import dagger.Module;
import dagger.Provides;
import swaroop.android.newsapp.di.scope.activity.GithubActivityScope;
import swaroop.android.newsapp.ui.GithubActivity;

@Module
public class GithubActivityModule {

    private final GithubActivity githubActivity;

    public GithubActivityModule(GithubActivity githubActivity) {
        this.githubActivity = githubActivity;
    }

    @Provides
    @GithubActivityScope
    public GithubActivity githubActivity() {
        return  githubActivity;
    }
}
