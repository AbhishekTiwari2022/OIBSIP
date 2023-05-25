package com.abhimaster.stopwatchapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView txtview;
    int seconds=0;
    boolean isRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));

        txtview = findViewById(R.id.txtview_timecount);
        startTimer();
    }

    public void startEvent(View view){
        isRunning=true;

    }
    public void stopEvent(View view){
        isRunning=false;
    }
    public void resetEvent(View view){
        isRunning=false;
        seconds=0;
    }

    public void startTimer(){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sec = seconds%60;
                int min = seconds/60;
                int hr = min/60;
                if(isRunning) {
                    seconds++;
                }
                String formateString = String.format(Locale.getDefault(),"%02d:%02d:%02d",hr,min,sec);
                txtview.setText(formateString);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }
}