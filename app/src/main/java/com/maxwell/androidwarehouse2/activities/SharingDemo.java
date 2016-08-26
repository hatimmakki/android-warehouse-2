package com.maxwell.androidwarehouse2.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.maxwell.androidwarehouse2.R;

/**
 * Created by Maxwell on 10/10/2015.
 */
public class SharingDemo extends AppCompatActivity implements View.OnClickListener{
    Intent sendIntent;
    Uri urlImage;
    Button btShareText, btShareChooser, btShareImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_layout);

        urlImage = Uri.parse("android.resource://" + getPackageName() + "/images/" + R.drawable.fenix);

        btShareText = (Button) findViewById(R.id.btShareText);
        btShareChooser = (Button) findViewById(R.id.btShareChooser);
        btShareImage = (Button) findViewById(R.id.btShareImage);

        btShareText.setOnClickListener(this);
        btShareChooser.setOnClickListener(this);
        btShareImage.setOnClickListener(this);

        sendIntent = new Intent();
    }

    void shareText(){
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    void shareChooser(){
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Share Content!"));
    }

    void shareBinary(){
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_STREAM, urlImage);
        sendIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(sendIntent, "Share Content!"));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btShareText:
                shareText();
                break;
            case R.id.btShareChooser:
                shareChooser();
                break;
            case R.id.btShareImage:
                shareBinary();
                break;
        }
    }
}
