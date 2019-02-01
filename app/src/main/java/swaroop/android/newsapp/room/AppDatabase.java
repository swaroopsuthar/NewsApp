package swaroop.android.newsapp.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import swaroop.android.newsapp.room.dao.NewsDao;
import swaroop.android.newsapp.room.entity.News;

@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract  NewsDao newsDao();

    public  static synchronized AppDatabase getInstance(Context context) {
        if( instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "news_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
        }

        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };


    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void> {
        private  NewsDao newsDao;

        private PopulateDBAsyncTask(AppDatabase db) {
            this.newsDao = db.newsDao();
        }

        @Override
        protected Void doInBackground(Void ... voids) {
            String authorName = "Swaroop Suthar";
            String title = "Silicon Labs bets on Bluetooth for IoT-based location services";
            String desc = "US-based fabless semiconductor firm Silicon Labs has introduced its new Bluetooth-based direction finding solution";
            String longDesc = "US-based fabless semiconductor firm Silicon Labs has introduced its new Bluetooth-based direction finding solution";
            String url = "https://ibb.co/HrsBW3C";
            String imageUrl = "https://ibb.co/HrsBW3C";
            newsDao.insert(new News(authorName, title, desc, longDesc, url, imageUrl));

            return null;
        }
    }
}
