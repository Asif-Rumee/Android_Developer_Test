package com.arrumee.videoplayerandroidtest;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


public class VideoPlayerActivity extends AppCompatActivity {

    private Button buttonPlay;
    private Button buttonForward;
    private Button buttonRewind;
    private static final String inputVideo = "flower";
    private VideoView playerVideoView;
    private int currentPosition = 0;
    private static final String playbackMoment = "playMoment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        playerVideoView = (VideoView) findViewById(R.id.videoview);
        buttonPlay = (Button) findViewById(R.id.buttonPlay);
        buttonForward = (Button) findViewById(R.id.buttonForward);
        buttonRewind = (Button) findViewById(R.id.buttonRewind);

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(playbackMoment);
        }

        MediaController mController = new MediaController(this);
        mController.setMediaPlayer(playerVideoView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            playerVideoView.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(playbackMoment, playerVideoView.getCurrentPosition());
    }

    public void playVideo(View view){
        playerVideoView.start();
    }

    public void forwardVideo(View view){
        int presentTime = playerVideoView.getCurrentPosition();
        int totalTime = playerVideoView.getDuration();
        int forwardTime = 5000;

        if(presentTime + forwardTime < totalTime){
            playerVideoView.seekTo(presentTime + forwardTime);
        }
    }

    public void rewindVideo(View view){
        int presentTime = playerVideoView.getCurrentPosition();
        int rewindTime = 5000;

        if(presentTime - rewindTime > 0){
            playerVideoView.seekTo(presentTime - rewindTime);
        }
    }

    private void initializePlayer() {
        Uri videoUri = getMedia(inputVideo);
        playerVideoView.setVideoURI(videoUri);

        playerVideoView.setOnPreparedListener(
                new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        
                        if (currentPosition > 0) {
                            playerVideoView.seekTo(currentPosition);
                        } else {
                            playerVideoView.seekTo(1);
                        }
                    }
                });

        playerVideoView.setOnCompletionListener(
                new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        Toast.makeText(VideoPlayerActivity.this,
                                "Playback completed.",
                                Toast.LENGTH_SHORT).show();

                        playerVideoView.seekTo(0);
                    }
                });
    }

    private void releasePlayer() {
        playerVideoView.stopPlayback();
    }

    private Uri getMedia(String mediaName) {
        return Uri.parse("android.resource://" + getPackageName() + "/raw/" + mediaName );
    }
}
