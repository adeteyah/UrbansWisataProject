package com.dt.urbanswisata.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.dt.urbanswisata.adapters.ComposeFragmentAdapter;
import com.dt.urbanswisata.databinding.ActivityComposeEventBinding;
import com.google.android.gms.maps.MapView;
import com.google.android.material.tabs.TabLayout;

public class ComposeEventActivity extends AppCompatActivity {

    private MapView mv;
    private ComposeFragmentAdapter cfa;
    private boolean isPermissionGranted;
    private ActivityComposeEventBinding b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityComposeEventBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        //
        FragmentManager fm = getSupportFragmentManager();
        cfa = new ComposeFragmentAdapter(fm, getLifecycle());
        b.viewPager.setAdapter(cfa);
        b.tab.addTab(b.tab.newTab().setText("Basic"));
        b.tab.addTab(b.tab.newTab().setText("Location"));
        b.tab.addTab(b.tab.newTab().setText("Details"));
        b.tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                b.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        b.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                b.tab.selectTab(b.tab.getTabAt(position));
            }
        });
        //
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}