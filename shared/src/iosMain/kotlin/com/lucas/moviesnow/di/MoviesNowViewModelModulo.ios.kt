package com.lucas.moviesnow.di

import com.lucas.moviesnow.data.MoviesNowServiceImpl
import com.lucas.moviesnow.data.service.MoviesNowService
import com.lucas.moviesnow.viewModel.MoviesNowViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

actual val moviesNowViewModelModule: Module = module {
    single<MoviesNowService> { MoviesNowServiceImpl() }
    viewModel { MoviesNowViewModel(get()) }
}

object SharedViewModelModule : KoinComponent {
    fun getMoviesNowViewModel(): MoviesNowViewModel = get()
}