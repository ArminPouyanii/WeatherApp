package com.armin.weatherapplication.controller

import android.util.Log
import com.armin.weatherapplication.model.api.ApiWeatherApp
import com.armin.weatherapplication.model.response.CurrentWeatherResponse
import com.armin.weatherapplication.view.IShowData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

data class RetrofitConnection (var iShowData: IShowData): IRetrofitConnection {
    private val TAG="RetrofitConnection"

    override fun onWeatherData(baseUrl: String, lat: String, lon: String, apiID: String) {
        //create variable retrofit
        var retrofit=Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
        //call interface  with retrofit
        val service=retrofit.create(ApiWeatherApp::class.java)

        //get date with call in interface
        val call=service.getWeather(lat, lon, apiID)
        call.enqueue(object :Callback<CurrentWeatherResponse>{
            override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>) {
                val data=response.body()
                var country=data!!.sys.country
                var temperature=data.main.temp.toString()
                var temp_max=data.main.tempMax.toString()
                var temp_min=data.main.tempMin.toString()
                var humidity=data.main.humidity.toString()
                var pressure=data.main.pressure.toString()
                iShowData.onShowWeather(country,temperature,temp_max,temp_min,humidity,pressure)

//                Log.e(TAG,"country:$country")
//                Log.e(TAG,"temperature:$temperature")
//                Log.e(TAG,"temp_max:$temp_max")
//                Log.e(TAG,"temp_min:$temp_min")
//                Log.e(TAG,"humidity:$humidity")
//                Log.e(TAG,"pressure:$pressure")
            }

            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}