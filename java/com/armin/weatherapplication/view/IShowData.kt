package com.armin.weatherapplication.view

interface IShowData {
    fun onShowWeather(country: String,temp: String,temp_max: String,temp_min: String,humidity: String,pressure: String)
}