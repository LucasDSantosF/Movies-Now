package com.lucas.moviesnow.viewModel

import com.lucas.moviesnow.domain.Movie


data class MovieNowState(
    val result: MovieNowStateResult = MovieNowStateResult.Loading,
)

sealed class MovieNowStateResult {
    data object Loading : MovieNowStateResult()

    data class Success(
        val movies: List<Movie> = emptyList(),
    ) : MovieNowStateResult()

    data class Failed(val error: String) : MovieNowStateResult()
}
