package com.example.yoris.pokerun;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PokeRun extends AppCompatActivity implements SensorEventListener{
    private SensorManager sensori;
    private Sensor giroscopio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_run);
        SensorManager manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Sensor giroscopio=sensori.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        event.
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
