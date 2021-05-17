package com.example.healthcarefinal;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.healthcarefinal.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CovidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setItemIconTintList(null);


        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }

}