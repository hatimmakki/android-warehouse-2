package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.adapters.QuestionAdapter;
import com.maxwell.androidwarehouse2.interfaces.StackOverflowAPI;
import com.maxwell.androidwarehouse2.models.stackoverflow.items;
import com.maxwell.androidwarehouse2.models.stackoverflow.question;
import com.maxwell.androidwarehouse2.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Maxwell on 12/08/2016.
 */
public class StackOverflowAPIRetrofitDemo extends AppCompatActivity implements Callback<items<question>> {
    QuestionAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    items<question> questionList = new items<>();
    Call<items<question>> call;
    @Bind(R.id.rvHome)
    RecyclerView rvHome;
    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stackoverflow_layout);

        ButterKnife.bind(this);

        pbLoading.setVisibility(View.VISIBLE);

        rvHome.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvHome.setLayoutManager(layoutManager);

        adapter = new QuestionAdapter(questionList, this);
        rvHome.setAdapter(adapter);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.API_STACK_OVERFLOW)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        StackOverflowAPI stackOverflowAPI = retrofit.create(StackOverflowAPI.class);

        call = stackOverflowAPI.loadQuestionsByTag("android", "activity");
        call.enqueue(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
        call.cancel();
    }

    @Override
    public void onResponse(Call<items<question>> call, Response<items<question>> response) {
        adapter.clearQuestionList();
        adapter.setQuestionList(response.body());
        adapter.notifyDataSetChanged();
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(Call<items<question>> call, Throwable t) {
        Toast.makeText(StackOverflowAPIRetrofitDemo.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
    }
}
