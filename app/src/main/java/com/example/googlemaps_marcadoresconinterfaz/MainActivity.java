package com.example.googlemaps_marcadoresconinterfaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {
    GoogleMap Marcadores;

    public TextView txtview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        Marcadores=googleMap;
        Marcadores.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        LatLng ltBF= new LatLng(-1.017778783856714, -79.47103074386324);


        //Activar los controles del Zoom
        Marcadores.getUiSettings().setZoomControlsEnabled(true);


        CameraUpdate camUpdBF= CameraUpdateFactory.newLatLngZoom(ltBF,15);
        Marcadores.moveCamera(camUpdBF);

        LatLng Terminal = new LatLng(-1.017778783856714, -79.47103074386324);
        Marcadores.addMarker(new MarkerOptions().position(Terminal).title("Terminal Terreste de Quevedo").snippet(String.valueOf("Empresa de Autobuses"+"                                                              Av. San Rafael"+"                                                                                           Lunes a Domingos"
        )).icon(BitmapDescriptorFactory.fromResource(R.drawable.terminal)).anchor(0.1f,0.1f));

        LatLng Aki = new LatLng(-1.022198363924488, -79.46515134171523);
        Marcadores.addMarker(new MarkerOptions().position(Aki).title("AKÍ Quevedo").snippet(String.valueOf("Supermercado"+ "                                                                                           Calle Bolivar"+ "                                                                                            Lunes a Domingos"
        )).icon(BitmapDescriptorFactory.fromResource(R.drawable.aki)).anchor(0.1f,0.1f));

        Marcadores.setInfoWindowAdapter(new MyInfoWindowAdapter(this));
        }
    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

}




