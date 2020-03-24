package com.example.covid;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Stack;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;





        double lat = getIntent().getDoubleExtra("lat",0);
        double longi = getIntent().getDoubleExtra("longi",0);
        //String country = getIntent().getStringExtra("country");
        String cases = getIntent().getStringExtra("cases");

        // Add a marker in Sydney and move the camera
        LatLng point = new LatLng(lat, longi);
        mMap.addMarker(new MarkerOptions().position(point).title(cases));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(point));

        /*mMap.addCircle(new CircleOptions()
                .center(new LatLng(lat, longi))
                .radius(10000000)
                .strokeColor(Color.RED)
                .fillColor(Color.RED));*/

    }
}
