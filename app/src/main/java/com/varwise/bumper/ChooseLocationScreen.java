package com.varwise.bumper;

import android.app.ActionBar;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class ChooseLocationScreen extends FragmentActivity implements LocationListener {
    private GoogleMap mMap;
    private EditText addressEditText;
    private LocationManager locationManager;
    private String locationProvider;
    private Button okButton;

    public static String baseKey = "ChooseLocationScreen";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT < 11) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);

        } else {
            ActionBar actionBar = getActionBar();
            actionBar.hide();
        }

        setContentView(R.layout.map_activity);

        String address = ScreenDB.getAddress(baseKey, getApplicationContext());


        addressEditText = (EditText) findViewById(R.id.chosen_address);
        addressEditText.setText(address);

        okButton = (Button) findViewById(R.id.map_button_ok);

        okButton.setOnClickListener( new OnClickListener() {

            @Override
            public void onClick(View v) {
                String location = addressEditText.getText().toString();
                ScreenDB.setAddress(baseKey, getApplicationContext(), location);
                ScreenDB.setFinishedDate(baseKey, getApplicationContext());
                finish();
            }
        });

        loadMap();

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        locationProvider = locationManager.getBestProvider(criteria, true);

        Location location = locationManager.getLastKnownLocation(locationProvider);

        if (location != null) {
            onLocationChanged(location);
        }
        locationManager.requestLocationUpdates(locationProvider, 20000, 0, this);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng point) {
                Toast.makeText(getApplicationContext(), "Getting location... ", Toast.LENGTH_LONG).show();

                Geocoder geocoder;
                List<Address> addresses;
                geocoder = new Geocoder(getApplicationContext());
                if (point.latitude != 0 || point.longitude != 0) {
                    try {
                        addresses = geocoder.getFromLocation(point.latitude, point.longitude, 1);
                        String address = addresses.get(0).getAddressLine(0);
                        String city = addresses.get(0).getAddressLine(1);
                        addressEditText.setText(address + ", " + city);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mMap.clear();
                mMap.addMarker(new MarkerOptions()
                        .position(point).title("Bump").draggable(true));
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadMap();
    }

    private void loadMap() {
        if (mMap != null) {
            return;
        }
        mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
        if (mMap == null) {
            return;
        }
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        mMap.setMyLocationEnabled(true);

    }

    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();

        double longitude = location.getLongitude();

        LatLng latLng = new LatLng(latitude, longitude);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        mMap.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);

    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }






}
