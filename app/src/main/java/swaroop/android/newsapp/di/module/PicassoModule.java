package swaroop.android.newsapp.di.module;

import android.content.Context;

import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import swaroop.android.newsapp.di.qualifiers.ApplicationContext;
import swaroop.android.newsapp.di.scope.ApplicationScope;

@Module(includes = { ApplicationModule.class, RetrofitModule.class })
public class PicassoModule {

    @Provides
    @ApplicationScope
    public Picasso getPicasso(@ApplicationContext Context context, OkHttp3Downloader okHttp3Downloade) {
        return  new Picasso.Builder(context)
                .downloader(okHttp3Downloade)
                .build();
    }

    @Provides
    @ApplicationScope
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
