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
                /*
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (什麼鬼東西 < 100){
                            什麼鬼東西+=1;
                            android.os.SystemClock.sleep(50);
                            可愛的.post(new Runnable() {
                                @Override
                                public void run() {
                                    圈圈.setProgress(什麼鬼東西);
                                }
                            });
                        }
                        可愛的.post(new Runnable() {
                            @Override
                            public void run() {
                                圈圈.setProgress(什麼鬼東西);
                            }
                        });

                        try {
                             // 睡眠2000毫秒 ::
                            Thread.sleep(2000);
                        } catch (InterruptedException e ){
                            e.printStackTrace();
                        }
                    }
                });

                 */


                Intent toAuthenticaxion;
                toAuthenticaxion = new Intent(sphrahe.this, LoginActivitea.class);
                startActivity(toAuthenticaxion);
                finish();
            }
        },5010);
    }
}