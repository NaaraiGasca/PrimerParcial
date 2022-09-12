package com.example.primerparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Television extends AppCompatActivity {

    Button btnV1, btnV2, btnV3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_television);

        btnV1= findViewById(R.id.btnTVideo1);
        String path1 = "android.resource://" + getPackageName() + "/" + R.raw.video1;

        btnV2 = findViewById(R.id.btnTVideo2);
        String path2 = "android.resource://" + getPackageName() + "/" + R.raw.video2;

        btnV3 = findViewById(R.id.btnTVideo3);
        String path3 = "android.resource://" + getPackageName() + "/" + R.raw.video3;

        btnV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finding videoview by its id
                VideoView videoView = findViewById(R.id.vdTVideoView1);

                // Uri object to refer the
                // resource from the videoUrl
                Uri uri = Uri.parse(path1);

                // sets the resource from the
                // videoUrl to the videoView
                videoView.setVideoURI(uri);

                // creating object of
                // media controller class
                MediaController mediaController = new MediaController(Television.this);

                // sets the anchor view
                // anchor view for the videoView
                mediaController.setAnchorView(videoView);

                // sets the media player to the videoView
                mediaController.setMediaPlayer(videoView);

                // sets the media controller to the videoView
                videoView.setMediaController(mediaController);

                // starts the video
                videoView.start();

            }
        });



        btnV2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finding videoview by its id
                VideoView videoView = findViewById(R.id.vdTVideoView2);

                // Uri object to refer the
                // resource from the videoUrl
                Uri uri = Uri.parse(path2);

                // sets the resource from the
                // videoUrl to the videoView
                videoView.setVideoURI(uri);

                // creating object of
                // media controller class
                MediaController mediaController = new MediaController(Television.this);

                // sets the anchor view
                // anchor view for the videoView
                mediaController.setAnchorView(videoView);

                // sets the media player to the videoView
                mediaController.setMediaPlayer(videoView);

                // sets the media controller to the videoView
                videoView.setMediaController(mediaController);

                // starts the video
                videoView.start();
            }
        });


        btnV3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finding videoview by its id
                VideoView videoView = findViewById(R.id.vdTVideoView3);

                // Uri object to refer the
                // resource from the videoUrl
                Uri uri = Uri.parse(path3);

                // sets the resource from the
                // videoUrl to the videoView
                videoView.setVideoURI(uri);

                // creating object of
                // media controller class
                MediaController mediaController = new MediaController(Television.this);

                // sets the anchor view
                // anchor view for the videoView
                mediaController.setAnchorView(videoView);

                // sets the media player to the videoView
                mediaController.setMediaPlayer(videoView);

                // sets the media controller to the videoView
                videoView.setMediaController(mediaController);

                // starts the video
                videoView.start();
            }
        });
    }
}