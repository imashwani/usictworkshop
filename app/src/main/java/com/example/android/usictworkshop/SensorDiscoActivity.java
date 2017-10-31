package com.example.android.usictworkshop;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.RelativeLayout;

public class SensorDiscoActivity extends AppCompatActivity {
    RelativeLayout rLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_disco);

        rLayout= (RelativeLayout) findViewById(R.id.rlayout);
        SensorManager sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor accelSensor=sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        SensorEventListener sel=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                Log.d("", "onSensorChanged: AX: "+sensorEvent.values[0]);
                Log.d("", "onSensorChanged: Ay: "+sensorEvent.values[1]);
                Log.d("", "onSensorChanged: Az: "+sensorEvent.values[2]);
//                sensorEvent.values

//a@cb.lk  +91 9643339706  https://github.com/coding-blocks-archives

                rLayout.setBackgroundColor(
                        Color.rgb(
                                a2c(sensorEvent.values[0]),
                                a2c(sensorEvent.values[1]),
                                a2c(sensorEvent.values[2])
                        )
                );

            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sm.registerListener(
                sel,
                accelSensor,
                1000*1000*2);
    }

    int a2c (float a) {
        return (int) (((a + 12) / 24) * 255);
    }

}
