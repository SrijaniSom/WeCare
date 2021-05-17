package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthcarefinal.R;

public class bmiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        Button bt=(Button)findViewById(R.id.btn);
        EditText h =(EditText)findViewById(R.id.height) ;
        EditText w=(EditText)findViewById(R.id.weight);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float hf=(Float.parseFloat(h.getText().toString()))/100;
                float wf=Float.parseFloat(w.getText().toString());
                float res=(wf/(hf*hf));
                TextView r=(TextView)findViewById(R.id.showresult);
                r.setText(Float.toString(res));

            }


        });

    }

}