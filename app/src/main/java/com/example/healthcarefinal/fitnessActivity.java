package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class fitnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness);

        TextView bmcaltv=(TextView)findViewById(R.id.bmical);
        bmcaltv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fitnessActivity.this,bmiActivity.class));
            }
        });

        TextView worktvn=(TextView)findViewById(R.id.workout);
        worktvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fitnessActivity.this,workoutActivity.class));
            }
        });
        TextView wotvn=(TextView)findViewById(R.id.work);
        wotvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(fitnessActivity.this,DietActivity.class));
            }
        });


    }
}