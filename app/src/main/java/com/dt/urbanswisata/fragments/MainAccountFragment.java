package com.dt.urbanswisata.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dt.urbanswisata.activities.SplashLoginActivity;
import com.dt.urbanswisata.databinding.FragmentMainAccountBinding;
import com.dt.urbanswisata.models.AccountViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class MainAccountFragment extends Fragment {

    private Intent i;
    private AccountViewModel accountViewModel;
    private FragmentMainAccountBinding b;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        b = FragmentMainAccountBinding.inflate(getLayoutInflater());
        b.btnLogout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            i = new Intent(getContext(), SplashLoginActivity.class);
            startActivity(i);
        });
        return b.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}