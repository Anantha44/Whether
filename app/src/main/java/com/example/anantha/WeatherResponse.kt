package com.example.anantha

import java.io.FileDescriptor

data class WeatherResponse(
    val weather : List<Weather>,
    val main : Main,
    val name : String
)

data class Weather(
    val main : String,
    val description : String
    )

data class Main (
    val temp : Double,
    val pressure : Int,
    val humidity : Int
    )