package com.example.healthcarefinal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcarefinal.JournalActivity;


import java.util.HashSet;

public class NoteEditor extends AppCompatActivity {
    private EditText editNote;
    private int noteID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);


        editNote = (EditText) findViewById(R.id.txtEditNote);

        Intent intent = getIntent();
        noteID = intent.getIntExtra("noteID", -1);


        if (noteID != -1) {
            editNote.setText(JournalActivity.notes.get(noteID));

        } else {
            JournalActivity.notes.add("");
            noteID = JournalActivity.notes.size() - 1;
        }


        editNote.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {



                JournalActivity.notes.set(noteID, String.valueOf(s));

                JournalActivity.arrayAdapter.notifyDataSetChanged();


                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.wiilearntech.notes", Context.MODE_PRIVATE);

                HashSet<String> set = new HashSet<>(JournalActivity.notes);

                sharedPreferences.edit().putStringSet("notes", set).apply();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}