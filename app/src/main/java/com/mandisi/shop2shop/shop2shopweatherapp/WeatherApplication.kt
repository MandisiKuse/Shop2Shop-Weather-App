package com.mandisi.shop2shop.shop2shopweatherapp

import android.app.Application
import com.mandisi.shop2shop.shop2shopweatherapp.di.allModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WeatherApplication)
            androidLogger(Level.ERROR)
            modules(allModules)
        }
    }
}