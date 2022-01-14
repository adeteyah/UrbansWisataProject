package com.dt.urbanswisata.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dt.urbanswisata.databinding.FragmentMainExploreBinding;
import com.dt.urbanswisata.models.ExploreViewModel;

public class MainExploreFragment extends Fragment {

    private ExploreViewModel exploreViewModel;
    private FragmentMainExploreBinding b;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

        exploreViewModel = new ViewModelProvider(this).get(ExploreViewModel.class);

        b = FragmentMainExploreBinding.inflate(getLayoutInflater());
        View v = b.getRoot();

        return v;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}