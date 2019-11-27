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

	public boolean isSupportBlueTooth() {
		if (bluetoothAdapter != null) {
			return true;
		} else {
			return false;
		}
	}

	// switch
	public boolean getSwitchBlueTooth() {
		assert(bluetoothAdapter != null);
		return bluetoothAdapter.isEnabled();
	}

	// enable
	public void tureOnBlueTooth(Activity activity) {
		Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
		activity.startActivity(intent);
	}

	// Disable BLuetooth
	public void tureOffBlueTooth() {
		bluetoothAdapter.disable();
	}

	// Bluetooth visibility
	public void isVisibility(Context context) {
		Intent dIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
		dIntent.putExtra(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE, 300);
		context.startActivity(dIntent);
	}

	// Find a device
	public void findDevice() {
		assert(bluetoothAdapter != null);
		bluetoothAdapter.startDiscovery();
	}

	// Get a binding device
	public List<BluetoothDevice> getBlueToothDeviceList() {
		return new ArrayList<>(bluetoothAdapter.getBondedDevices());
	}

	// Unpairing with device
	public boolean removeBond(Class btClass, BluetoothDevice btDevice) throws Exception {
		Method removeBondMethod = btClass.getMethod("removeBond");
		Boolean returnValue = (Boolean) removeBondMethod.invoke(btDevice);
		return returnValue.booleanValue();
	}

	// Device Pairing
	public boolean createBond(Class btClass, BluetoothDevice btDevice) throws Exception {
		Method createBondMethod = btClass.getMethod("createBond");
		Boolean returnValue = (Boolean) createBondMethod.invoke(btDevice);
		return returnValue.booleanValue();
	}

	// Get connected device information
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
