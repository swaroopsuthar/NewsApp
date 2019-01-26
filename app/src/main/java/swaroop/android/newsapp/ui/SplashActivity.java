package swaroop.android.newsapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import swaroop.android.newsapp.MainActivity;
import swaroop.android.newsapp.R;

public class SplashActivity extends AppCompatActivity {

    private TextView textTile, textSlogan;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = (ImageView) findViewById(R.id.app_logo);
        textTile = (TextView) findViewById(R.id.app_title);
        textSlogan = (TextView) findViewById(R.id.app_slogan);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        textTile.startAnimation(animation);
        imageView.startAnimation(animation);
        textSlogan.startAnimation(animation);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, GithubActivity.class));
                finish();
            }
        }, 4000);

    }


}
