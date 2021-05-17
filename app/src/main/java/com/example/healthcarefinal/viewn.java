package com.example.healthcarefinal;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.healthcarefinal.DBHelp;


import java.util.ArrayList;
import java.util.List;

public class viewn extends AppCompatActivity
{
    DBHelp db;
    ArrayList<User> userList1;
    ListView listview;
    User user;
    CustomisedAdapter adapter;
    EditText find;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        userList1=new ArrayList<User>();
        db=new DBHelp(this);

        Cursor data=db.getdata();
        int num_rows=data.getCount();
        if(num_rows==0)
        {
            Toast.makeText(viewn.this,"Sorry,no data entry",Toast.LENGTH_SHORT).show();
        }
        else

        {
            while(data.moveToNext())
            {

                user = new User(data.getString(0),data.getString(1),data.getString(2));
                userList1.add(user);
            }
            adapter =new CustomisedAdapter(this, R.layout.content_layout,userList1);
            listview=(ListView)findViewById(R.id.ngo_listView);
            listview.setAdapter(adapter);

        }



    }

}
