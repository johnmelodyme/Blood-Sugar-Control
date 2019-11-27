package com.johnmelodyme.BSC;

import android.content.Intent;

public class BLEevent {
    private Intent BLE_INTENT;

    public BLEevent(Intent intent){
        this.BLE_INTENT = intent;
    }

    public Intent getBLE_INTENT(){
        return BLE_INTENT;
    }
}
