package com.mandisi.shop2shop.shop2shopweatherapp.util

import com.mandisi.shop2shop.shop2shopweatherapp.R
import com.mandisi.shop2shop.shop2shopweatherapp.ui.statemodel.Description

fun setImage(description: Description) = when (description) {
    Description.CLEAR -> R.drawable.bg_forest_sunny
    Description.CLOUDS -> R.drawable.bg_forest_cloudy
    Description.RAIN, Description.SNOW -> R.drawable.bg_forest_rainy
}