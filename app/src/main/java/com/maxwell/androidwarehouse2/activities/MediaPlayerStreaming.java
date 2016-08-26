package com.maxwell.androidwarehouse2.activities;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.maxwell.androidwarehouse2.R;

import java.io.IOException;

/**
 * Created by Maximiliano on 29/07/15.
 */
public class MediaPlayerStreaming extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    TextView buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        buffer = (TextView) findViewById(R.id.buffer);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }

    public void play(View view) {
        String url = "https://archive.org/download/LevaduraPodcastEpisodio27/Levadura%20Podcast%20Episodio%2027.mp3"; // your URL here
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync(); // might take long! (for buffering, etc)
            buffer.setVisibility(View.VISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer player) {
                buffer.setVisibility(View.GONE);
                player.start();
            }

        });
    }
}
