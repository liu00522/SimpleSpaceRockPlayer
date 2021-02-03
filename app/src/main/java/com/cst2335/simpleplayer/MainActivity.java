package com.cst2335.simpleplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button playBtn, pauseBtn, stopBtn;
    MediaPlayer mp;
    int pauseTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button play = findViewById(R.id.playBtn);
        Button pause = findViewById(R.id.pauseBtn);
        Button stop = findViewById(R.id.stopBtn);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.playBtn:
                if (mp == null) {
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mp.start();
                } else if (!mp.isPlaying()) {
                    mp.seekTo(pauseTime);
                    mp.start();
                }
                break;


            case R.id.pauseBtn:
                if (mp != null) {
                    mp.pause();
                    pauseTime = mp.getCurrentPosition();
                }
                break;

            case R.id.stopBtn:
                if (mp != null) {
                    mp.stop();
                    mp = null;
                }

        }
    }
}