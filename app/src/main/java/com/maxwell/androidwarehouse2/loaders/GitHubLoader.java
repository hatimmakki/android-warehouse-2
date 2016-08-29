package com.maxwell.androidwarehouse2.loaders;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.maxwell.androidwarehouse2.helpers.GsonRequest;
import com.maxwell.androidwarehouse2.interfaces.OnGitHubResult;
import com.maxwell.androidwarehouse2.models.github.GitHubUser;
import com.maxwell.androidwarehouse2.utils.Constants;

/**
 * Created by Maximiliano on 28/10/15.
 */
public class GitHubLoader extends RequestLoader {
    private final String URL = Constants.API_GITHUB+"/users/";
    public static String TAG = "GitHubLoader";
    private OnGitHubResult gitHubResult;
    private String user;

    public GitHubLoader(OnGitHubResult gitHubResult, String user) {
        this.gitHubResult = gitHubResult;
        this.user = user;
    }

    @Override
    protected Request generateRequest(String url) {
        GsonRequest gsonRequest = new GsonRequest(Request.Method.GET, url, GitHubUser.class, new Response.Listener<GitHubUser>() {
            @Override
            public void onResponse(GitHubUser response) {
                gitHubResult.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                gitHubResult.onNetworkError();
                gitHubResult.onError();
            }
        });

        gsonRequest.setTag(TAG);

        return gsonRequest;
    }

    @Override
    protected String generateUrl() {
        return URL + user;
    }
}
