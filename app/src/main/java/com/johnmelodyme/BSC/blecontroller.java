package com.johnmelodyme.BSC;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class blecontroller {

	private BluetoothAdapter bluetoothAdapter = null;

	public blecontroller() {
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	}

	public BluetoothAdapter getAdapter() {
		return bluetoothAdapter;
	}

	// 是否支持蓝牙
	public boolean isSupportBlueTooth() {
		if (bluetoothAdapter != null) {
			return true;
		} else {
			return false;
		}
	}

	// 蓝牙是否打开
	public boolean getSwitchBlueTooth() {
		assert(bluetoothAdapter != null);
		return bluetoothAdapter.isEnabled();
	}

	// 打开蓝牙
	public void tureOnBlueTooth(Activity activity) {
		Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		activity.startActivity(intent);
	}

	// 关闭蓝牙
	public void tureOffBlueTooth() {
		bluetoothAdapter.disable();
	}

	// 蓝牙可见
	public void isVisibility(Context context) {
		Intent dIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		dIntent.putExtra(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE, 300);
		context.startActivity(dIntent);
	}

	// 查找设备
	public void findDevice() {
		assert(bluetoothAdapter != null);
		bluetoothAdapter.startDiscovery();
	}

	// 获取绑定设备
	public List<BluetoothDevice> getBlueToothDeviceList() {
		return new ArrayList<>(bluetoothAdapter.getBondedDevices());
	}

	// 与设备解除配对
	public boolean removeBond(Class btClass, BluetoothDevice btDevice) throws Exception {
		Method removeBondMethod = btClass.getMethod("removeBond");
		Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice);
		return returnValue.booleanValue();
	}

	// 与设备配对
	public boolean createBond(Class btClass, BluetoothDevice btDevice) throws Exception {
		Method createBondMethod = btClass.getMethod("createBond");
		Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice);
		return returnValue.booleanValue();
	}

	//获取已连接设备信息
	public List<String> getConnectDevice() {
		List<String> allDeviceName= new ArrayList<>();
		Class<BluetoothAdapter> bluetoothAdapterClass = BluetoothAdapter.class;
		try {
			Method method = bluetoothAdapterClass.getDeclaredMethod("getConnectionState", (Class[]) null);
			method.setAccessible(true);
			int state = (int) method.invoke(bluetoothAdapter, (Object[]) null);
			if (state == BluetoothAdapter.STATE_CONNECTED) {
				Set<BluetoothDevice> devices = bluetoothAdapter.getBondedDevices();
				for (BluetoothDevice device : devices) {
					Method isConnectedMethod = BluetoothDevice.class.getDeclaredMethod("isConnected", (Class[]) null);
					method.setAccessible(true);
					boolean isConnected = (boolean) isConnectedMethod.invoke(device, (Object[]) null);
					if (isConnected) {
						allDeviceName.add(device.getName());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allDeviceName;

	}
}
