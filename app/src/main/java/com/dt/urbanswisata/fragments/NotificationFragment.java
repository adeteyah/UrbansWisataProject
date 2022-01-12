package com.dt.urbanswisata.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.dt.urbanswisata.databinding.FragmentNotificationBinding;
import com.dt.urbanswisata.models.NotificationViewModel;

public class NotificationFragment extends Fragment {

    private NotificationViewModel notificationViewModel;
    private FragmentNotificationBinding b;

    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        notificationViewModel = new ViewModelProvider(this).get(NotificationViewModel.class);

        b = FragmentNotificationBinding.inflate(getLayoutInflater());
        View root = b.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        b = null;
    }
}