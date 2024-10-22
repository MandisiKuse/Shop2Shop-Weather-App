package com.mandisi.shop2shop.shop2shopweatherapp.data.repository

import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.CurrentWeather
import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.Forecast
import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.WeatherApi
import com.mandisi.shop2shop.shop2shopweatherapp.domain.repository.WeatherRepository
import com.mandisi.shop2shop.shop2shopweatherapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class WeatherRepositoryImpl(private val weatherApi: WeatherApi): WeatherRepository {
    override suspend fun getWeatherByCity(city: String): Flow<Resource<CurrentWeather>> =
        flow<Resource<CurrentWeather>> {
            emit(Resource.Loading())
            with(weatherApi.getWeatherByCity(city)) {
                if (!isSuccessful) {
                    emit(Resource.Error(message()))
                } else {
                    body()?.let {
                        emit(Resource.Success(it))
                    } ?: emit(Resource.Error(message()))
                }
            }
        }.catch { emit(Resource.Error(it.localizedMessage)) }

    override suspend fun getForecast(lat: Double, lon: Double): Flow<Resource<Forecast>> =
        flow<Resource<Forecast>> {
            emit(Resource.Loading())
            with(weatherApi.getForecastWeather(lat, lon)) {
                if (!isSuccessful) {
                    emit(Resource.Error(message()))
                } else {
                    body()?.let {
                        emit(Resource.Success(it))
                    } ?: emit(Resource.Error(message()))
                }
            }
        }.catch { emit(Resource.Error(it.localizedMessage)) }
}