package com.dt.urbanswisata.utils;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.dt.urbanswisata.activities.MainActivity;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class MyUtils {

    public static void Glide(AppCompatActivity appCompatActivity, String url, ImageView view) {
        Glide.with(appCompatActivity)
                .load(url)
                .into(view);
    }

}
