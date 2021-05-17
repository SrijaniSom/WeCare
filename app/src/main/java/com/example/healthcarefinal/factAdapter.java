package com.example.healthcarefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.healthcarefinal.myth;


import java.util.ArrayList;

public class factAdapter extends ArrayAdapter<mythj>
{
    public factAdapter(Context context, ArrayList<mythj> pWords)

    {
        super(context,0, pWords);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.compt_layout, parent, false);
        }
        mythj local = getItem(position);
        TextView hTextView = (TextView) listItemView.findViewById(R.id.header_text_view);
        hTextView.setText(local.getName());
        TextView desTextView= (TextView) listItemView.findViewById(R.id.url_text_view);
        desTextView.setText(local.getDescription());
        ImageView imgView=(ImageView)listItemView.findViewById(R.id.image_view);
        imgView.setImageResource(local.getImage());

        return listItemView;
    }
}
