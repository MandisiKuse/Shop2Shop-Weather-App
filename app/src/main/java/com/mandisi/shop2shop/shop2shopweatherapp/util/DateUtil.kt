package com.mandisi.shop2shop.shop2shopweatherapp.util

import java.text.SimpleDateFormat
import java.util.Locale

fun getDayFromDate(date: String): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.US)
    val dayFormat = SimpleDateFormat("EEEE", Locale.US)

    return dayFormat.format(dateFormat.parse(date) ?: "")
}