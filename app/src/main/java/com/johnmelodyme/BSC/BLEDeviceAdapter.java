package com.johnmelodyme.BSC;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class BLEDeviceAdapter extends BaseAdapter {
    private List<BluetoothDevice> bluetoothDevices;
    private LayoutInflater layoutInflater;

    public BLEDeviceAdapter(Context context, List<BluetoothDevice> bluetoothDevices){
        this.bluetoothDevices = bluetoothDevices;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount(){
        return bluetoothDevices.size();
    }

    @Override
    public  Object getItem(int i){
        return bluetoothDevices.get(i);
    }

    @Override
    public long getItemId(int i){
        return i;
    }

    @Override
    public View getView(int i, View itemView, ViewGroup viewGroup){
        if(itemView == null){
            //////////////////////////////
        }
        return itemView;
    }
}
