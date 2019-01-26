package swaroop.android.newsapp.ui;

import android.app.Application;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import swaroop.android.newsapp.MyApplication;
import swaroop.android.newsapp.R;
import swaroop.android.newsapp.adapter.GithubAdapter;
import swaroop.android.newsapp.di.component.activity.DaggerGithubActivityComponent;
import swaroop.android.newsapp.di.component.activity.GithubActivityComponent;
import swaroop.android.newsapp.di.module.activity.GithubActivityModule;
import swaroop.android.newsapp.model.GithubRepo;
import swaroop.android.newsapp.network.APIInterface;

public class GithubActivity extends AppCompatActivity {

    ListView listView;

    Call<List<GithubRepo>> githubRepoCall;

    @Inject
    APIInterface githubService;

    @Inject
    GithubAdapter githubAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github);

        listView = (ListView) findViewById(R.id.github_repo_list);

        GithubActivityComponent githubActivityComponent = DaggerGithubActivityComponent.builder()
                .githubActivityModule(new GithubActivityModule(this))
                .networkComponent(MyApplication.get(this).component())
                .build();

        githubActivityComponent.injectGithubActivity(this);

        listView.setAdapter(githubAdapter);

        githubRepoCall = githubService.getAllRepos();
        githubRepoCall.enqueue(new Callback<List<GithubRepo>>() {
            @Override
            public void onResponse(Call<List<GithubRepo>> call, Response<List<GithubRepo>> response) {
                githubAdapter.insertData(response.body());
            }

            @Override
            public void onFailure(Call<List<GithubRepo>> call, Throwable t) {
                Toast.makeText(GithubActivity.this, "Error getting repos " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(githubRepoCall != null) {
            githubRepoCall.cancel();
        }
    }
}
