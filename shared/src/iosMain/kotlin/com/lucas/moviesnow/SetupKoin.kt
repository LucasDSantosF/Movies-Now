package com.lucas.moviesnow

import com.lucas.moviesnow.di.moviesNowViewModelModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(moviesNowViewModelModule)
    }
}