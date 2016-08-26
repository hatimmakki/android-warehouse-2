package com.maxwell.androidwarehouse2.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

/**
 * Created by Maximiliano on 15/09/15.
 */
public class FacebookShare extends AppCompatActivity {
    final ShareDialog shareDialog = new ShareDialog(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        CallbackManager callbackManager = CallbackManager.Factory.create();

        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {

            @Override
            public void onSuccess(Sharer.Result result) {
                Log.d("debug_max", "success");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("debug_max", "error");
            }

            @Override
            public void onCancel() {
                Log.d("debug_max", "cancel");
            }
        });

        if (shareDialog.canShow(ShareLinkContent.class)) {

            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentTitle("Game Result Highscore")
                    .setContentDescription("My new highscore is 345!!")
                    .setContentUrl(Uri.parse("https://play.google.com/"))
                    .setImageUrl(Uri.parse("http://bagpiper-andy.de/bilder/dudelsack%20app.png"))
                    .build();

            shareDialog.show(linkContent);
        }

    }
}
