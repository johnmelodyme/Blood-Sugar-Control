package com.johnmelodyme.BSC;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import org.greenrobot.eventbus.EventBus;
/**
* @COPYRIGHT: LiuZhiYuan 2019
 * @USED_WITH_PERMISSION : John Melody Melissa
 */

public class BlueToothBroadcastReceiver extends BroadcastReceiver {

    private IntentFilter filter;

    public IntentFilter getFilter(){
        filter = new IntentFilter();
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        // 开始查找
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        // 结束查找
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        // 查找设备
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        // 设备扫描模式改变
        filter.addAction(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
        // 绑定状态
        filter.addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        // 设备连接
        filter.addAction(BluetoothDevice.ACTION_ACL_CONNECTED);
        // 设备断开
        filter.addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED);
        // 变更
        filter.addAction(BluetoothDevice.ACTION_CLASS_CHANGED);
        return filter;
    }


    @Override
    public void onReceive(Context context, Intent intent) {
        EventBus.getDefault().post(new BLEevent(intent));
    }
}
