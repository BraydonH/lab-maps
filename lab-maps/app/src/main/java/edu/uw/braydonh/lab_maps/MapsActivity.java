package edu.uw.braydonh.lab_maps;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

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
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(47.653850, -122.307669))
                .title("Dumheller Fountain")
                .icon(BitmapDescriptorFactory.defaultMarker(268))
                .snippet("The ducks are cute, but watch out for angry Geese!"));


        List<LatLng> latLngs = new ArrayList<LatLng>();
        latLngs.add(new LatLng(47.653861, -122.308284));
        latLngs.add(new LatLng(47.653597, -122.308002));
        latLngs.add(new LatLng(47.653826, -122.307820));
        latLngs.add(new LatLng(47.653667, -122.307495));
        latLngs.add(new LatLng(47.653936, -122.307420));

        PolygonOptions polygonOptions = new PolygonOptions();
        polygonOptions.strokeWidth(12);
        polygonOptions.strokeColor(Color.YELLOW);
        polygonOptions.addAll(latLngs);
        polygonOptions.visible(true);

        Polygon polyline = mMap.addPolygon(polygonOptions);
    }
}
