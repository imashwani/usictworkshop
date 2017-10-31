package com.example.android.usictworkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Hello yaar this  is going on ok
    //plugin adb WIFI  just connect this using once using usb and then use wifi from next time
// hexcolor defined as #rrggbb  easy-pesy

    EditText etVar1,etVar2;
    Button add;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvResult= (TextView) findViewById(R.id.varResult);
        etVar1= (EditText) findViewById(R.id.etVar1);
        etVar2= (EditText) findViewById(R.id.etVar2);
        add= (Button) findViewById(R.id.addButton);
        etVar2.setText(""); etVar1.setText("");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try{
                    int var1=Integer.valueOf(etVar1.getText().toString());
                    int var2=Integer.valueOf(etVar2.getText().toString());
                    int result=var1+var2;
                    tvResult.setText(String.valueOf(result));
                }catch (NumberFormatException e)
               {
                   Toast.makeText(MainActivity.this,"Enter the Numbers in the Box",Toast.LENGTH_LONG).show();
               }
            }
        });
        findViewById(R.id.sensorDisco).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(MainActivity.this,SensorDiscoActivity.class);
                startActivity(it);
            }
        });
    }
}
