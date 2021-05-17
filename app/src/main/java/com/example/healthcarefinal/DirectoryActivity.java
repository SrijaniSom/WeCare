package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.healthcarefinal.DBHelp;
import com.example.healthcarefinal.R;


public class DirectoryActivity extends AppCompatActivity
{
    Button ins,mod,del,v;
    EditText n,p,a;
    DBHelp DB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);



        ins=(Button)findViewById(R.id.btnIns);
        mod=(Button)findViewById(R.id.btnmod);
        del=(Button)findViewById(R.id.btnDel);
        v=(Button)findViewById(R.id.btnsee);

        n=(EditText)findViewById(R.id.change_textView);
        p=(EditText)findViewById(R.id.phonemedic);
        a=(EditText)findViewById(R.id.AddMedic);

        DB = new DBHelp(this);
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = n.getText().toString();
                String contactTXT = p.getText().toString();
                String dobTXT = a.getText().toString();
                if(nameTXT.isEmpty()||contactTXT.isEmpty()||dobTXT.isEmpty()){
                    Toast.makeText(DirectoryActivity.this,"Fill all entries",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                    if(checkinsertdata==true)
                        Toast.makeText(DirectoryActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DirectoryActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }        }});


        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT =  n.getText().toString();
                String contactTXT = p.getText().toString();
                String dobTXT = a.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(DirectoryActivity.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DirectoryActivity.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = n.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(DirectoryActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DirectoryActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DirectoryActivity.this, viewn.class));
            }        });


    }
}