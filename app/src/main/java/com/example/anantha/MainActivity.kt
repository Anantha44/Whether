package com.example.anantha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.anantha.databinding.ActivityMainBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


//https://api.openweathermap.org/data/2.5/weather?q=London

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.searchIcon.setOnClickListener {
            showWeather()
        }

    }

    private  fun showWeather () {
      val retrofit =   Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/weather?q=/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val weatherApi = retrofit.create(WeatherApi::class.java)

        val apiKey = "433fe2abb7ec3406763e95be26453f6e"
        val cityName= "London"

       try {
            val response = weatherApi.getCurrentWeather(cityName , apiKey)
            val weatherDescription = response.weather.firstOrNull()?.description ?: ""
            val temperature = response.main.temp

            val weatherText = "$cityName: $weatherDescription, $temperature degree C"
            binding.showingText.text = weatherText
        }
        catch ( e :java.lang.Exception){
            Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
        }


    }
}