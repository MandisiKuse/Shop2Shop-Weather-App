package com.mandisi.shop2shop.shop2shopweatherapp.data.remote

import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.CurrentWeather
import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.Forecast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        //Please insert your own Open Weather API KEY
        const val API_KEY = "6bf0f2da1228fb3ed7d694d44639e73c"
        const val UNIT = "metric"
    }

    @GET("data/2.5/weather")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("units") units: String = UNIT
    ): Response<CurrentWeather>

    @GET("data/2.5/forecast")
    suspend fun getForecastWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") apiKey: String = API_KEY,
        @Query("units") units: String = UNIT
    ): Response<Forecast>
}