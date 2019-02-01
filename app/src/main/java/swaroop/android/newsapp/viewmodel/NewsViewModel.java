package swaroop.android.newsapp.viewmodel;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import swaroop.android.newsapp.repository.NewsRepository;
import swaroop.android.newsapp.room.entity.News;

public class NewsViewModel extends AndroidViewModel {

    private NewsRepository newsRepository;
    private LiveData<List<News>> allNewsList;

    public NewsViewModel(@NonNull Application application) {
        super(application);

        newsRepository = new NewsRepository(application);
        allNewsList = newsRepository.findAll();
    }

    public void insert(News news) {
        newsRepository.insert(news);
    }

    public LiveData<List<News>> findAll() {
        return allNewsList;
    }
}
