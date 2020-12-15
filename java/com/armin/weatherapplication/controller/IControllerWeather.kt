package com.armin.weatherapplication.controller

interface IControllerWeather {
    fun validData(country: String,temp: String,temp_max: String,temp_min: String,humidity: String,pressure: String)
}