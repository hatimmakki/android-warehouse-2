package com.maxwell.androidwarehouse2.interfaces;

import com.maxwell.androidwarehouse2.models.github.GitHubUser;

public interface OnGitHubResult {

    void onSuccess(GitHubUser gitHubUser);
    void onNetworkError();
    void onError();
}
