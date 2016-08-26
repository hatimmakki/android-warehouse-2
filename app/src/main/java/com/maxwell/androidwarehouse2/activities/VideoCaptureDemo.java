package com.maxwell.androidwarehouse2.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.maxwell.androidwarehouse2.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Maximiliano on 02/11/15.
 */
public class VideoCaptureDemo extends AppCompatActivity implements View.OnClickListener {

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;

    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 0;
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 1;
    private static final int VIDEO_GALLERY_ACTIVITY_REQUEST_CODE = 2;

    private Uri fileUri;
    private String lastVideoRecorded;
    private String playingVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videocapture_layout);

        Button newVideoButton = (Button) findViewById(R.id.newVideoButton);
        Button playVideo = (Button) findViewById(R.id.playVideo);
        Button chooseVideo = (Button) findViewById(R.id.chooseVideoButton);

        newVideoButton.setOnClickListener(this);
        playVideo.setOnClickListener(this);
        chooseVideo.setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE) {
                playingVideo = lastVideoRecorded;

            } else if (requestCode == VIDEO_GALLERY_ACTIVITY_REQUEST_CODE) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();
                playingVideo = picturePath;

                playVideo();
            }
        }
        else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, "Video has been canceled", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Error while recording video", Toast.LENGTH_LONG).show();
        }
    }

    private static Uri getOutputMediaFileUri(int type){
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type){
        // Para asegurarse que este montada la SDCard usar Environment.getExternalStorageState() antes...

        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory (Environment.DIRECTORY_PICTURES), "AndroidLib");
        // Sirve para que se guarden en la carpeta publica mencionada.
        // Se puede compartir el contenido con otras apps y persistira si la app es eliminada.

        // Crear la carpeta si no existe
        if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("AndroidLib", "failed to create directory");
                return null;
            }
        }

        // Crear el path final del file
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE)
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg");
        else if (type == MEDIA_TYPE_VIDEO)
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID_"+ timeStamp + ".mp4");
        else
            return null;

        return mediaFile;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.newVideoButton:
                newVideo();
                break;
            case R.id.playVideo:
                if (playingVideo != null)
                    playVideo();
                else Toast.makeText(this, "Abrir o grabar video", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chooseVideoButton:
                chooseVideo();
                break;
            default:
                break;
        }
    }

    public void newVideo() {

        fileUri = getOutputMediaFileUri(MEDIA_TYPE_VIDEO);
        lastVideoRecorded = fileUri.toString();

        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 30);

        startActivityForResult(intent, CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE);
    }

    public void playVideo() {

        VideoView vd = (VideoView) findViewById(R.id.VideoView);
        vd.setVisibility(View.VISIBLE);

        Uri uri = Uri.parse(playingVideo);
        MediaController mc = new MediaController(this);
        vd.setMediaController(mc);
        vd.requestFocus();
        vd.setVideoURI(uri);
        vd.start();
    }

    public void chooseVideo () {
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, VIDEO_GALLERY_ACTIVITY_REQUEST_CODE);

        //OPCION 1 , menu para elegir grabar o seleccionar

        /*Intent pickIntent = new Intent();
        pickIntent.setType("video/*");
        pickIntent.setAction(Intent.ACTION_GET_CONTENT);

        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String pickTitle = "Select or take a new Video";
        Intent chooserIntent = Intent.createChooser(pickIntent, pickTitle);
        chooserIntent.putExtra (Intent.EXTRA_INITIAL_INTENTS, new Intent[] { takeVideoIntent, takePictureIntent });

        startActivityForResult(chooserIntent, VIDEO_GALLERY_ACTIVITY_REQUEST_CODE); */
    }
}
