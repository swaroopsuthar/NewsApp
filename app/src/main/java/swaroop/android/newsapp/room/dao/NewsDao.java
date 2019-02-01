package swaroop.android.newsapp.room.dao;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import swaroop.android.newsapp.room.entity.News;

@Dao
public abstract class NewsDao extends BaseDao<News> {

    @Query("SELECT * FROM news")
    public abstract LiveData<List<News>> findAll();
}
