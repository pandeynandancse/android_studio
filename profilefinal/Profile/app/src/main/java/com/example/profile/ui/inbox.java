package com.example.profile.ui;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProviders;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;

import com.example.profile.R;
import com.example.profile.ui.gallery.GalleryViewModel;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class inbox extends Fragment {

    private InboxViewModel inboxViewModel;

    public static inbox newInstance() {
        return new inbox();
    }


    MediaPlayer musicPlayer ;


    AudioManager audioManager;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        inboxViewModel =
                ViewModelProviders.of(this).get(InboxViewModel.class);

        View root = inflater.inflate(R.layout.inbox_fragment, container, false);
        musicPlayer = MediaPlayer.create(getActivity(), R.raw.music);
        Button b = (Button) root.findViewById(R.id.play);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                musicPlayer.start();
            }
        });

        Button b2 = (Button) root.findViewById(R.id.pause);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                musicPlayer.pause();
            }
        });

        Button b3 = (Button) root.findViewById(R.id.stop);
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                musicPlayer.stop();
            }
        });


        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);
        int maxVol = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVol = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        SeekBar seekVol = (SeekBar) root.findViewById(R.id.seekBar);
        seekVol.setMax(maxVol);
        seekVol.setProgress(curVol);

        // it will be auto generated after typing some words
        seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC , progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        // for progress bar
        final SeekBar seekProg = (SeekBar) root.findViewById(R.id.seekBar2);
        seekProg.setMax(musicPlayer.getDuration());

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                // runs progress bar seekProg with zero delay and and does progress at each 900 milliseconds
                seekProg.setProgress(musicPlayer.getCurrentPosition());
            }
        }, 0, 1000);

        seekProg.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // go to place where user touched progress bar but only when it is from user , not from progressing
                if(fromUser) {
                    musicPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





        return root;
    }







}
