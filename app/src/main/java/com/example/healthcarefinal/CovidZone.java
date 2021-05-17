package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CovidZone extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_zone);

        TextView trbtn=(TextView) findViewById(R.id.trackerId);
        trbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CovidZone.this,CovidActivity.class));
            }
        });

        TextView mendtvn=(TextView)findViewById(R.id.mendId);
        mendtvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CovidZone.this,MendActivity.class));
            }
        });
    }
}