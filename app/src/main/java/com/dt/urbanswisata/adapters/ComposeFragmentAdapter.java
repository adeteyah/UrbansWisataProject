package com.dt.urbanswisata.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.dt.urbanswisata.fragments.ComposeFirstFragment;
import com.dt.urbanswisata.fragments.ComposeSecondFragment;
import com.dt.urbanswisata.fragments.ComposeThirdFragment;

public class ComposeFragmentAdapter extends FragmentStateAdapter {

    public ComposeFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new ComposeSecondFragment();
            case 2:
                return new ComposeThirdFragment();
        }

        return new ComposeFirstFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
