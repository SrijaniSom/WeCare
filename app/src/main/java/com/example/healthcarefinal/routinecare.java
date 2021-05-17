package com.example.healthcarefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthcarefinal.R;

public class routinecare extends AppCompatActivity {

    GridView gridV;

    String[] name={"Be Hydrated","Stimulate yourselves","Sleep daily","Don't miss Medicines","Walk","Read Books","Take Bath","Digital Detox","Reflect in journals","Meditate","Music Therapy"};
    int[] images={R.drawable.hydrate2,R.drawable.stimulate2,R.drawable.sleep2,R.drawable.meds2,R.drawable.walk2,R.drawable.books2,R.drawable.bath2,R.drawable.detox2,R.drawable.journal,R.drawable.meditate,R.drawable.music};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routinecare);
        gridV=(GridView)findViewById(R.id.gridview);

        CustomAdapter customAdapter=new CustomAdapter(name,images,this);
        gridV.setAdapter(customAdapter);
    }

    public class CustomAdapter extends BaseAdapter
    {
        private String[] imageName;
        private int[] imagePhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imageName, int[] imagePhoto, Context context) {
            this.imageName = imageName;
            this.imagePhoto = imagePhoto;
            this.context = context;
            this.layoutInflater=(LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }


        @Override
        public int getCount() {
            return imagePhoto.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if(convertView == null)
            {
                convertView=layoutInflater.inflate(R.layout.row_items,parent,false);

            }
            TextView tvName=convertView.findViewById(R.id.TextViewself);
            ImageView imagePhotoName=convertView.findViewById(R.id.ImageViewself);

            tvName.setText(imageName[position]);
            imagePhotoName.setImageResource(imagePhoto[position]);

            return convertView;
        }
    }
}