package com.marktim.kutspel2.control;

import java.util.Observable;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.marktim.kutspel2.GameActivity;

public class GyroListener extends Observable implements SensorEventListener {

	public GyroListener(GameActivity context) {
		addObserver(context.getRenderer());
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO handle data and notify observers
	}

}
