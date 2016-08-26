package com.maxwell.androidwarehouse2.activities;

import android.annotation.TargetApi;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.maxwell.androidwarehouse2.R;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by MauroLombardi on 9/16/15.
 */
public class TTS extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private ImageView speechButton;
    private TextToSpeech engine;
    private EditText editText;
    private SeekBar seekPitch;
    private SeekBar seekSpeed;
    private double pitch = 1.0;
    private double speed = 1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tts_layout);

        speechButton = (ImageView) findViewById(R.id.speechImg);
        editText = (EditText) findViewById(R.id.sentence);
        engine = new TextToSpeech(this, this);

        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speech();
            }
        });
        seekPitch = (SeekBar) findViewById(R.id.seekPitch);
        seekPitch.setThumbOffset(5);
        seekPitch.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Log.d("Speech", "Progress ["+progress+"]");
                pitch = (float) progress / (seekBar.getMax() / 2);
                //Log.d("Speech", "Pitch ["+pitch+"]");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekSpeed = (SeekBar) findViewById(R.id.seekSpeed);
        seekSpeed.setThumbOffset(5);
        seekSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Log.d("Speech", "Progress ["+progress+"]");
                speed = (float) progress / (seekBar.getMax() / 2);
                //Log.d("Speech", "Pitch ["+pitch+"]");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }


    @Override
    public void onInit(int status) {
        Log.d("Speech", "OnInit - Status [" + status + "]");

        if (status == TextToSpeech.SUCCESS) {
            Log.d("Speech", "Success!");
            engine.setLanguage(new Locale("es", "ES"));
        }
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private void speech() {
        engine.setPitch((float) pitch);
        engine.setSpeechRate((float) speed);
        String speech = editText.getText().toString();
//        engine.synthesizeToFile(editText.getText().toString(),null,file,null);
//        engine.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
        engine.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {
                Log.d(utteranceId, "start");
            }

            @Override
            public void onDone(String utteranceId) {
                Log.d(utteranceId, "done");
            }

            @Override
            public void onError(String utteranceId) {
                Log.d(utteranceId, "error");
            }
        });
        /* esto de aca no anda, guarda el archivo pero debe estar corrupto porque no se puede reproducir */
        try {
            HashMap<String, String> myHashRender = new HashMap();
            PackageManager m = getPackageManager();
            String s = getPackageName();
            PackageInfo p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.dataDir;
            String destFileName = Environment.getExternalStorageDirectory().getAbsolutePath() + "/file.mp3";

            myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, editText.getText().toString());

            File f = new File(destFileName);
            f.createNewFile();
            if (f.exists()) {
                engine.synthesizeToFile(editText.getText().toString(),myHashRender, destFileName);

                engine.addSpeech(speech, destFileName);
                engine.speak(speech, TextToSpeech.QUEUE_ADD, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        engine.shutdown();
    }
}