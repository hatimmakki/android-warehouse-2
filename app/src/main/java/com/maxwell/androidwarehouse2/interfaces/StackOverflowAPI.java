package com.maxwell.androidwarehouse2.interfaces;

import com.maxwell.androidwarehouse2.models.stackoverflow.items;
import com.maxwell.androidwarehouse2.models.stackoverflow.question;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Maxwell on 12/08/2016.
 */
public interface StackOverflowAPI {

    @GET("questions?order=desc&site=stackoverflow&filter=!-*f(6rc.lFba")
    Call<items<question>> loadQuestionsByTag(@Query("tagged") String tags, @Query("sort") String sort);
}