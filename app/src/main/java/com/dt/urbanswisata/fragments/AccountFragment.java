package com.dt.urbanswisata.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.dt.urbanswisata.activities.OnboardActivity;
import com.dt.urbanswisata.databinding.FragmentAccountBinding;
import com.dt.urbanswisata.models.AccountViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;

public class AccountFragment extends Fragment {

    private Intent i;
    private AccountViewModel mdl;
    private FragmentAccountBinding b;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        b = FragmentAccountBinding.inflate(getLayoutInflater());
        b.btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            i = new Intent(getContext(), OnboardActivity.class);
            startActivity(i);
        });
        return b.getRoot();
    }

}