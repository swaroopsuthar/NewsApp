package swaroop.android.newsapp.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import swaroop.android.newsapp.model.GithubRepo;
import swaroop.android.newsapp.model.NewsResult;

import static swaroop.android.newsapp.utils.Constants.NEWS_API_KEY;

public interface APIInterface {

    @GET("top-headlines?country=in&apiKey="+ NEWS_API_KEY)
    Call<List<NewsResult>> getTopHeadlines();

    @GET
    Call<List> getNewsData(@Url String url, @Query("format") String format);

    //GitHub

    @GET("users/{username}/repos")
    Call<List<GithubRepo>> getReposForUser(@Path("username") String username);

    @GET("repositories")
    Call<List<GithubRepo>> getAllRepos();

}
