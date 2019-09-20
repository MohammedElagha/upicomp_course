package com.example.mohammed_elagha.linearaccelerationsensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager senseManager;
    Sensor linearAcceleration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        senseManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);
        linearAcceleration = senseManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        senseManager.registerListener(this,linearAcceleration,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
         /*
        * you can see the log message printed to the android monitor
        * */
        Log.v("MainActivity","Value of X: "+event.values[0]);
        Log.v("MainActivity","Value of Y: "+event.values[1]);
        Log.v("MainActivity","Value of Z: "+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
