package com.example.healthcarefinal.ui.country;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.healthcarefinal.R;

import java.util.ArrayList;

public class CovidCountryAdapter extends RecyclerView.Adapter<CovidCountryAdapter.ViewHolder> {

    ArrayList<CovidCountry> covidCountries;

    public CovidCountryAdapter(ArrayList<CovidCountry>covidCountries){
        this.covidCountries = covidCountries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_covid_country,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CovidCountry covidCountry =covidCountries.get(position);
        holder.tvTotalCases.setText(covidCountry.getmcases());
        holder.tvCountryName.setText(covidCountry.getmCovidCountry());
    }

    @Override
    public int getItemCount() {
        return covidCountries.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTotalCases, tvCountryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTotalCases =itemView.findViewById(R.id.tvTotalCases);
            tvCountryName =itemView.findViewById(R.id.tvCountryName);
        }
    }
}