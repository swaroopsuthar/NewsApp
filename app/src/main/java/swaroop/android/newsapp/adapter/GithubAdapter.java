package swaroop.android.newsapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import swaroop.android.newsapp.adapter.view.GithubRepoListItem;
import swaroop.android.newsapp.di.qualifiers.ApplicationContext;
import swaroop.android.newsapp.model.GithubRepo;
import swaroop.android.newsapp.ui.GithubActivity;

public class GithubAdapter extends BaseAdapter {

    private final List<GithubRepo> githubRepoList = new ArrayList<>(0);
    private final Context context;
    private final Picasso picasso;

    @Inject
    public GithubAdapter(GithubActivity context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
    }

    @Override
    public int getCount() {
        return githubRepoList.size();
    }

    @Override
    public Object getItem(int position) {
        return githubRepoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return githubRepoList.get(position).id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        GithubRepoListItem githubRepoListItem;
        if(view == null) {
            githubRepoListItem = new GithubRepoListItem(context, picasso);
        } else {
            githubRepoListItem = GithubRepoListItem.class.cast(view);
        }

        githubRepoListItem.setRepo(githubRepoList.get(position));

        return githubRepoListItem;
    }

    public void insertData(Collection<GithubRepo> githubRepos) {
        githubRepoList.clear();
        if(githubRepos != null) {
            githubRepoList.addAll(githubRepos);
        }
        notifyDataSetChanged();
    }
}
