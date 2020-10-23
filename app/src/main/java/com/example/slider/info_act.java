package com.example.slider;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class info_act extends AppCompatActivity {

    private VideoView vd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);
        vd = (VideoView)findViewById(R.id.vd);

        String ruta_video = "android.resource://" + getPackageName() + "/" +  R.raw.video;
        Uri uri = Uri.parse(ruta_video); //
        vd.setVideoURI(uri);

        //CONTROLES DE NAVEGACION EN EL VIDEO
        MediaController media = new MediaController(this);
        vd.setMediaController(media);
    }


}