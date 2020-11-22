package com.armin.weatherapplication.api

import com.armin.weatherapplication.model.response.CurrentWeatherResponse
import com.armin.weatherapplication.model.response.Main
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.zip.Deflater


const val Api_Key="10e6644f562878ec1f3babe9478ec05"
 interface ApiWeatherApp {
    @GET("/data/2.5/weather?")
    fun getWeather(@Query("lat") lat:String,@Query("lon") lon:String,@Query("APPID") app_id:String):Call<CurrentWeatherResponse>


}