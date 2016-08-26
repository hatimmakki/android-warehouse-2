package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class SimpleAnimation extends AppCompatActivity {
    ViewGroup rlAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_animation_layout);

        rlAnimation = (ViewGroup) findViewById(R.id.rlAnimation);

        rlAnimation.setOnTouchListener(
                new RelativeLayout.OnTouchListener(){
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        moveButton();
                        return true;
                    }
                }
        );
    }

    public void moveButton(){
        View buttonAnimation = findViewById(R.id.buttonAnimation);

        TransitionManager.beginDelayedTransition(rlAnimation);

        RelativeLayout.LayoutParams positionRules = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);

        positionRules.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        positionRules.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        buttonAnimation.setLayoutParams(positionRules);

        ViewGroup.LayoutParams sizeRules = buttonAnimation.getLayoutParams();
        sizeRules.width = 450;
        sizeRules.height = 300;
        buttonAnimation.setLayoutParams(sizeRules);
    }
}
