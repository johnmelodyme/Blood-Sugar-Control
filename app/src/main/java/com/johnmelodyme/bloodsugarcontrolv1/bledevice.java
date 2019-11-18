package com.johnmelodyme.bloodsugarcontrolv1;

import android.bluetooth.BluetoothDevice;

public class bledevice {
    private BluetoothDevice bluetooth_Device_藍牙設備;
    private int rssi;

    public bledevice(BluetoothDevice device){
        this.bluetooth_Device_藍牙設備 = device;
    }
}
