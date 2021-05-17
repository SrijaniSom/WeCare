package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.healthcarefinal.R;

public class selfCareExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_care_exercises);
        ImageView img =(ImageView)findViewById(R.id.eximg);
        Spinner spinner=(Spinner)findViewById(R.id.spinnerexercise);

        ArrayAdapter<String> adapex=new ArrayAdapter<>(selfCareExercises.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Exercise));
        spinner.setAdapter(adapex);

        Button e =(Button)findViewById(R.id.ex_btn);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exerciseTXT=spinner.getSelectedItem().toString();
                switch(exerciseTXT)
                {
                    case "Exercise 1":img.setImageResource(R.drawable.ex1);
                        break;
                    case "Exercise 2":img.setImageResource(R.drawable.ex2);
                        break;
                    case "Exercise 3":img.setImageResource(R.drawable.ex3);
                        break;
                    case "Exercise 4":img.setImageResource(R.drawable.ex4);
                        break;
                    case "Exercise 5":img.setImageResource(R.drawable.ex5);
                        break;
                    default:img.setImageResource(R.drawable.ex1);
                        break;
                }
            }
        });


    }
}