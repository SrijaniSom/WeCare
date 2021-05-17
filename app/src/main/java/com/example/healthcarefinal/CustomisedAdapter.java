package com.example.healthcarefinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;


import com.example.healthcarefinal.R;
import com.example.healthcarefinal.User;

import java.util.ArrayList;

public class CustomisedAdapter extends ArrayAdapter<User>
{
    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public CustomisedAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView firstName = (TextView) convertView.findViewById(R.id.info_textView);
            TextView lastName = (TextView) convertView.findViewById(R.id.role_textView);
            TextView favFood = (TextView) convertView.findViewById(R.id.res_textView);
            if (firstName != null) {
                firstName.setText(user.getname());
            }
            if (lastName != null) {
                lastName.setText((user.getphone()));
            }
            if (favFood != null) {
                favFood.setText((user.getaddress()));
            }
        }

        return convertView;
    }

}
