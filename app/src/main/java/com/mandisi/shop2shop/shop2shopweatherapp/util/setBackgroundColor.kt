package com.mandisi.shop2shop.shop2shopweatherapp.util

import com.mandisi.shop2shop.shop2shopweatherapp.ui.statemodel.Description
import com.mandisi.shop2shop.shop2shopweatherapp.ui.theme.CloudyColor
import com.mandisi.shop2shop.shop2shopweatherapp.ui.theme.RainyColor
import com.mandisi.shop2shop.shop2shopweatherapp.ui.theme.SunnyColor

fun setBackgroundColor(description: Description) = when (description) {
    Description.CLEAR -> SunnyColor
    Description.CLOUDS -> CloudyColor
    Description.RAIN, Description.SNOW -> RainyColor
}