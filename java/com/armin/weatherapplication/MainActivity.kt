package com.armin.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.armin.weatherapplication.controller.ControllerWeather
import com.armin.weatherapplication.controller.RetrofitConnection
import com.armin.weatherapplication.view.IShowData

const val BASE_URL="https://api.openweathermap.org/"
const val lat="47.06"
const val lon="34.31"
const val apiId="10e6644f562878ec1f3babe9478ec058"

class MainActivity : AppCompatActivity(),IShowData {


    private var TAG = "mainActivity"
    private val PERMISSION_ID = 1000
    private var txt: TextView? = null
    private var txtLon: TextView? = null
    private var txtLat: TextView? = null
    private var txtCountry: TextView? = null
    private lateinit var responce:RetrofitConnection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        responce= RetrofitConnection(this)

        val btn = findViewById<Button>(R.id.btn_check)
        txt = findViewById(R.id.txtView)
        txtLat = findViewById(R.id.txtLat)
        txtLon = findViewById(R.id.txtLon)
        txtCountry = findViewById(R.id.txtAdress)
        btn.setOnClickListener {
            responce.onWeatherData(BASE_URL, lat, lon, apiId)
        }

    }

    override fun onShowWeather(
        country: String,
        temp: String,
        temp_max: String,
        temp_min: String,
        humidity: String,
        pressure: String
    ) {
        Log.e("testData","$country -- $temp --$temp_max -- $temp_min -- $humidity -- $pressure ")
    }

}

