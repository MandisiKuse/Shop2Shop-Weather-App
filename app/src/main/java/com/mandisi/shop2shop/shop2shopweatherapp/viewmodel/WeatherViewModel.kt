package com.mandisi.shop2shop.shop2shopweatherapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandisi.shop2shop.shop2shopweatherapp.domain.mapper.WeatherMapper
import com.mandisi.shop2shop.shop2shopweatherapp.domain.repository.CurrentLocationRepository
import com.mandisi.shop2shop.shop2shopweatherapp.domain.repository.WeatherRepository
import com.mandisi.shop2shop.shop2shopweatherapp.ui.statemodel.CurrentWeatherState
import com.mandisi.shop2shop.shop2shopweatherapp.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: CurrentLocationRepository,
    private val weatherMapper: WeatherMapper
) : ViewModel() {

    //Properties Section
    private val _weatherStateFlow = MutableStateFlow<Resource<CurrentWeatherState>?>(Resource.Loading())
    val weatherStateFlow = _weatherStateFlow.asStateFlow()
    //end of section


    //Public API's Section
    fun getCurrentLocation() = viewModelScope.launch {
        locationRepository.getCurrentLocation().let { location ->
            getCurrentForecast(location.latitude, location.longitude)
        }
    }
    //end of section


    //Private Functions Section
    private fun getCurrentForecast(lat: Double, lon: Double) = viewModelScope.launch {
        getForecast(lat, lon).collect { forecast ->
            _weatherStateFlow.value = forecast
        }
    }

    private suspend fun getForecast(lat: Double, lon: Double) =
        weatherRepository.getForecast(lat, lon).map { forecast ->
            weatherMapper.mapWeatherToWeatherState(forecast)
        }
    //end of section
}