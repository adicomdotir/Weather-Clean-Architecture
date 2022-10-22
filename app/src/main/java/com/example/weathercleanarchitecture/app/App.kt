package com.example.weathercleanarchitecture.app

import android.app.Application
import com.example.weathercleanarchitecture.di.appModule
import com.example.weathercleanarchitecture.di.dataModule
import com.example.weathercleanarchitecture.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}