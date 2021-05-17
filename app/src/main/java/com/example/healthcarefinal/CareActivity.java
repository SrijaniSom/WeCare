package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);

        TextView selfextv=(TextView)findViewById(R.id.selfexTV);
        selfextv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CareActivity.this,selfCareExercises.class));

            }
        });

        TextView rotinetv=(TextView)findViewById(R.id.routineId);
        rotinetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CareActivity.this,routinecare.class));
            }
        });

        TextView writeTV=(TextView)findViewById(R.id.writeself);
        writeTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CareActivity.this,JournalActivity.class));
            }
        });

        TextView caretvn=(TextView)findViewById(R.id.meditateself);
        caretvn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CareActivity.this,MeditationActivity.class));
            }
        });
    }
}