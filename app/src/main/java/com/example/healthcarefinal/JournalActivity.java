package com.example.healthcarefinal;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.example.healthcarefinal.NoteEditor;
import com.example.healthcarefinal.R;

import java.util.ArrayList;
import java.util.HashSet;

public class JournalActivity extends AppCompatActivity {
    private ListView notesList;
    protected static ArrayList<String> notes = new ArrayList<>();
    protected static ArrayAdapter arrayAdapter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal);


        sharedPreferences = getApplicationContext().getSharedPreferences("com.wiilearntech.notes", Context.MODE_PRIVATE);


        notesList = (ListView) findViewById(R.id.listNotes);

        HashSet<String> set = (HashSet<String>) sharedPreferences.getStringSet("notes", null);
        if (set == null) {

            notes.add("Example Note");
        } else {

            notes = new ArrayList<>(set);
        }


        arrayAdapter = new ArrayAdapter(
                this, android.R.layout.simple_list_item_1, notes);

        notesList.setAdapter(arrayAdapter);


        notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("NoteID: ", notes.get(position));


                Intent intent = new Intent(getApplicationContext(), NoteEditor.class);


                intent.putExtra("noteID", position);


                startActivity(intent);
            }
        });


        notesList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {




                new AlertDialog.Builder(JournalActivity.this).setIcon(

                        android.R.drawable.ic_dialog_alert).setTitle(

                        "Are you sure?"
                ).setMessage(
                        /*Setting message*/"Do you want to delete this note?").setPositiveButton(
                        /*Setting yes option*/"Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {


                                notes.remove(position);
                                arrayAdapter.notifyDataSetChanged();

                                HashSet<String> set = new HashSet<>(JournalActivity.notes);

                                sharedPreferences.edit().putStringSet("notes", set).apply();
                                Toast.makeText(JournalActivity.this, "Note deleted! :(", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", null).show();

                return true;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*Class to get menu items*/
        MenuInflater menuInflater = getMenuInflater();

        /*Connecting code to UI*/
        menuInflater.inflate(R.menu.add_note_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.menuAddNote) {
            Log.i("menuAddNote", "tapped");


            Intent intent = new Intent(getApplicationContext(), NoteEditor.class);


            startActivity(intent);
            return true;
        }
        return false;
    }
}