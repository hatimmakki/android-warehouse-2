package com.maxwell.androidwarehouse2.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.maxwell.androidwarehouse2.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by MauroLombardi on 9/24/15.
 */
public class AdvanceTTSAndSTT extends Activity implements RecognitionListener, TextToSpeech.OnInitListener {

    @Bind(R.id.respuesta)
    TextView respuesta;
    @Bind(R.id.init)
    ImageButton init;

    //TTS
    private TextToSpeech engine;
    private double pitch = 1.0;
    private double speed = 1.0;

    //STT
    private SpeechRecognizer speech = null;
    private Intent recognizerIntent;
    private String LOG_TAG = "STT";
    private Handler handler = new Handler();

    private String[] mensajes = {
            "Hola como te llamas",
            "Bienvenido %respuesta, este es un simulador de charla No soy inteligente, tengo mensajes predeterminados.Te gusta programar",
            "A mi tambien",
            "A mi tampoco, es aburrido"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advancettsstt_layout);
        ButterKnife.bind(this);

        initEngine();
        initRecognitionVariables();
        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startConversation(null);
                init.setClickable(false);
            }
        });
    }

    private void initRecognitionVariables() {
        speech = SpeechRecognizer.createSpeechRecognizer(this);
        speech.setRecognitionListener(this);
        recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
                "es");
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                this.getPackageName());
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
        recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3);
    }

    int counter = 0;

    private void startConversation(String laRespuesta) {
        if (counter < mensajes.length) {
            HashMap<String, String> myHashRender = new HashMap();

            if (laRespuesta != null) {
                if (laRespuesta.toLowerCase().equals("no") && counter == 2)
                    counter++;
                String newMessage = mensajes[counter].replace("%respuesta", laRespuesta);
                myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, newMessage);
                engine.speak(newMessage, TextToSpeech.QUEUE_FLUSH, myHashRender);
            } else {
                myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, mensajes[counter]);
                engine.speak(mensajes[counter], TextToSpeech.QUEUE_ADD, myHashRender);
            }

            counter++;
        } else {
            init.setClickable(true);
            Toast.makeText(this, "Termino la demo", Toast.LENGTH_LONG);
//            finish();
        }
    }

    private void initEngine() {
        engine = new TextToSpeech(this, this);
        engine.setPitch((float) pitch);
        engine.setSpeechRate((float) speed);
        setUtterance();
    }

    private void listenUser() {
        this.runOnUiThread(new Runnable() {
            public void run() {
                speech.startListening(recognizerIntent);
            }
        });

        handler.postDelayed(runnable, 1500);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            speech.stopListening();
        }
    };

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
    private void setUtterance() {
        engine.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String utteranceId) {
                Log.d(utteranceId, "start");
            }

            @Override
            public void onDone(String utteranceId) {
                Log.d(utteranceId, "done");
                if (counter < mensajes.length)
                    listenUser();
                else {
                    init.setClickable(true);
                    Toast.makeText(AdvanceTTSAndSTT.this, "Termino la demo", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onError(String utteranceId) {
                Log.d(utteranceId, "error");
            }
        });
    }


    @Override
    public void onReadyForSpeech(Bundle bundle) {
        Log.d(LOG_TAG, "ReadyForSpeech");
    }

    @Override
    public void onBeginningOfSpeech() {
        Log.d(LOG_TAG, "beginningOfSpeech");
    }

    @Override
    public void onRmsChanged(float v) {
        Log.d(LOG_TAG, "rmsChanged");
    }

    @Override
    public void onBufferReceived(byte[] bytes) {
        Log.d(LOG_TAG, "bufferReceived " + bytes);
    }

    @Override
    public void onEndOfSpeech() {
        Log.d(LOG_TAG, "EndOfSpeech");
    }


    @Override
    public void onError(int errorCode) {
        String errorMessage = getErrorText(errorCode);
        Log.d(LOG_TAG, "FAILED " + errorMessage);
        respuesta.setText(errorMessage);
        requestForNewInputOnError();
    }

    private void requestForNewInputOnError() {
        String request = "No logre entenderte, puedes repetir tu respuesta";
        HashMap<String, String> myHashRender = new HashMap();

        myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, request);
        engine.speak(request, TextToSpeech.QUEUE_ADD, myHashRender);
    }

    @Override
    public void onResults(Bundle results) {
        Log.i(LOG_TAG, "onResults");
        ArrayList<String> matches = results
                .getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
        String text = matches.get(0);
//        for (String result : matches)
//            text += result + "\n";

        respuesta.setText(text);
        startConversation(text);
    }

    @Override
    public void onPartialResults(Bundle bundle) {
        Log.d(LOG_TAG, "PartialResults");
    }

    @Override
    public void onEvent(int i, Bundle bundle) {
        Log.d(LOG_TAG, "Event");
    }


    @Override
    public void onInit(int status) {
        Log.d("Speech", "OnInit - Status [" + status + "]");

        if (status == TextToSpeech.SUCCESS) {
            Log.d("Speech", "Success!");
            engine.setLanguage(new Locale("es", "ES"));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        engine.shutdown();
    }

    public static String getErrorText(int errorCode) {
        String message;
        switch (errorCode) {
            case SpeechRecognizer.ERROR_AUDIO:
                message = "Audio recording error";
                break;
            case SpeechRecognizer.ERROR_CLIENT:
                message = "Client side error";
                break;
            case SpeechRecognizer.ERROR_INSUFFICIENT_PERMISSIONS:
                message = "Insufficient permissions";
                break;
            case SpeechRecognizer.ERROR_NETWORK:
                message = "Network error";
                break;
            case SpeechRecognizer.ERROR_NETWORK_TIMEOUT:
                message = "Network timeout";
                break;
            case SpeechRecognizer.ERROR_NO_MATCH:
                message = "No match";
                break;
            case SpeechRecognizer.ERROR_RECOGNIZER_BUSY:
                message = "RecognitionService busy";
                break;
            case SpeechRecognizer.ERROR_SERVER:
                message = "error from server";
                break;
            case SpeechRecognizer.ERROR_SPEECH_TIMEOUT:
                message = "No speech input";
                break;
            default:
                message = "Didn't understand, please try again.";
                break;
        }
        return message;
    }
}
