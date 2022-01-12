package com.dt.urbanswisata.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.dt.urbanswisata.databinding.ActivityComposeEventBinding;

public class ComposeEventActivity extends AppCompatActivity {

    private ActivityComposeEventBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityComposeEventBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }
}