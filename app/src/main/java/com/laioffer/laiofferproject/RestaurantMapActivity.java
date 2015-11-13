package com.laioffer.laiofferproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantMapActivity extends FragmentActivity implements OnMapReadyCallback {
    public final static String EXTRA_LATLNG = "EXTRA_LATLNG";

    private LatLng toMark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_map);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        MapFragment mapFragment =
                (MapFragment) getFragmentManager().findFragmentById(R.id.restaurant_map);
        mapFragment.getMapAsync(this);

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            toMark = bundle.getParcelable(EXTRA_LATLNG);
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap map) {
        if (toMark != null) {
            map.addMarker(new MarkerOptions().position(toMark).title("Marker"));
            map.moveCamera(CameraUpdateFactory.newLatLng(toMark));
            map.animateCamera(CameraUpdateFactory.zoomTo(6), 2000, null);
        }

    }

}
