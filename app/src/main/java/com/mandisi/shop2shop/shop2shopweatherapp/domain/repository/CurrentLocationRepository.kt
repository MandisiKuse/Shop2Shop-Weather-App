package com.mandisi.shop2shop.shop2shopweatherapp.domain.repository

import android.location.Location

interface CurrentLocationRepository {
    suspend fun getCurrentLocation(): Location
}