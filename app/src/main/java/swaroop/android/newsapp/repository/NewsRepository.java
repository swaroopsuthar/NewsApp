package swaroop.android.newsapp.repository;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;
import swaroop.android.newsapp.room.AppDatabase;
import swaroop.android.newsapp.room.dao.NewsDao;
import swaroop.android.newsapp.room.entity.News;

public class NewsRepository {
    private NewsDao newsDao;
    private LiveData<List<News>> listNewsData;

    public NewsRepository(Application application) {
        AppDatabase newsDatabase = AppDatabase.getInstance(application);
        newsDao = newsDatabase.newsDao();
        listNewsData = newsDao.findAll();
    }

    public void insert(News news) {
        new InsertAsyncTask(newsDao).execute(news);
    }

    public void update(News news) {

    }

    public void delete(News news) {

    }

    public LiveData<List<News>> findAll() {
        return listNewsData;
    }

    private static class InsertAsyncTask extends AsyncTask<News, Void, Void> {
        private  NewsDao newsDao;

        private InsertAsyncTask(NewsDao newsDao) {
            this.newsDao = newsDao;
        }

        @Override
        protected Void doInBackground(News... news) {
            newsDao.insert(news[0]);
            return null;
        }
    }

}
