package swaroop.android.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import swaroop.android.newsapp.MyApplication;
import swaroop.android.newsapp.R;
import swaroop.android.newsapp.adapter.NewsAdapter;
import swaroop.android.newsapp.di.component.ActivityComponent;
import swaroop.android.newsapp.di.component.activity.DaggerNewsActivityComponent;
import swaroop.android.newsapp.di.component.activity.NewsActivityComponent;
import swaroop.android.newsapp.di.module.ActivityModule;
import swaroop.android.newsapp.di.module.activity.NewsActivityModule;
import swaroop.android.newsapp.model.GithubRepo;
import swaroop.android.newsapp.model.NewsResult;
import swaroop.android.newsapp.network.APIInterface;
import swaroop.android.newsapp.repository.NewsRepository;
import swaroop.android.newsapp.room.entity.News;
import swaroop.android.newsapp.viewmodel.NewsViewModel;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

public class NewsActivity extends AppCompatActivity {

    private NewsViewModel newsViewModel;

    Call<List<NewsResult>> newsResultCall;

    @Inject
    APIInterface newsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        RecyclerView recyclerView = findViewById(R.id.new_item_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final NewsAdapter newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);


        NewsActivityComponent newsActivityComponent = DaggerNewsActivityComponent.builder()
                .newsActivityModule(new NewsActivityModule(this))
                .networkComponent(MyApplication.get(this).component())
                .build();

        newsActivityComponent.injectNewsActivity(this);

        newsResultCall = newsService.getTopHeadlines();
        newsResultCall.enqueue(new Callback<List<NewsResult>>() {
            @Override
            public void onResponse(Call<List<NewsResult>> call, Response<List<NewsResult>> response) {
                List<NewsResult> newsResults = response.body();

               // newsAdapter.setNewsList(newsResults);
            }

            @Override
            public void onFailure(Call<List<NewsResult>> call, Throwable t) {
                Toast.makeText(NewsActivity.this, "Error getting repos " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        newsViewModel.findAll().observe(this, new Observer<List<News>>() {
            @Override
            public void onChanged(List<News> news) {

                Toast.makeText(getApplicationContext(),"On Changed.",Toast.LENGTH_SHORT).show();
                newsAdapter.setNewsList(news);
            }
        });
    }
}
