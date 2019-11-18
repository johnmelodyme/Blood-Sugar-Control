package com.johnmelodyme.bloodsugarcontrolv1;

import android.bluetooth.BluetoothDevice;

public class bledevice {
    private BluetoothDevice bluetooth_Device_藍牙設備;
    private int rssi;

    public bledevice(BluetoothDevice device){
        this.bluetooth_Device_藍牙設備 = device;
    }

    public String getAddress(){
        return bluetooth_Device_藍牙設備.getAddress();
    }

    public String getName(){
        return bluetooth_Device_藍牙設備.getName();
    }

    public void setRssi(int rssi){
        this.rssi = rssi;
    }

    public int getRssi(){
        return rssi;
    }
}
