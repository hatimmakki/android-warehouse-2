package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 22/09/2015.
 */
public class ParallaxWithCardView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parallax_with_cardview);

        inflateLayout();
    }

    void inflateLayout(){
        LinearLayout containerItems = (LinearLayout) findViewById(R.id.containerItems);

        for (int i = 0; i < 20; i++){
            View v = getLayoutInflater().inflate(R.layout.item_image_main, null);
            TextView nameItem = (TextView) v.findViewById(R.id.nameItem);

            nameItem.setText("Nota numero " + i);

            containerItems.addView(v);
        }
    }
}
