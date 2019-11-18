package com.johnmelodyme.bloodsugarcontrolv1;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Switch;
import android.widget.Toast;

import okhttp3.internal.Util;

public class reciver extends BroadcastReceiver {
    Context activitycontent;

    public reciver(Context activitycontent){
        this.activitycontent = activitycontent;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        if (action.equals(BluetoothAdapter.ACTION_STATE_CHANGED)) {
            final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR);
            switch (state) {
                case BluetoothAdapter.STATE_OFF:
                    String ble_off_BLE已關閉 = "Bluetooth is OFF";
                    wtf.toast(activitycontent, ble_off_BLE已關閉);
                    break;
                case BluetoothAdapter.STATE_TURNING_OFF:
                    String otw_offing_藍牙正在關閉 = "Bluetooth is turing OFF";
                    wtf.toast(activitycontent, otw_offing_藍牙正在關閉);
                    break;
                case BluetoothAdapter.STATE_ON:
                    String ble_on_藍牙開啟 = "Bluetooth is ON";
                    wtf.toast(activitycontent, ble_on_藍牙開啟);
                    break;
                case BluetoothAdapter.STATE_TURNING_ON:
                    String otw_oning = "Bluetooth is turning ON";
                    wtf.toast(activitycontent, otw_oning);
                    break;
            }
        }
    }

}