package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class purpActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purp);


        Button dirbtn=(Button)findViewById(R.id.PhoneDirectoryBtn);
        dirbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(purpActivity.this,DirectoryActivity.class));
            }
        });


        Button mbtn=(Button)findViewById(R.id.myth_button);
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(purpActivity.this,myth.class));
            }
        });


        Button ebtn=(Button)findViewById(R.id.emergencybtn);
        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(purpActivity.this,EmergencyActivity.class));
            }
        });

        Button selfc=(Button)findViewById(R.id.selfcarebtn);
        selfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(purpActivity.this,CareActivity.class));
            }
        });
        Button covbt=(Button)findViewById(R.id.covidpurpbtn);
        covbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(purpActivity.this,CovidZone.class));
            }
        });

        Button fitbtbn=(Button)findViewById(R.id.fitnesscorner);
        fitbtbn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(purpActivity.this,fitnessActivity.class));
            }
        });


    }





}