package swaroop.android.newsapp.adapter.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Locale;

import androidx.annotation.NonNull;
import swaroop.android.newsapp.R;
import swaroop.android.newsapp.model.GithubRepo;

@SuppressLint("ViewConstructor")
public class GithubRepoListItem extends FrameLayout {

    private final Picasso picasso;

    TextView name;
    TextView description;
    ImageView avatarImage;

    public GithubRepoListItem(@NonNull Context context, Picasso picasso) {
        super(context);
        this.picasso = picasso;
        inflate(getContext(), R.layout.list_github_repo_item, this);

        name        = (TextView) findViewById(R.id.repo_name);
        description = (TextView) findViewById(R.id.repo_description);
        avatarImage = (ImageView) findViewById(R.id.user_avatar);

    }

    public void setRepo(GithubRepo githubRepo) {

        name.setText(githubRepo.name);
        description.setVisibility(TextUtils.isEmpty(githubRepo.description) ? GONE : VISIBLE);
        description.setText(githubRepo.description);

        picasso.load(githubRepo.owner.avatarUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(avatarImage);
    }
}
