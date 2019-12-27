package com.johnmelodyme.BSC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class message extends AppCompatActivity {

    public void onBackPressed(){
        super.onBackPressed();
        Intent toBLO;
        toBLO = new Intent(message.this, MainPage.class);
        startActivity(toBLO);
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
                toAuthenticaxion = new Intent(message.this, MainPage.class);
                startActivity(toAuthenticaxion);
            }
        },5000);
    }
}
