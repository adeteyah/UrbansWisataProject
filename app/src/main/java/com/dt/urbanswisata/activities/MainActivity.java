package com.dt.urbanswisata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import com.dt.urbanswisata.R;
import com.dt.urbanswisata.databinding.ActivityMainBinding;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    private MenuItem mi;
    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        //
        NavController nc = Navigation.findNavController(this, R.id.fragment_main_activity);
        NavigationUI.setupWithNavController(b.bottomNavigationBar, nc);
    }

}