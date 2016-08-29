package com.maxwell.androidwarehouse2.interfaces;

import com.maxwell.androidwarehouse2.models.twitter.Status;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Maxwell on 19/08/2016.
 */
public interface TwitterAPI {
    // Search tweets
    @GET("1.1/search/tweets.json")
    Call<Status> loadTweetsBySearch(@Query("q") String query);
}
