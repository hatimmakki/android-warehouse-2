package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 26/08/2016.
 */
public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dummy_layout);
    }
}
