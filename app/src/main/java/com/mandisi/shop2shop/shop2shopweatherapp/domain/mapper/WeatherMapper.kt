package com.mandisi.shop2shop.shop2shopweatherapp.domain.mapper

import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.Forecast
import com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model.WeatherData
import com.mandisi.shop2shop.shop2shopweatherapp.ui.statemodel.CurrentWeatherState
import com.mandisi.shop2shop.shop2shopweatherapp.ui.statemodel.Description
import com.mandisi.shop2shop.shop2shopweatherapp.ui.statemodel.WeeklyForecast
import com.mandisi.shop2shop.shop2shopweatherapp.util.Resource
import com.mandisi.shop2shop.shop2shopweatherapp.util.getDayFromDate

class WeatherMapper {
    fun mapWeatherToWeatherState(response: Resource<Forecast>) =
        when (response) {
            is Resource.Success -> {
                response.data?.list.let { forecastList ->
                    Resource.Success(
                        CurrentWeatherState(
                            current = forecastList?.first()?.main?.temp?.toInt() ?: 0,
                            min = forecastList?.first()?.main?.temp_min?.toInt() ?: 0,
                            max = forecastList?.first()?.main?.temp_max?.toInt() ?: 0,
                            description = Description.valueOf(
                                forecastList?.first()?.weather?.first()?.main?.toUpperCase(
                                    Locale.current
                                ) ?: "CLEAR"
                            ),
                            forecast = forecastData(forecastList)
                        )
                    )
                }
            }

            is Resource.Error -> Resource.Error(response.message)

            is Resource.Loading -> Resource.Loading()
        }

    private fun forecastData(forecast: List<WeatherData>?): List<WeeklyForecast> {
        val dayOfWeek = mutableSetOf<String>()
        val weatherList = mutableListOf<WeatherData>()

        forecast?.forEach { weatherData ->
            weatherData.dt_txt?.substringBefore(" ")?.let { day ->
                if (day !in dayOfWeek) {
                    dayOfWeek.add(day)
                    weatherList.add(weatherData)
                }
            }
        }

        if (weatherList.isNotEmpty()) {
            weatherList.removeFirst()
        }

        return weatherList.map {
            val date = it.dt_txt?.substringBefore(" ").toString()
            WeeklyForecast(
                day = getDayFromDate(date),
                temp = it.main?.temp?.toInt() ?: 0,
                description = Description.valueOf(
                    it.weather?.first()?.main?.uppercase() ?: "CLEAR"
                )
            )
        }
    }
}