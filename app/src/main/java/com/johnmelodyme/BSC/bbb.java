package com.johnmelodyme.BSC;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.TextView;
import android.widget.Toast;

public class bbb extends AppCompatActivity {

    public void onBackPressed(){
        super.onBackPressed();
    }

    TextView warning;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbb);

        warning = findViewById(R.id.warning);
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent toAuthenticaxion;
                toAuthenticaxion = new Intent(bbb.this, MainPage.class);
                startActivity(toAuthenticaxion);
            }
        },4000);

    }
}
