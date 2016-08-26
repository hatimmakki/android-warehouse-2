package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.utils.FontManger;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 08/10/2015.
 */
public class FontManagerDemo extends AppCompatActivity {
    @Bind(R.id.simpleText)
    TextView simpleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);
        ButterKnife.bind(this);

        simpleText.setText("Esto es una prueba de tipografia!!!");
        FontManger.changeFontTo(FontManger.FontTypeEnum.MUSEO_SANS_700, simpleText);
    }
}
