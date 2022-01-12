package com.dt.urbanswisata.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dt.urbanswisata.databinding.FragmentDashboardBinding;
import com.dt.urbanswisata.models.DashboardViewModel;

public class DashboardFragment extends Fragment {

    private DashboardViewModel mViewModel;
    private FragmentDashboardBinding b;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        b = FragmentDashboardBinding.inflate(getLayoutInflater());
        //

        //
        return b.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}