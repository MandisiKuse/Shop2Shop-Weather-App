package com.mandisi.shop2shop.shop2shopweatherapp.domain.repository

import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.CurrentWeather
import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.Forecast
import com.mandisi.shop2shop.shop2shopweatherapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    suspend fun getWeatherByCity(city: String): Flow<Resource<CurrentWeather>>

    suspend fun getForecast(lat: Double, lon: Double): Flow<Resource<Forecast>>
}