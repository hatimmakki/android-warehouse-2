package com.maxwell.androidwarehouse2.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.maxwell.androidwarehouse2.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maxwell on 22/09/2015.
 */
public class SnackbarDemo extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.buttonUno) Button buttonUno;
    @Bind(R.id.buttonDos) Button buttonDos;
    @Bind(R.id.buttonTres) Button buttonTres;
    @Bind(R.id.buttonCuatro) Button buttonCuatro;
    @Bind(R.id.buttonCinco) Button buttonCinco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.snackbars_layout);

        ButterKnife.bind(this);

        buttonUno.setOnClickListener(this);
        buttonDos.setOnClickListener(this);
        buttonTres.setOnClickListener(this);
        buttonCuatro.setOnClickListener(this);
        buttonCinco.setOnClickListener(this);
    }

    void generateSnackbar(String content, int duration, String action, int color){
        Snackbar.make(findViewById(android.R.id.content), content, duration)
                .setAction(action, clickListener)
                .setActionTextColor(color)
                .show();
    }

    final View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            //la nada misma!
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonUno:
                generateSnackbar("Esto es un snackBar!", Snackbar.LENGTH_LONG, "OK!", Color.RED);
                break;
            case R.id.buttonDos:
                generateSnackbar("Esto es otro snackBar!", Snackbar.LENGTH_SHORT, "OK!", Color.BLACK);
                break;
            case R.id.buttonTres:
                generateSnackbar("Esto es uno de tantos snackBar!", Snackbar.LENGTH_LONG, "OK!", Color.BLUE);
                break;
            case R.id.buttonCuatro:
                generateSnackbar("Adivina: esto tambien es un snackBar!", Snackbar.LENGTH_SHORT, "OK!", Color.YELLOW);
                break;
            case R.id.buttonCinco:
                generateSnackbar("Demasiados snackBars, no?...", Snackbar.LENGTH_INDEFINITE, "OK!",Color.GREEN);
                break;
        }
    }
}
