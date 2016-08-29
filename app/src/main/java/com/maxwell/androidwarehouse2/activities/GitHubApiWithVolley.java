package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.helpers.VolleyHelper;
import com.maxwell.androidwarehouse2.interfaces.OnGitHubResult;
import com.maxwell.androidwarehouse2.loaders.GitHubLoader;
import com.maxwell.androidwarehouse2.models.github.GitHubUser;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class GitHubApiWithVolley extends AppCompatActivity implements OnGitHubResult{
    @Bind(R.id.avatar)
    ImageView avatar;
    @Bind(R.id.username)
    TextView username;
    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.location)
    TextView location;
    @Bind(R.id.blog)
    TextView blog;
    @Bind(R.id.email)
    TextView email;
    @Bind(R.id.repos)
    TextView repos;
    @Bind(R.id.gists)
    TextView gists;
    @Bind(R.id.followers)
    TextView followers;
    @Bind(R.id.following)
    TextView following;

    private GitHubLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_layout);

        ButterKnife.bind(this);

        loader = new GitHubLoader(this,"maxwellnewage");

        VolleyHelper.getInstance(this).addToRequestQueue(loader.getRequest());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleyHelper.getInstance(this).getRequestQueue().cancelAll(loader.TAG);
    }

    @Override
    public void onSuccess(GitHubUser res) {
        username.setText(res.getLogin());
        name.setText(res.getName());
        location.setText("Pais: " + res.getLocation());
        blog.setText("Blog: " + res.getBlog());
        email.setText("E-mail: " + res.getEmail());
        repos.setText("Repositorios: " + res.getPublic_repos());
        gists.setText("Gists: " + res.getPublic_gists());
        followers.setText("Seguidores: " + res.getFollowers());
        following.setText("Siguiendo: " + res.getFollowing());
    }

    @Override
    public void onNetworkError() {

    }

    @Override
    public void onError() {

    }
}
