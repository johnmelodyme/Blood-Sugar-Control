package com.johnmelodyme.BSC;


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
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainPage extends AppCompatActivity {
    
    BluetoothAdapter BT_ADA;
    BluetoothManager BT_MAN;
    blecontroller control;
    BLEDeviceAdapter adapta;
    BluetoothSocket BLE_socket;
    BluetoothDevice device;

    Button rewind;
    Button forward;
    Button stop;
    Button play;
    Button wechat;
    Button web;
    Button Facebook;
    //SeekBar seekBar_seekingtheBar_芭比;
    Button profile;
    Button topup;
    Button news;
    Button setting_Activity;
    Button on_off_ble;
    ImageView BLE_banana;
    TextView BT;
    Handler cute;
    MediaPlayer FCH;
    TextView connected_d;

    int timetravel_back;
    int timetravel_forward;

    {
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
        wechat = findViewById(R.id.微信);
        web = findViewById(R.id.網站);
        Facebook = findViewById(R.id.面子書);
        profile = findViewById(R.id.我);
        topup = findViewById(R.id.充值);
        news = findViewById(R.id.消息);
        //BLE_banana = findViewById(R.id.bluetooth);
        BT_ADA = BluetoothAdapter.getDefaultAdapter();
        BT_MAN = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        setting_Activity = findViewById(R.id.設置);
        connected_d = findViewById(R.id.connected);

        // ""
        if(!(BT_ADA.isEnabled())){
            for (int i=0; i < 2; i++) {
                Toast.makeText(this, "Please Connect to \" NST-BSC \".",
                        Toast.LENGTH_LONG)
                        .show();
            }
            android.content.Intent enableIntent = new android.content.Intent(
                    android.bluetooth.BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, 0);
        }


        // "IF BLUETOOTH NOT SUPPORTED ::
        if(BT_ADA == null){
            String bna = "Bluetooth is not available";
            Toast.makeText(MainPage.this,
                    bna,
                    Toast.LENGTH_LONG)
                    .show();
            finish();
            return;
        }

        // BLUETOOTH SCANNER ::
        if(BT_ADA.getScanMode() !=
        BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE){
            android.content.Intent discoverable = new android.content.Intent(
                    BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE
            );
            /*
            discoverable.putExtra(
                    BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,
                    3000
            );
            */
            startActivity(discoverable);
        }
        /*
        final String the_device_I_want_to_connect;
        the_device_I_want_to_connect = "NST-BSC";
        String devName;
        devName = device.getName();
        if(device.equals("NST-BST")){
            BT_ADA.enable();
        }
         */

        Set <BluetoothDevice> pairedDevices = BT_ADA.getBondedDevices();
        if(pairedDevices.size() > 0){
            for (BluetoothDevice device : pairedDevices){
                String deviceName = device.getName();
            }
            if (device.getName().equals("NST-BSC")){
                BT_ADA.enable();
            }
            else {
                String nst = "Please Use NST-BSC Headset!";
                System.out.println(nst);
                Toast.makeText(this, nst,
                        Toast.LENGTH_LONG)
                        .show();
            }
        }

        FCH = MediaPlayer.create(this, R.raw.somethingsomething);
        FCH.setAudioStreamType(AudioManager.STREAM_MUSIC);
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
                System.out.println("YOU CAN MOCK ME BUT THAT DON'T MAKE YOU BETTER THAN ME");
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
        wechat.setOnClickListener(new View.OnClickListener() {
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

    /* TEKAN DUA KALI UNTUK PULANG KE MAIN: */
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
}
