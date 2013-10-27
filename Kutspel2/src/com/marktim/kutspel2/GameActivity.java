package com.marktim.kutspel2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import com.marktim.kutspel2.control.GyroListener;
import com.marktim.kutspel2.opengl.GLGameRenderer;
import com.marktim.kutspel2.opengl.GLGameView;

public class GameActivity extends Activity {

	private GLGameView view;
	private GLGameRenderer renderer;
	private SensorManager sm;
	private GyroListener gyroListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new GLGameView(this);
		renderer = new GLGameRenderer();
		view.setRenderer(renderer);

		view.setKeepScreenOn(BuildConfig.DEBUG);
		setContentView(view);
		
		sm = (SensorManager) getSystemService(SENSOR_SERVICE);
		gyroListener = new GyroListener(this);
		
		HandlerThread ht = new HandlerThread("sensorThread");
		Handler sensorHandler = new Handler(ht.getLooper());
		sm.registerListener(gyroListener, sm.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD), 1000/60, sensorHandler);
	}

	public GLGameRenderer getRenderer() {
		return renderer;
	}

}
