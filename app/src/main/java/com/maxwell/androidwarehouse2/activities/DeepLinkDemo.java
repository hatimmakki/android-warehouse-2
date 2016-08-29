package com.maxwell.androidwarehouse2.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 29/08/2016.
 */
public class DeepLinkDemo extends AppCompatActivity {
    @Bind(R.id.tvContent)
    TextView tvContent;
    @Bind(R.id.btClickMe)
    Button btClickMe;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String action = intent.getAction();
        String data = intent.getDataString();

        if (Intent.ACTION_VIEW.equals(action) && data != null) {
            String content = data.substring(data.lastIndexOf("/") + 1);
            tvContent.setText(content);
        }
    }
}
