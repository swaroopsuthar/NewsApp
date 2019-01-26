package swaroop.android.newsapp.di.component.activity;

import dagger.Component;
import swaroop.android.newsapp.di.component.ApplicationComponent;
import swaroop.android.newsapp.di.component.NetworkComponent;
import swaroop.android.newsapp.di.module.activity.GithubActivityModule;
import swaroop.android.newsapp.di.scope.activity.GithubActivityScope;
import swaroop.android.newsapp.ui.GithubActivity;

@GithubActivityScope
@Component(modules = GithubActivityModule.class, dependencies = NetworkComponent.class)
public interface GithubActivityComponent {
    void injectGithubActivity(GithubActivity githubActivity);
}
