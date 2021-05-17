package com.example.healthcarefinal;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.healthcarefinal.R;

import java.util.ArrayList;

public class workoutActivity extends AppCompatActivity {
    VideoView videoView;
    ListView listView;
    ArrayList<String>videoList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        videoView=findViewById(R.id.videoview);
        listView=findViewById(R.id.lvideo);
        videoList= new ArrayList<>();
        videoList.add("Hips workout");
        videoList.add("Skipping");
        videoList.add("Jogging");
        videoList.add("Muscle ups");
        videoList.add("Abs workout");


        adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hips_workout));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.skipping));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.jogging));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.muscle_ups));
                        break;
                    case 4:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.abs_workout));
                        break;

                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(workoutActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });
    }
}