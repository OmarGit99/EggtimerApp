package com.example.freshnewstart;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.*;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    TextView textView;
    String str;
    CountDownTimer yourCountdownTimer;
    SeekBar seekBar;
    public void resetFunction(View view){
        if(yourCountdownTimer != null) {
            yourCountdownTimer.cancel();
        }
        seekBar.setProgress(30);
        yourCountdownTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisecondsUntilDone) {
                if ((millisecondsUntilDone / 1000) >= 10) {
                    textView.setText("0:" + String.valueOf(millisecondsUntilDone / 1000));


                } else {
                    textView.setText("0:0" + String.valueOf(millisecondsUntilDone / 1000));
                }




            }

            public void onFinish() {
                mPlayer.start();
                textView.setText("0:30");

            }
        }.start();



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPlayer = MediaPlayer.create(this, R.raw.airhorn);
        textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(30);
        seekBar.setProgress(30);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int lala;
                if(progress == 0){
                    lala = 1;

                }
                else{
                    lala = progress;
                    ;
                }
                if(yourCountdownTimer != null) {
                    yourCountdownTimer.cancel();
                }
                yourCountdownTimer = new CountDownTimer(lala * 1000, 1000) {
                    public void onTick(long millisecondsUntilDone) {
                        if ((millisecondsUntilDone / 1000) >= 10) {
                            textView.setText("0:" + String.valueOf(millisecondsUntilDone / 1000));

                        } else {
                            textView.setText("0:0" + String.valueOf(millisecondsUntilDone / 1000));
                        }


                    }

                    public void onFinish() {
                        mPlayer.start();
                        textView.setText("0:30");

                    }
                }.start();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        str = textView.getText().toString();

    }
}
