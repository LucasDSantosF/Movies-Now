package com.lucas.moviesnow.data.service

import com.lucas.moviesnow.domain.Movie

interface MoviesNowService {
    suspend fun getMovies(): Result<List<Movie>>
}