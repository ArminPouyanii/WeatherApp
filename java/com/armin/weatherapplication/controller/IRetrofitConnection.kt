package com.armin.weatherapplication.controller

interface IRetrofitConnection {
    //add method with get data

    fun onWeatherData(baseUrl:String,lat:String,lon:String,apiID:String)
}