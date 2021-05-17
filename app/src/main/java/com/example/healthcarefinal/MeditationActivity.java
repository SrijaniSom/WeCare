package com.example.healthcarefinal;

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

public class MeditationActivity extends AppCompatActivity {
    VideoView videoView;
    ListView listView;
    ArrayList<String>videoList;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meditation);
        videoView=findViewById(R.id.videoview);
        listView=findViewById(R.id.lvideo);
        videoList= new ArrayList<>();

        videoList.add("Meditation");
        videoList.add("Legs streach extention");
        videoList.add("Outdoor yoga");
        videoList.add("Salute to the sun");
        videoList.add("Sun salutation");

        adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,videoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.meditation));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.legs_stretch_extention));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.outdoor_yoga));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.salute_to_the_sun));
                        break;
                    case 4:
                        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sun_salutation));
                        break;
                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(MeditationActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });
    }
}