package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maxwell.androidwarehouse2.utils.DialogUtils;

import java.util.ArrayList;

/**
 * Created by Maxwell on 02/10/2015.
 */
public class DialogDemo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList<String> content = new ArrayList<>();
        content.add("Facebook Login");
        content.add("Desea ir hacia el login de Facebook?");
        content.add("LLEVAME!");
        content.add("MEJOR NO");

        DialogUtils dialog = new DialogUtils(this,DummyActivity.class,content);
        dialog.show();
    }
}
