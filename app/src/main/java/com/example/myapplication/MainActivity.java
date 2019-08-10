package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText phoneNumber=findViewById(R.id.number);
        Button dialBtn=findViewById(R.id.btnDial);
        Button btnEnterData=findViewById(R.id.btnEnterData);


        final Intent Dial =new Intent(Intent.ACTION_DIAL);


        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dial.setData(Uri.parse("tel:"+phoneNumber.getText().toString()));
                startActivity(Dial);
            }
        });
        //------------------------------------------------
        final Intent gotoEnterData = new Intent(MainActivity.this,profileActivity.class);

        btnEnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(gotoEnterData);
            }
        });

    }
}
