package com.mandisi.shop2shop.shop2shopweatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mandisi.shop2shop.shop2shopweatherapp.ui.navigation.AppNavHost
import com.mandisi.shop2shop.shop2shopweatherapp.ui.navigation.localNavController
import com.mandisi.shop2shop.shop2shopweatherapp.ui.theme.Shop2ShopWeatherAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Shop2ShopWeatherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompositionLocalProvider(
                        value = localNavController provides rememberNavController()
                    ) {
                        AppNavHost()
                    }
                }
            }
        }
    }
}