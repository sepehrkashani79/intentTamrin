package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        final EditText phoneNumber=findViewById(R.id.number);
        Button dialBtn=findViewById(R.id.btnDial);

        final Intent Dial =new Intent(Intent.ACTION_DIAL);


        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dial.setData(Uri.parse("tel:"+phoneNumber.getText().toString()));
                startActivity(Dial);
            }
        });
    }
}
