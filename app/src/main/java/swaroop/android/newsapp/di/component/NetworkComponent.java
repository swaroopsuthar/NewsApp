package swaroop.android.newsapp.di.component;

import com.squareup.picasso.Picasso;

import dagger.Component;
import swaroop.android.newsapp.di.module.PicassoModule;
import swaroop.android.newsapp.di.module.RetrofitModule;
import swaroop.android.newsapp.di.scope.ApplicationScope;
import swaroop.android.newsapp.network.APIInterface;

@ApplicationScope
@Component(modules = {RetrofitModule.class, PicassoModule.class})
public interface NetworkComponent {

    Picasso getPicasso();

    APIInterface getApiInterface();
}
