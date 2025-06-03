package com.lucas.moviesnow.android.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lucas.moviesnow.android.MoviesNowTheme
import com.lucas.moviesnow.android.components.FailedContentBody
import com.lucas.moviesnow.android.components.Header
import com.lucas.moviesnow.android.components.LoadingContent
import com.lucas.moviesnow.android.components.MovieCard
import com.lucas.moviesnow.domain.Movie
import com.lucas.moviesnow.viewModel.MovieNowStateResult
import com.lucas.moviesnow.viewModel.MoviesNowViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoviesListScreen(
    toDetails: (Movie) -> Unit
) {
    val movieViewModel = koinViewModel<MoviesNowViewModel>()
    val state by movieViewModel.state.collectAsState()

    when (val value = state.result) {
        MovieNowStateResult.Loading -> LoadingContent()
        is MovieNowStateResult.Success -> ContentBody(value.movies, toDetails)
        is MovieNowStateResult.Failed -> FailedContentBody(value.error) {
            movieViewModel.loadMovies()
        }
    }
}

@Composable
private fun ContentBody(
    movies: List<Movie>,
    toDetails: (Movie) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Header()
        LazyColumn(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {
            item {
                Spacer(Modifier.padding(vertical = 20.dp))
                movies.forEach { movie ->
                    MovieCard(movie) {
                        toDetails(movie)
                    }
                }
            }
        }
    }
}