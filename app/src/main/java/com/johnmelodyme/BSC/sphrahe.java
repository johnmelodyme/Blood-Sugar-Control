package com.johnmelodyme.BSC;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 *このページは、読み込みに伴うスプラッシュです。
 * これは John Melody Melissa によってコーディングされています。
 * このライセンスは、商標、サービスマーク、
 * または貢献者のロゴ（準拠するために必要な場合を除く）
 * セクション3.4の通知要件）。
 **/

public class sphrahe extends AppCompatActivity {

    int 什麼鬼東西;
    Handler 可愛的;
    ProgressBar 圈圈;
    ImageView 照片;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        照片 = findViewById(R.id.thesplashimage);
       // 圈圈 =  findViewById(R.id.chocolatebar);
        什麼鬼東西 = 0;

        可愛的 = new Handler();
        可愛的.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent toAuthenticaxion;
                toAuthenticaxion = new Intent(sphrahe.this, LoginActivitea.class);
                startActivity(toAuthenticaxion);
                finish();
            }
        },5010);
    }
}