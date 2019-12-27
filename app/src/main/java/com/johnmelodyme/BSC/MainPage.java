package com.johnmelodyme.BSC;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * @CREATOR: JOHN MELODY MELISSA ESKHOLAZHT .C.T.K.
 * @DATETIME: 11/11/2019
 * @COPYRIGHT: 2019 - 2023
 * @PROJECTNAME: BLOOD SUGAR CONTROL
 * @COMMENT: "I  LEARNT ANDROID PROGRAMMING IN 3 WEEKS AGO"
 */

public class MainPage extends AppCompatActivity {

    private void checkBLUETOOTH(){
        if(BT_ADA == null){
            String bna = "Bluetooth is not available";
            Toast.makeText(MainPage.this,
                    bna,
                    Toast.LENGTH_LONG)
                    .show();
            finish();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onStart(){
        super.onStart();
        AudioManager manager;
        manager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if (manager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                manager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE,0);
                manager.setMode(AudioManager.RINGER_MODE_SILENT);
                manager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            }
        }
    }

    public void onDestroy(){
        super.onDestroy();
        FirebaseAuth.getInstance()
                .signOut();
        finish();
    }

    private void AUDIO_OFF(){
        AudioManager manager;
        manager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if (manager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                manager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE,0);
                manager.setMode(AudioManager.RINGER_MODE_SILENT);
                manager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_REMOVE_SOUND_AND_VIBRATE);
            }
        }
    }

    private void AUDIO_ON(){
        AudioManager manager;
        manager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        if (manager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //manager.adjustStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_TOGGLE_MUTE,0);
                manager.setMode(AudioManager.RINGER_MODE_NORMAL);
                manager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.ADJUST_RAISE);
            }
        }
    }

    BluetoothAdapter BT_ADA;
    BluetoothManager BT_MAN;
    blecontroller control;
    BLEDeviceAdapter adapta;
    BluetoothSocket BLE_socket;
    BluetoothDevice device;
    Button profile, Facebook, web, whatsapp, play, stop;
    Button on_off_ble, rewind,forward, setting_Activity, news, topup;
    ImageView BLE_banana;
    TextView BT;
    Handler cute;
    MediaPlayer FCH;
    TextView connected_d;
    int REQUEST_CONNECT_DEVICE;
    int timetravel_back;
    int timetravel_forward;
    {
        REQUEST_CONNECT_DEVICE = 1;
        timetravel_back = 5000;
        timetravel_forward = 5000;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cute = new Handler();
        rewind = findViewById(R.id.轉回);
        forward = findViewById(R.id.向前);
        stop = findViewById(R.id.停);
        play = findViewById(R.id.播放);
        whatsapp = findViewById(R.id.微信);
        web = findViewById(R.id.網站);
        Facebook = findViewById(R.id.面子書);
        profile = findViewById(R.id.我);
        topup = findViewById(R.id.充值);
        news = findViewById(R.id.消息);
        BT_ADA = BluetoothAdapter.getDefaultAdapter();
        BT_MAN = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        setting_Activity = findViewById(R.id.設置);
        connected_d = findViewById(R.id.connected);
        on_off_ble = findViewById(R.id.ble_switch);




        FirebaseUser user = FirebaseAuth.getInstance()
                .getCurrentUser();
        if (user != null) {
            FirebaseAuth.getInstance()
                    .signOut();
        } else {
            checkBLUETOOTH();
            while (true) {
                System.out.println("proceed");
            }
        }

        if(!BT_ADA.isEnabled()){
            connectNSTBSC();
            connectNSTBSC();
            connectNSTBSC();
            connectNSTBSC();
            android.content.Intent enableIntent = new android.content.Intent(
                    android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, 0);
            gotobluetoothsetting();
        } else {
            gotobluetoothsetting();
            connectNSTBSC();
            connectNSTBSC();
            connectNSTBSC();
            connectNSTBSC();
        }



        /*
        Intent connectDevice;
        connectDevice = new Intent(MainPage.this, MainPage.class);
        startActivityForResult(connectDevice, REQUEST_CONNECT_DEVICE);
         */
        // "IF BLUETOOTH NOT SUPPORTED ::


        SHOW_BLE();

        /*
        AudioManager mode = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        if }(mode != null) {
            mode.setRingerMode(RINGER_MODE_SILENT);
        }
         */


        FCH = MediaPlayer.create(MainPage.this,
                R.raw.somethingsomething);
        FCH.setAudioStreamType(AudioManager.STREAM_MUSIC);
        FCH.setVolume(0,0);
        FCH.setLooping(true);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String connectedDevice = connected_d
                        .getText()
                        .toString();
                   if (FCH.isPlaying()){
                       String Pause;
                       Pause = getResources()
                               .getString
                                       (R.string.pauseeee);
                       AUDIO_OFF();
                       FCH.pause();
                       play.setBackgroundResource(R.mipmap.blek);
                       Toast.makeText(MainPage.this,
                               Pause
                               ,Toast.LENGTH_SHORT)
                               .show();
                   } else {
                       String Play;
                       Play = getResources()
                               .getString(R.string.playlalalalalala);
                       AUDIO_ON();
                       FCH.setVolume(80,80);
                       FCH.start();
                       play.setBackgroundResource(R.mipmap.sheeet);
                       Toast.makeText(MainPage.this,
                               Play
                               , Toast.LENGTH_SHORT)
                               .show();

                   }
            }
        });
        rewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg;
                msg = getResources().getString(R.string.backward);
                int time;
                time = FCH.getCurrentPosition();
                Toast.makeText(MainPage.this, msg
                        ,Toast.LENGTH_SHORT)
                        .show();
                if(time + timetravel_back >= 0){
                    FCH.seekTo(time  - timetravel_back );
                }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ms;
                int harikiamat;
                ms = getResources().getString(R.string.forward);
                harikiamat = FCH.getCurrentPosition();
                Toast.makeText(MainPage.this, ms
                        ,Toast.LENGTH_SHORT)
                        .show();
                if(harikiamat + timetravel_forward <= FCH.getDuration()){
                    FCH.seekTo(harikiamat + timetravel_forward);
                } else {
                    FCH
                            .seekTo(FCH
                                    .getDuration());
                    System.out.println("MUSIC IS PLAYING");
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s;
                s = getResources().getString(R.string.stop);
                Toast.makeText(MainPage.this, s
                        ,Toast.LENGTH_SHORT)
                        .show();
                FCH.pause();
                play.setBackgroundResource(R.mipmap.blek);
                BT_ADA.disable();
                Intent gotoSPLASH;
                gotoSPLASH = new Intent(MainPage.this, message.class);
                startActivity(gotoSPLASH);
                FirebaseAuth.getInstance()
                        .signOut();
                SystemClock.sleep(3000);
                System.exit(0);
            }
        });
        ////////////////////////////////////////////////////////////////////////

        Facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebook();
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starlab();
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
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

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comingSoon();
            }
        });
        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comingSoon();
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comingSoon();
            }
        });
        setting_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSettingActivity();
            }
        });
    }


    private void SHOW_BLE() {
        //https://stackoverflow.com/questions/36525477/display-ble-data-in-textview
        String msg;
        msg = "NST_BSC";
        connected_d.setText(msg);
    }

    private void toSettingActivity() {
        Intent set;
        set = new Intent(MainPage.this, sadthing.class);
        startActivity(set);
    }
    private void starlab() {
        Intent web;
        web = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.starlabs.com.my/"));
        startActivity(web);
    }
    private void facebook() {
        Intent fb;
        fb = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://web.facebook.com/StarLabsBioscience?_rdc=1&_rdr"));
        startActivity(fb);
    }
    ////////// temp ////////
    private void comingSoon() {
        Toast.makeText(MainPage.this,
                "Coming Soon"
                ,Toast.LENGTH_SHORT)
                .show();
    }


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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOne = false;
            }
        }, 2000);
        FirebaseAuth.getInstance()
                .signOut();
        System.exit(0);
    }

    /*
    public void switcher(View v){
        switch (v.getId()){
            case R.id.ble_switch:
                boolean isSwitch = control.getSwitchBlueTooth();
                if(!(isSwitch)){
                    control.tureOnBlueTooth(this);
                } else {
                    control.tureOffBlueTooth();
                    adapta.notifyDataSetChanged();
                }
                break;
            case R.id.connected:
                control.isVisibility(this);
                break;
            case R.id.
        }
    }
     */

    public void ble_on_of(View view){
        boolean isSwitch = control.getSwitchBlueTooth();
        if(!isSwitch){
            control.tureOnBlueTooth(this);
            System.out.println("Bluetooth On");
        } else {
            control.tureOffBlueTooth();
            set_ble_background(false);
            adapta.notifyDataSetChanged();
        }
    }

    private void set_ble_background(boolean maybe){
        if(maybe){
            on_off_ble.setBackgroundResource(R.mipmap.bluoootoof);
        } else {
            on_off_ble.setBackgroundResource(R.mipmap.bloooootooth);
        }
    }

    public void cc(View v){
        if(connected_d.getText().toString().equals("NST-BSC")){
            connected_d.setText("NST-BSC");
        } else {
            connected_d.setText("7550T");
        }
    }

    public void connectNSTBSC(){
        Toast.makeText(this, "Please Connect to \" NST-BSC \".",
                Toast.LENGTH_LONG)
                .show();
    }

    public void Bluetooth(View v){
        if (!BT_ADA.isEnabled()){
            BT_ADA.startDiscovery();
            on_off_ble.setBackgroundResource(R.mipmap.bluoootoof);
            BT_ADA.enable();
            gotobluetoothsetting();
        } else {
            on_off_ble.setBackgroundResource(R.mipmap.bloooootooth);
            BT_ADA.disable();
            FCH.pause();
            warning();
        }
    }

    private void warning() {
        Toast.makeText(this,
                "Please Connect to the Headset.",
                Toast.LENGTH_SHORT)
                .show();
    }

    private void gotobluetoothsetting() {
        Intent intentOpenBluetoothSettings = new Intent();
        intentOpenBluetoothSettings.setAction(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(intentOpenBluetoothSettings);
        for(int i = 1; i < 10;  i++){
            connectNSTBSC();
        }
    }


}
