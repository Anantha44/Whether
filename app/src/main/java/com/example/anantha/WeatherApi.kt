package com.example.anantha

import retrofit2.http.GET
import retrofit2.http.Query


//https://api.openweathermap.org/data/2.5/weather?q=London

interface WeatherApi {

    @GET("London")
     fun getCurrentWeather(
        @Query("q") cityName : String,
        @Query("appid") apiKey : String
    ) : WeatherResponse
}