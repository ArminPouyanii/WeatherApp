package com.armin.weatherapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.armin.weatherapplication.api.ApiWeatherApp
import com.armin.weatherapplication.model.response.CurrentWeatherResponse
import com.armin.weatherapplication.utils.RetrofitConnection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL="https://api.openweathermap.org/"
const val lon="47.06"
const val lat="34.31"
const val AppId="10e6644f562878ec1f3babe9478ec058"
class   MainActivity : AppCompatActivity() {
    private var TAG="mainActivity"
     private var response=RetrofitConnection()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            val btn=findViewById<Button>(R.id.btn_check)

            btn.setOnClickListener {
                response.serverData()
            }

    }

    private fun getResponse(){

        val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

        val service=retrofit.create(ApiWeatherApp::class.java)

        var call=service.getWeather(lat, lon, AppId)

        call.enqueue(object :Callback<CurrentWeatherResponse>{
            override fun onResponse(
                call: Call<CurrentWeatherResponse>,
                response: Response<CurrentWeatherResponse>
            ) {
                val weather=response.body()
                var stringBuilder="Country:"+weather!!.sys.country
                Log.e("sys",stringBuilder)
            }

            override fun onFailure(call: Call<CurrentWeatherResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }

}

