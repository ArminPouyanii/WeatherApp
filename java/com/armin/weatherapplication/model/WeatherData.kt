package com.armin.weatherapplication.model

data class WeatherData(
    val country: String,
    val temp: String,
    val temp_max: String,
    val temp_min: String,
    val humidity: String,
    val pressure: String
):IWeatherData {

    //check get Data
    override fun status(): Boolean {
        if (country.isEmpty()&&temp.isEmpty()&&temp_max.isEmpty()&&temp_min.isEmpty()&&humidity.isEmpty()&&pressure.isEmpty()){
            return false
        }else return true
    }
}
