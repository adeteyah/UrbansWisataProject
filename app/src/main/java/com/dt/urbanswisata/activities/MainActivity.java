package com.dt.urbanswisata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

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
    private MenuItem mi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        //
        setSupportActionBar(b.toolbar);
        setContentView(b.getRoot());
        //
        NavController nc = Navigation.findNavController(this, R.id.fragment_main_activity);
        NavigationUI.setupWithNavController(b.bottomNavigationBar, nc);
        b.bottomNavigationBar.setBackgroundColor(0);
        //
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {
            Glide.with(this).load(signInAccount.getPhotoUrl()).into(b.imageAvatar);
        }
    }

}