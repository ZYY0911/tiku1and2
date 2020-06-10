package com.example.tiku1demo2.activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.tiku1demo2.R;

/**
 * Created by dell on 2019/9/18.
 */

public class S_VIDEOActivity extends AppCompatActivity {
    private SurfaceView surfaceView;
    private MediaPlayer player;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s_videoactivty);
        inview();
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                jiesho();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (player!=null){
                    player.stop();
                }
            }
        });

    }

    private void jiesho() {
        switch (getIntent().getStringExtra("index"))
        {
            case "1":
                player=    player = MediaPlayer.create(this,R.raw.car1);
                break;
            case "2":
                player=    player = MediaPlayer.create(this,R.raw.car2);
                break;
            case "3":
                player=    player = MediaPlayer.create(this,R.raw.car3);
                break;
            case "4":
                player=    player = MediaPlayer.create(this,R.raw.car4);
                break;
            case "5":
                player=    player = MediaPlayer.create(this,R.raw.xiaoshipin);
                break;
        }
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        player.setDisplay(surfaceView.getHolder());
        player.start();
    }

    private void inview() {
        surfaceView = findViewById(R.id.suf);
    }
}
