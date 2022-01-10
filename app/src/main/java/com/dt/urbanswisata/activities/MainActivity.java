package com.dt.urbanswisata.activities;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.dt.urbanswisata.R;
import com.dt.urbanswisata.databinding.ActivityMainBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setSupportActionBar(b.toolbar);
        setContentView(b.getRoot());
        myCode();
    }

    private void myCode() {
        //
        NavController nc = Navigation.findNavController(this, R.id.main_fragment);
        NavigationUI.setupWithNavController(b.navigation, nc);
        b.navigation.setBackgroundColor(0);
        //
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {
            Glide.with(this).load(signInAccount.getPhotoUrl()).into(b.imageAvatar);
        }
        //
        b.btnMenu.setOnClickListener(v -> {
            // TODO: Expandable
        });
    }

}