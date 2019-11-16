package com.johnmelodyme.bloodsugarcontrolv1;

/*
 *このページは、読み込みに伴うスプラッシュです。
 * これは John Melody Melissa によってコーディングされています。
 * このライセンスは、商標、サービスマーク、
 * または貢献者のロゴ（準拠するために必要な場合を除く）
 * セクション3.4の通知要件）。
 **/

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainPage extends AppCompatActivity {
    BluetoothAdapter BT_藍牙適配器;
    BluetoothManager BT_藍牙管理器;

    Button rewind_轉回;
    Button forward_向前;
    Button stop_停;
    Button play_播放;
    Button wechat_微信;
    Button web_網站;
    Button Facebook_面子書;
    //SeekBar seekBar_seekingtheBar_芭比;
    Button profile_我;
    Button topup_充值;
    Button news_消息;
    Button setting_Activity_設置;
    ImageView BLE_藍蕉牙;
    TextView BT_藍牙;
    Handler 可愛;
    MediaPlayer 千山萬水总是情永遠愛我行不行;

    int 時光倒流;
    int 時间前进;

    {
        時光倒流 = 5000;
        時间前进 = 5000;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        可愛 = new Handler();
        rewind_轉回 = findViewById(R.id.轉回);
        forward_向前 = findViewById(R.id.向前);
        stop_停 = findViewById(R.id.停);
        play_播放 = findViewById(R.id.播放);
        wechat_微信 = findViewById(R.id.微信);
        web_網站 = findViewById(R.id.網站);
        Facebook_面子書 = findViewById(R.id.面子書);
        profile_我 = findViewById(R.id.我);
        topup_充值 = findViewById(R.id.充值);
        news_消息 = findViewById(R.id.消息);
        BLE_藍蕉牙 = findViewById(R.id.bluetooth);
        BT_藍牙 = findViewById(R.id.UpdateConnectedBLEDEVICE);
        BT_藍牙適配器 = BluetoothAdapter.getDefaultAdapter();
        BT_藍牙管理器 = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        setting_Activity_設置 = findViewById(R.id.設置);

        //seekBar_seekingtheBar_芭比 = findViewById(R.id.芭比);

        // 媒体播放器 ::
        千山萬水总是情永遠愛我行不行 = MediaPlayer.create(this, R.raw.somethingsomething);
        千山萬水总是情永遠愛我行不行.setAudioStreamType(AudioManager.STREAM_MUSIC);
        play_播放.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (千山萬水总是情永遠愛我行不行.isPlaying()){
                    String Pause_啦啦啦啦;
                    Pause_啦啦啦啦 = getResources()
                            .getString
                                    (R.string.pauseeee);
                    千山萬水总是情永遠愛我行不行.pause();
                    play_播放.setBackgroundResource(R.mipmap.blek);
                    Toast.makeText(MainPage.this,
                            Pause_啦啦啦啦
                            ,Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    String Play_啦啦啦啦;
                    Play_啦啦啦啦 = getResources()
                            .getString(R.string.playlalalalalala);
                    千山萬水总是情永遠愛我行不行.start();
                    play_播放.setBackgroundResource(R.mipmap.sheeet);
                    Toast.makeText(MainPage.this,
                            Play_啦啦啦啦
                            , Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });

        rewind_轉回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                msg = getResources().getString(R.string.backward);
                int 什麼的時間;
                什麼的時間 = 千山萬水总是情永遠愛我行不行.getCurrentPosition();
                Toast.makeText(MainPage.this, msg
                        ,Toast.LENGTH_SHORT)
                        .show();
                if(什麼的時間 + 時光倒流 >= 0){
                    千山萬水总是情永遠愛我行不行.seekTo(什麼的時間  - 時光倒流 );
                }
            }
        });

        forward_向前.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String 信息;
                int 世界末日;
                信息 = getResources().getString(R.string.forward);
                世界末日 = 千山萬水总是情永遠愛我行不行.getCurrentPosition();
                Toast.makeText(MainPage.this, 信息
                        ,Toast.LENGTH_SHORT)
                        .show();
                if(世界末日 + 時间前进 <= 千山萬水总是情永遠愛我行不行.getDuration()){
                    千山萬水总是情永遠愛我行不行.seekTo(世界末日 + 時间前进);
                } else {
                    千山萬水总是情永遠愛我行不行
                            .seekTo(千山萬水总是情永遠愛我行不行
                                    .getDuration());
                    System.out.println("音樂正在播放");
                }
            }
        });
        
        stop_停.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String 停止;
                停止 = getResources().getString(R.string.stop);
                Toast.makeText(MainPage.this, 停止
                        ,Toast.LENGTH_SHORT)
                        .show();
                千山萬水总是情永遠愛我行不行.pause();
                play_播放.setBackgroundResource(R.mipmap.blek);
                System.out.println("人間自有真情在, 教導我如何的愛, 也是愛。");
            }
        });

        ////////////////////////////////////////////////////////////////////////
        BLE_藍蕉牙.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ble;
                ble = new Intent(MainPage.this, com.johnmelodyme.bloodsugarcontrolv1.ble.class);
                startActivity(ble);
            }
        });

        /*
        boolean processing = true;
        int number_processed = 0;
        String BT_NAME_藍牙名 = BT_藍牙適配器.getName();
        do {
            ++number_processed;
            BT_藍牙.setText(BT_NAME_藍牙名);
        } while (processing);
        ///////////////////////////////////////////////////////////////////////


         */
        Facebook_面子書.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebook();
            }
        });

        web_網站.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starlab();
            }
        });

        wechat_微信.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                Toast.makeText(MainPage.this,
                        R.string.comingsoon,
                        Toast.LENGTH_SHORT)
                        .show();
                 */
                Intent whatsapp;
                whatsapp = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(
                                "https://wa.me/6013-9319018?text=[This%20is%20automated%20Message].%20I%20Would%20like%20to%20know%20more.%20")
                );
                startActivity
                        (whatsapp
                        );
            }
        });
        ///////////////////////////////////////////////////////////////////////////////
        /*
        seekBar_seekingtheBar_芭比.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(千山萬水总是情永遠愛我行不行 != null && fromUser){
                    千山萬水总是情永遠愛我行不行.seekTo(progress * 1000);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                /////////////////////////////////////////////
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                ////////////////////////////////////////////
            }
        });
         */
        profile_我.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comingSoon();
            }
        });

        topup_充值.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comingSoon();
            }
        });

        news_消息.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comingSoon();
            }
        });

        setting_Activity_設置.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSettingActivity();
            }
        });

    }

    ////////////////////////////////////////////////////////////
    private void toSettingActivity() {
        Intent 設置;
        設置 = new Intent(MainPage.this, sadthing.class);
        startActivity(設置);
    }

    private void starlab() {
        Intent 網站;
        網站 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.starlabs.com.my/"));
        startActivity(網站);
    }

    private void facebook() {
        Intent 面子書;
        面子書 = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://web.facebook.com/StarLabsBioscience?_rdc=1&_rdr"));
        startActivity(面子書);
    }

    ////////// temp ////////
    private void comingSoon() {
        Toast.makeText(MainPage.this,
                "Coming Soon"
                ,Toast.LENGTH_SHORT)
                .show();
    }

    // 兩次按下以退出應用程序 ::
    boolean doubleBackToExitPressedOne = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOne) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOne = true;
        Toast.makeText(this, R.string.回回,
                Toast.LENGTH_SHORT)
                .show();
        stopmusic();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOne = false;
            }
        }, 2000);
    }

    private void stopmusic() {
        String 停止;
        停止 = getResources().getString(R.string.stop);
        Toast.makeText(MainPage.this, 停止
                ,Toast.LENGTH_SHORT)
                .show();
        千山萬水总是情永遠愛我行不行.pause();
        play_播放.setBackgroundResource(R.mipmap.blek);
        System.out.println("人間自有真情在, 教導我如何的愛, 也是愛。");
    }
}