package com.app.id.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val GBK = LatLng(-6.582940, 110.662980)
        mMap.addMarker(MarkerOptions().position(GBK).title("Gelora Bumi Kartini"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(GBK))

        mMap.addMarker(MarkerOptions()
            .position(LatLng(-6.593450,110.668449))
            .title("Pendopo Jepara")
            .rotation(3.5.toFloat())
        )

        mMap.addMarker(MarkerOptions()
            .position(LatLng(-7.774810, 110.383990))
            .title("UNIVERSITAS TEKNOLOGI YOGYAKARTA")
            .rotation(3.5.toFloat())
        )

        mMap.addMarker(MarkerOptions()
            .position(LatLng(-6.568730, 110.695420))
            .title("Desa WOnorejo")
            .rotation(3.5.toFloat())
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.normal_map) {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
            return true
        }
        if (id == R.id.hybrid_map) {
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
            return true
        }
        if (id == R.id.satellite_map) {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
            return true
        }
        if (id == R.id.terrain_Map) {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
            return true
        }

        return super.onOptionsItemSelected(item)

    }

}
