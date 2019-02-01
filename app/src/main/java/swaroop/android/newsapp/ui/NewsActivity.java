package swaroop.android.newsapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import swaroop.android.newsapp.R;
import swaroop.android.newsapp.adapter.NewsAdapter;
import swaroop.android.newsapp.room.entity.News;
import swaroop.android.newsapp.viewmodel.NewsViewModel;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class NewsActivity extends AppCompatActivity {

    private NewsViewModel newsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        RecyclerView recyclerView = findViewById(R.id.new_item_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        final NewsAdapter newsAdapter = new NewsAdapter();
        recyclerView.setAdapter(newsAdapter);

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
