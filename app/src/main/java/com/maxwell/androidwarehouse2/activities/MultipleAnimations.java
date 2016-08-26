package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.maxwell.androidwarehouse2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 13/12/2015.
 */
public class MultipleAnimations extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.simpleImage)
    ImageView simpleImage;
    @Bind(R.id.simpleImageTwo)
    ImageView simpleImageTwo;
    @Bind(R.id.simpleImageThree)
    ImageView simpleImageThree;
    @Bind(R.id.simpleImageFour)
    ImageView simpleImageFour;
    @Bind(R.id.simpleImageFive)
    ImageView simpleImageFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_layout);
        ButterKnife.bind(this);

        simpleImage.setOnClickListener(this);
        simpleImageTwo.setOnClickListener(this);
        simpleImageThree.setOnClickListener(this);
        simpleImageFour.setOnClickListener(this);
        simpleImageFive.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Animation anim;
        switch (v.getId()) {
            case R.id.simpleImage:
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                simpleImage.startAnimation(anim);
                break;
            case R.id.simpleImageTwo:
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
                simpleImageTwo.startAnimation(anim);
                break;
            case R.id.simpleImageThree:
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
                simpleImageThree.startAnimation(anim);
                break;
            case R.id.simpleImageFour:
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                simpleImageFour.startAnimation(anim);
                break;
            case R.id.simpleImageFive:
                anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
                simpleImageFive.startAnimation(anim);
                break;
        }
    }
}
