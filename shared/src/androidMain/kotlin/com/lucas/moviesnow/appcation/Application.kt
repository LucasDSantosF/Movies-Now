package com.lucas.moviesnow.appcation

import android.app.Application
import com.lucas.moviesnow.di.moviesNowViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@Application)
            androidLogger(Level.DEBUG)
            modules(moviesNowViewModelModule)
        }
    }
}