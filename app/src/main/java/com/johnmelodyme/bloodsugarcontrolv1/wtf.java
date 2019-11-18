package com.johnmelodyme.bloodsugarcontrolv1;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

public class wtf {
    public static boolean dentalCheckBluetooth(BluetoothAdapter bluetoothAdapter_藍牙適配器) {
        /*
        * Ensures that Bluetooth is available on the device it is enable , else
        * disp. a dialogue requesting user-permission to enable it::
         */
        if(bluetoothAdapter_藍牙適配器 == null || !bluetoothAdapter_藍牙適配器.isEnabled()){
            return false;
        } else {
            return true;
        }
    }

    public static void requestUserBluetooth(Activity activity_活動){
        Intent onBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity_活動.startActivity(onBT);
    }

    public static void toast(Context context, String string){
        Toast toast = Toast.makeText(context, string, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.BOTTOM, 0, 0);
        toast.show();
    }
}
