package com.example.myapplication;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        TextView profileChecker=findViewById(R.id.profileCheckTxtView);
        final EditText firstName=findViewById(R.id.fName);
        final EditText lastName=findViewById(R.id.lName);
        final EditText phoneNumber=findViewById(R.id.phoneNumber);
        final EditText age=findViewById(R.id.age);
        final EditText addres=findViewById(R.id.addres);
        Button btnContinue=findViewById(R.id.btnContinue);

        final Intent gotoConfirmActivity =new Intent(profileActivity.this,confirmActivity.class);

        String savedName=PreferenceManager.getDefaultSharedPreferences(profileActivity.this)
                .getString("fullName","Unknown User!!!");
        profileChecker.setText(savedName);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoConfirmActivity.putExtra("fname",firstName.getText().toString());
                gotoConfirmActivity.putExtra("lname",lastName.getText().toString());
                gotoConfirmActivity.putExtra("age",age.getText().toString());
                gotoConfirmActivity.putExtra("phone",phoneNumber.getText().toString());
                gotoConfirmActivity.putExtra("addres",addres.getText().toString());
                startActivityForResult(gotoConfirmActivity,1100);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent resultFromConfirmActivity=getIntent();
        if (requestCode == 1100) {
            if (resultCode == RESULT_OK) {
                PreferenceManager.getDefaultSharedPreferences(profileActivity.this).edit()
                        .putString("fullName",resultFromConfirmActivity.getStringExtra("savedName")).apply();
                //Log.d("sepehr",getIntent().getStringExtra("Name"));
                Toast profileConfirmed = Toast.makeText(profileActivity.this,"Profile Confirmed and saved",Toast.LENGTH_LONG);
                profileConfirmed.show();
            }
        }
    }
}
