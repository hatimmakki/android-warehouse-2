package com.maxwell.androidwarehouse2.activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maximiliano on 23/09/15.
 */
public class PrefsDemo extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.namePrefs)
    TextView namePrefs;
    @Bind(R.id.agePrefs)
    TextView agePrefs;
    @Bind(R.id.savePrefs)
    Button savePrefs;
    @Bind(R.id.editNamePrefs)
    EditText editNamePrefs;
    @Bind(R.id.editAgePrefs)
    EditText editAgePrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prefs_layout);
        ButterKnife.bind(this);

        savePrefs.setOnClickListener(this);

        getPrefs();
    }

    void savePrefs(String name, int age) {
        SharedPreferences.Editor editor = getSharedPreferences(Constants.KEY_PREFS, MODE_PRIVATE).edit();
        editor.putString(Constants.KEY_NAME, name);
        editor.putInt(Constants.KEY_AGE, age);
        editor.commit();

        setTextForTextViews(name, age);
    }

    void getPrefs() {
        SharedPreferences prefs = getSharedPreferences(Constants.KEY_PREFS, MODE_PRIVATE);

        String name = prefs.getString(Constants.KEY_NAME, "No name defined");
        int age = prefs.getInt(Constants.KEY_AGE, 0);

        setTextForTextViews(name, age);
    }

    void setTextForTextViews(String name, int age) {
        namePrefs.setText("Name: " + name);
        agePrefs.setText("Age: " + age);
    }

    @Override
    public void onClick(View view) {
        String name = editNamePrefs.getText().toString();
        String age = editAgePrefs.getText().toString();

        savePrefs(name, Integer.valueOf(age));
    }
}
