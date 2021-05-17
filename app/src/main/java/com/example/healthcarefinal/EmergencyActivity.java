package com.example.healthcarefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyActivity extends AppCompatActivity {
 EditText phoneEmer,messEmer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        phoneEmer = (EditText) findViewById(R.id.numberEmergencyEditText);
        messEmer = (EditText) findViewById(R.id.EmergencyMessageText);
        TextView messageTV = (TextView) findViewById(R.id.msgBtn);
        messageTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int permissionCheck = ContextCompat.checkSelfPermission(EmergencyActivity.this, Manifest.permission.SEND_SMS);

                if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

                    MyMessage();

                } else {

                    ActivityCompat.requestPermissions(EmergencyActivity.this, new String[]{Manifest.permission.SEND_SMS}, 0);

                }

            }
        });



        TextView emcall=(TextView)findViewById(R.id.callbtn);
        emcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String number=phoneEmer.getText().toString();
                    Intent intent=new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+number));
                    startActivity(intent);
            }
        });



        TextView lbt=(TextView)findViewById(R.id.locationBtn);
        lbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(EmergencyActivity.this,MapsActivity.class));
               String str = phoneEmer.getText().toString();
               Intent intent=new Intent(getApplicationContext(),MapsActivity.class);
               intent.putExtra("message_key",str);
               startActivity(intent);
            }
        });
    }
        private void MyMessage()
    {
            String chickchiki = phoneEmer.getText().toString().trim();
            String Message = messEmer.getText().toString().trim();

            if (phoneEmer.getText().toString().equals("") || !messEmer.getText().toString().equals("")) {

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(chickchiki, null, Message, null, null);
                Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show();


            } else {
                Toast.makeText(this, "Please Enter chickchiki or Message", Toast.LENGTH_SHORT).show();

            }
        }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){

            case 0:
                if (grantResults.length >= 0 && grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                    MyMessage();


                }
                else{
                    Toast.makeText(this,"You don't have Required Permission to make this Action",Toast.LENGTH_SHORT).show();
                }


        }
    }




}