package com.armin.weatherapplication.controller

import com.armin.weatherapplication.model.WeatherData
import com.armin.weatherapplication.view.IShowData

data class ControllerWeather(val iShowData: IShowData):IControllerWeather {
    override fun validData(
        country: String,
        temp: String,
        temp_max: String,
        temp_min: String,
        humidity: String,
        pressure: String
    ) {
        var weatherData=WeatherData(country,temp,temp_max,temp_min,humidity,pressure)
        var ckeck=weatherData.status()
        if (ckeck==false){
            iShowData.showData("Connection Failed")
        }else{

        }
    }
}