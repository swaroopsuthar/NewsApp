package swaroop.android.newsapp.room.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

@Dao
public abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long save(T object);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] save(T... objects);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public abstract long insert(T object);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    public abstract long[] insert(T... objects);

    @Delete
    public abstract void delete(T object);

    public int deleteAll() {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "delete from " + getTableName()
        );
        return doDeleteAll(query);
    }

    public T find(long id) {
        SimpleSQLiteQuery query = new SimpleSQLiteQuery(
                "select * from " + getTableName() + " where id = ?",
                new Object[]{id}
        );
        return doFind(query);
    }

    public String getTableName() {

        Class clazz = (Class)
                ((ParameterizedType) getClass().getSuperclass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        // tableName = StringUtil.toSnakeCase(clazz.getSimpleName());
        String tableName = clazz.getSimpleName();
        return tableName;
    }

    @RawQuery
    protected abstract List<T> doFindAllValid(SupportSQLiteQuery query);

    @RawQuery
    protected abstract T doFind(SupportSQLiteQuery query);

    @RawQuery
    protected abstract int doDeleteAll(SupportSQLiteQuery query);

}
