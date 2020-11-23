package com.armin.weatherapplication.utils

import android.util.Log
import com.armin.weatherapplication.api.ApiWeatherApp
import com.armin.weatherapplication.model.response.CurrentWeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConnection (){
    private val TAG="RetrofitConnection"
    //add point url

    companion object{
        const val BASE_URL="https://api.openweathermap.org/"
        const val lat="47.06"
        const val lon="34.31"
        const val apiId="10e6644f562878ec1f3babe9478ec058"
    }

    //create function for connect to server with retrofit
     fun serverData(){

        //create variable retrofit
       var retrofit=Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        //call interface  with retrofit
        val service=retrofit.create(ApiWeatherApp::class.java)

        //get date with call in interface
        val call=service.getWeather(lat, lon, apiId)
        call.enqueue(object :Callback<CurrentWeatherResponse>{
            override fun onResponse(call: Call<CurrentWeatherResponse>, response: Response<CurrentWeatherResponse>) {
                val data=response.body()
                var country=data!!.sys.country
                var temperature=data.main.temp
                var temp_max=data.main.tempMax
                var temp_min=data.main.tempMin
                var humidity=data.main.humidity
                var pressure=data.main.pressure
                Log.e(TAG,"country:$country")
                Log.e(TAG,"temperature:$temperature")
                Log.e(TAG,"temp_max:$temp_max")
                Log.e(TAG,"temp_min:$temp_min")
                Log.e(TAG,"humidity:$humidity")
                Log.e(TAG,"pressure:$pressure")

            }

            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}