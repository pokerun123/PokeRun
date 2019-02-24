package com.example.yoris.pokerun;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.util.Log;

public class PokeRun extends AppCompatActivity implements SensorEventListener{
    private ImageView charmender;
    private SensorManager sensori;
    private Sensor sensore;
    private int width,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_run);
        sensori = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensore=sensori.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensori.registerListener(this,sensore,SensorManager.SENSOR_DELAY_NORMAL);
        charmender=findViewById(R.id.charmender);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        //PokemonNemico p = new PokemonNemico();
        //new Thread(new PokemonNemico()).start();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER && event.values[0] < 0) {
            Log.d("C","Destra "+event.values[0]);
            if(charmender.getX()+charmender.getWidth()+(5*(-event.values[0]))<width) {
                charmender.setX(charmender.getX() + (5*(-event.values[0])));
            }else{
                for(int i=4;i>=0;i--){
                    if(charmender.getX()+charmender.getWidth()+(i*(-event.values[0]))<width) {
                        charmender.setX(charmender.getX() + (i * (-event.values[0])));
                    }
                }
            }
        }
        else {
            Log.d("C","Sinistra "+event.values[0]);
            if(charmender.getX()>(5*event.values[0])) {
                charmender.setX(charmender.getX() - (5*event.values[0]));
            }else{
                for(int i=4;i>=0;i--){
                    if(charmender.getX()>(i*event.values[0])) {
                        charmender.setX(charmender.getX() - (i * event.values[0]));
                    }
                }
            }
        }

        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER && event.values[1] > 0) {
            Log.d("C","Sotto "+event.values[1]);
            if(charmender.getY()+charmender.getHeight()+(5*(event.values[1]))<height) {
                charmender.setY(charmender.getY() + (5*event.values[1]));
            }else{
                for(int i=4;i>=0;i--){
                    if(charmender.getY()+charmender.getHeight()+(i*(event.values[1]))<height) {
                        charmender.setY(charmender.getY() + (i * (event.values[1])));
                    }
                }
            }
        }
        else {
            Log.d("C","Sopra "+event.values[1]);
            if(charmender.getY()>(5*(-event.values[1]))) {
                charmender.setY(charmender.getY() - (5*(-event.values[1])));
            }else {
                for(int i=4;i>=0;i--){
                    if(charmender.getY()>(i*(-event.values[1]))) {
                        charmender.setY(charmender.getY() - (i * (-event.values[1])));
                    }
                }
            }
        }


    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
