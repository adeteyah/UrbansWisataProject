package com.dt.urbanswisata.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dt.urbanswisata.activities.ComposeEventActivity;
import com.dt.urbanswisata.databinding.FragmentMainDashboardBinding;
import com.dt.urbanswisata.models.DashboardViewModel;

public class MainDashboardFragment extends Fragment {

    private Intent i;
    private FragmentMainDashboardBinding b;
    private DashboardViewModel mViewModel;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        b = FragmentMainDashboardBinding.inflate(getLayoutInflater());
        //
        b.btnNavigateToComposeActivity.setOnClickListener(v -> {
            i = new Intent(getContext(), ComposeEventActivity.class);
            startActivity(i);
        });
        //
        return b.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}