package com.armin.weatherapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.armin.weatherapplication.utils.RetrofitConnection
import com.armin.weatherapplication.utils.ServiceLocation
import com.google.android.gms.location.*
import java.util.*


class MainActivity : AppCompatActivity() {
    private var TAG = "mainActivity"
    private val PERMISSION_ID = 1000
    private var response = RetrofitConnection()
    private var txt: TextView? = null
    private var txtLon: TextView? = null
    private var txtLat: TextView? = null
    private var txtCountry: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn = findViewById<Button>(R.id.btn_check)
        txt = findViewById(R.id.txtView)
        txtLat = findViewById(R.id.txtLat)
        txtLon = findViewById(R.id.txtLon)
        txtCountry = findViewById(R.id.txtAdress)
        btn.setOnClickListener {
            response.serverData()
        }

    }


}

