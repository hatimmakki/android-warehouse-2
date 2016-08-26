package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.utils.GoogleMapsUtils;

public class GoogleMapsDemo extends FragmentActivity {
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_demo);
        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        GoogleMapsUtils.addMarkerToMap(mMap, -34.548373, -58.718667, "Calle para correr!", R.drawable.abduction);
        GoogleMapsUtils.addMarkerToMap(mMap, -34.5453511, -58.7106421, "Por aca suelen ir al baño...", R.drawable.aboriginal);
        GoogleMapsUtils.addMarkerToMap(mMap, -34.5500524, -58.7120583, "No pases los dias que alguien se reciba...", R.drawable.eggs);
        GoogleMapsUtils.addMarkerToMap(mMap, -34.543131, -58.711875, "Le aseguro que aqui no se droga nadie!", R.drawable.drinkingwater);
        GoogleMapsUtils.addMarkerToMap(mMap, -34.5444444, -58.7127175, "Y creias que en provincia no habian taxis?", R.drawable.car);
        GoogleMapsUtils.addMarkerToMap(mMap, -34.5339038,-58.7014631, "Aqui Frecuentan chicas disfrazadas de Pikachu",R.drawable.beach);

        mMap.setMyLocationEnabled(true);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-34.548373, -58.718667), 12f));

        UiSettings uiSettings = mMap.getUiSettings();

        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setCompassEnabled(true);
        uiSettings.setMapToolbarEnabled(true);
    }
}
