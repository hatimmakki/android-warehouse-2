package com.maxwell.androidwarehouse2.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.adapters.TweetAdapter;
import com.maxwell.androidwarehouse2.loaders.TwitterLoader;
import com.maxwell.androidwarehouse2.models.twitter.Status;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Maxwell on 29/08/2016.
 */
public class TwitterAPIDemo extends AppCompatActivity implements Callback<Status> {
    @Bind(R.id.etSearch)
    EditText etSearch;
    @Bind(R.id.rvHome)
    RecyclerView rvHome;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;
    RecyclerView.LayoutManager layoutManager;
    Status tweetList = new Status();
    TweetAdapter adapter;
    Call<Status> call;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.twitter_search_layout);
        ButterKnife.bind(this);

        rvHome.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvHome.setLayoutManager(layoutManager);

        adapter = new TweetAdapter(tweetList, this);
        rvHome.setAdapter(adapter);

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (etSearch.getText().toString().length() > 2) {
                    pbLoading.setVisibility(View.VISIBLE);
                    TwitterLoader twitterLoader = new TwitterLoader();
                    call = twitterLoader.loadTweetsBySearch(etSearch.getText().toString());
                    call.enqueue(TwitterAPIDemo.this);
                } else {
                    adapter.clearTweetList();
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        rvHome.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(etSearch.getWindowToken(), 0);
                return false;
            }
        });

    }


    @Override
    public void onResponse(Call<Status> call, Response<Status> response) {
        adapter.clearTweetList();
        adapter.setTweetList(response.body());
        adapter.notifyDataSetChanged();
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(Call<Status> call, Throwable t) {
        Log.d("debug_max", t.getLocalizedMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        if(call != null)
            call.cancel();
    }
}
