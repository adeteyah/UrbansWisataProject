package com.dt.urbanswisata.activities;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.Toast;

import com.dt.urbanswisata.R;
import com.dt.urbanswisata.databinding.ActivityMapAddBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapAddActivity extends FragmentActivity implements OnMapReadyCallback {

    private Geocoder g;
    private GoogleMap gm;
    private MarkerOptions mo;
    private List<Address> al;
    private ActivityMapAddBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMapAddBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
        //
        SupportMapFragment smf = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        smf.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gm = googleMap;
        g = new Geocoder(this, Locale.getDefault());

        b.btnSearch.setOnClickListener(locName -> {
            gm.clear();
            try {
                al = g.getFromLocationName(b.etInputLocation.getText().toString(), 1);
                Address a = al.get(0);
                LatLng ll = new LatLng(a.getLatitude(), a.getLongitude());
                if (al.size() > 0) {
                    mo = new MarkerOptions().position(ll).title(a.getLocality());
                    gm.addMarker(mo);
                    gm.animateCamera(CameraUpdateFactory.newLatLngZoom(ll, 16));
                } else {
                    Toast.makeText(this, "Place does not exists", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        gm.setOnMapClickListener(latLng -> {
            gm.clear();
            try {
                al = g.getFromLocation(latLng.latitude, latLng.longitude, 1);
                if (al.size() > 0) {
                    b.etInputLocation.setText(al.get(0).getAddressLine(0));
                    mo = new MarkerOptions().position(latLng).title(al.get(0).getLocality());
                    gm.addMarker(mo);
                    gm.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                } else {
                    Toast.makeText(this, "Place does not exists", Toast.LENGTH_SHORT).show();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}