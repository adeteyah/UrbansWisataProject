package com.dt.urbanswisata.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dt.urbanswisata.databinding.FragmentMainNotificationBinding;
import com.dt.urbanswisata.models.NotificationViewModel;

public class MainNotificationFragment extends Fragment {

    private NotificationViewModel notificationViewModel;
    private FragmentMainNotificationBinding b;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        notificationViewModel = new ViewModelProvider(this).get(NotificationViewModel.class);

        b = FragmentMainNotificationBinding.inflate(getLayoutInflater());
        View root = b.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}