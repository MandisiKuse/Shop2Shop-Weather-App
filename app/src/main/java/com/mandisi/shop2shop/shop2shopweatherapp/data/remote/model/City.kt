package com.mandisi.shop2shop.shop2shopweatherapp.data.remote.model

data class City(
    val coord: Coord?,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
)