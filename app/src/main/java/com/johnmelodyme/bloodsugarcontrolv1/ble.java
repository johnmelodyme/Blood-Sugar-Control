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
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class ble extends AppCompatActivity {
    private static final int REQUEST_ENABLE_BT = 1;

    BluetoothAdapter BT_藍牙適配器;
    BluetoothManager BT_藍牙管理器;
    ListView LV_列表顯示;

    private Set<BluetoothDevice> pairedDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ble);

        BT_藍牙適配器 = BluetoothAdapter.getDefaultAdapter();
        BT_藍牙管理器 = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);

        if (BT_藍牙適配器 == null){
            System.out.println("Bluetooth == $NULL");
            String bluetooth_is_not_supported;
            bluetooth_is_not_supported = "Bluetooth Not Supported";
            Toast.makeText(this,
                    bluetooth_is_not_supported,
                    Toast.LENGTH_SHORT)
                    .show();
            finish();
        }


        if (BT_藍牙適配器.isEnabled()){
            Intent ontheBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(ontheBluetooth, REQUEST_ENABLE_BT);
        }
    }


    public void on(View v){
        if (BT_藍牙適配器 == null || !BT_藍牙適配器.isEnabled()) {
            Intent enableBT;
            String turningOn;

            turningOn = "Bluetooth Enabled.";
            enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBT, REQUEST_ENABLE_BT);
            Toast.makeText(getApplicationContext(),
                    turningOn,
                    Toast.LENGTH_SHORT)
                    .show();
        } else {
            String turnedOn;
            turnedOn = "Bluetooth already turned on";
            Toast.makeText(getApplicationContext(),
                    turnedOn,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public void off(View v){
        String off;
        off = "Bluetooth Disabled";
        BT_藍牙適配器.disable();
        Toast.makeText(getApplicationContext(),
                off,
                Toast.LENGTH_SHORT)
                .show();
    }

    public void listview(View v){
        ArrayList list = new ArrayList();
        String showPaiedDevice;
        
        showPaiedDevice = "Showing Paired Bluetooth Device";
        pairedDevice = BT_藍牙適配器.getBondedDevices();
        for (BluetoothDevice 藍牙設備 : pairedDevice) list.add(藍牙設備.getName());
        Toast.makeText(this, showPaiedDevice,
                Toast.LENGTH_SHORT)
                .show();
         //final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.row, list);
         //LV_列表顯示.setAdapter(adapter);
    }
}