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

public class DietActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        ImageView img =(ImageView)findViewById(R.id.eximg);
        Spinner spinner=(Spinner)findViewById(R.id.spinnerexercise);

        ArrayAdapter<String> adapex=new ArrayAdapter<>(DietActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Diet));
        spinner.setAdapter(adapex);

        Button e =(Button)findViewById(R.id.ex_btn);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exerciseTXT=spinner.getSelectedItem().toString();
                switch(exerciseTXT)
                {
                    case "Day 1":img.setImageResource(R.drawable.d1);
                        break;
                    case "Day 2":img.setImageResource(R.drawable.d2);
                        break;
                    case "Day 3":img.setImageResource(R.drawable.d3);
                        break;
                    case "Day 4":img.setImageResource(R.drawable.d4);
                        break;
                    case "Day 5":img.setImageResource(R.drawable.d5);
                        break;
                    case "Day 6":img.setImageResource(R.drawable.d6);
                        break;
                    case "Day 7":img.setImageResource(R.drawable.d7);
                        break;
                    default:img.setImageResource(R.drawable.d1);
                        break;
                }
            }
        });


    }
}