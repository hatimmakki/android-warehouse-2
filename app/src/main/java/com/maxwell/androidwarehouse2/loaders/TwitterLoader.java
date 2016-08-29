package com.maxwell.androidwarehouse2.loaders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maxwell.androidwarehouse2.interfaces.TwitterAPI;
import com.maxwell.androidwarehouse2.models.twitter.Status;
import com.maxwell.androidwarehouse2.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 * Created by Maxwell on 19/08/2016.
 */
public class TwitterLoader {
    TwitterAPI twitterAPI;

    public TwitterLoader() {
        Gson gson = new GsonBuilder()
                .create();

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.CONSUMER_KEY, Constants.CONSUMER_SECRET);
        consumer.setTokenWithSecret(Constants.ACCESS_TOKEN, Constants.SECRET_TOKEN);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new SigningInterceptor(consumer))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_TWITTER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        twitterAPI = retrofit.create(TwitterAPI.class);
    }

    public Call<Status> loadTweetsBySearch(String query){
        Call<Status> call = twitterAPI.loadTweetsBySearch(query);
        return call;
    }
}
