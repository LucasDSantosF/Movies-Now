package com.lucas.moviesnow.android.screen


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lucas.moviesnow.android.components.CustomToolbar
import com.lucas.moviesnow.android.components.MovieInformationRow
import com.lucas.moviesnow.android.components.VideoScreen
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailsScreenNavigation(
    val title: String,
    val description: String,
    val releaseYear: Int,
    val durationMinutes: Double,
    val rating: Double,
    val posterUrl: String,
    val trailerUrl: String,
)

@Composable
fun MovieDetailsScreen(
    movie: MovieDetailsScreenNavigation,
    onBackPressed: () -> Unit
) {
    LazyColumn(Modifier.fillMaxSize()) {
        item {
            CustomToolbar(modifier = Modifier, title = movie.title) { onBackPressed() }
            VideoScreen(movie.trailerUrl)
            MovieInformationRow(movie)
        }
    }
}