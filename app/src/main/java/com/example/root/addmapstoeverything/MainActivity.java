package com.example.root.addmapstoeverything;

import android.*;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap n_map;
    boolean mapready=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnmap=(Button)findViewById(R.id.normal);
        btnmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapready){
                    n_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                }
            }
        });
        Button btnsatellite=(Button)findViewById(R.id.satellite);
        btnsatellite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapready){
                    n_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                }
            }
        });
        Button btnhybrid=(Button)findViewById(R.id.hybrid);
        btnhybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mapready){
                    n_map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                }
            }
        });
        MapFragment mapFragment=(MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override
    public void onMapReady(GoogleMap map){

        mapready=true;
        n_map=map;
        LatLng latLng=new LatLng(17.26,78.32);
        MarkerOptions new_pos = new MarkerOptions().position(latLng).title("India");
        CameraPosition target=CameraPosition.builder().target(latLng).zoom(10).build();
        n_map.animateCamera(CameraUpdateFactory.newCameraPosition(target),1500,null);//animates the camera the last parameter
        n_map.addMarker(new_pos);
        //defines a callback function which can be executed at the end of the loading. for simplicity we can use the simple move camera function also

    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
    }*/

}