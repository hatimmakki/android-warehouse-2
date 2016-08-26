package com.maxwell.androidwarehouse2.activities;

import android.media.MediaCodec;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Surface;
import android.view.SurfaceView;

import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.FrameworkSampleSource;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.TrackRenderer;
import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.utils.Constants;

/**
 * Created by Maxwell on 04/11/2015.
 */
public class ExoPlayerDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.exoplayer_layout);

        SurfaceView wrapperExoPlayer = (SurfaceView) findViewById(R.id.wrapperExoPlayer);

        play(Constants.URL_VIDEO, wrapperExoPlayer.getHolder().getSurface());
    }

    void play(String strUri, Surface surface) {
        Uri uri = Uri.parse(strUri);
        final int numRenderers = 2;

        // Build the sample source
        SampleSource sampleSource =
                new FrameworkSampleSource(this, uri, /* headers */ null);

        // Build the track renderers
        TrackRenderer videoRenderer = new MediaCodecVideoTrackRenderer(this,sampleSource, MediaCodec.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        TrackRenderer audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource);

        // Build the ExoPlayer and start playback
        ExoPlayer exoPlayer = ExoPlayer.Factory.newInstance(numRenderers);
        exoPlayer.prepare(videoRenderer, audioRenderer);

        // Pass the surface to the video renderer.
        exoPlayer.sendMessage(videoRenderer, MediaCodecVideoTrackRenderer.MSG_SET_SURFACE, surface);

        exoPlayer.setPlayWhenReady(true);
    }
}
