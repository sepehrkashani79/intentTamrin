package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class confirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        TextView fName  = findViewById(R.id.fNameConfirm);
        TextView lName = findViewById(R.id.lNameConfirm);
        TextView phone = findViewById(R.id.phoneConfirm);
        TextView age = findViewById(R.id.ageConfirm);
        TextView addres = findViewById(R.id.addresConfirm);

        Button btnConfirm = findViewById(R.id.btnProfileConfirm);
        Button btnEdit = findViewById(R.id.btnProfileEdit);

        final Intent i=getIntent();
        fName.setText("First name: "+i.getStringExtra("fname"));
        lName.setText("Last name: "+i.getStringExtra("lname"));
        phone.setText("Phone number: "+i.getStringExtra("phone"));
        age.setText("Age: "+i.getStringExtra("age"));
        addres.setText("Addres: "+i.getStringExtra("addres"));
        final Intent r=new Intent();//result

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.putExtra("savedName",i.getStringExtra("fname")+" "+i.getStringExtra("lname"));
                setResult(Activity.RESULT_OK,r);
                finish();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

    }
}















