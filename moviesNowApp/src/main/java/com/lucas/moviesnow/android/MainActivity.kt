package com.lucas.moviesnow.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.lucas.moviesnow.android.screen.MovieDetailsScreen
import com.lucas.moviesnow.android.screen.MovieDetailsScreenNavigation
import com.lucas.moviesnow.android.screen.MoviesListScreen
import com.lucas.moviesnow.android.utils.YouTubeUrlExtractor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val moviesListNavigation = "MoviesList"

        setContent {
            MoviesNowTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = moviesListNavigation,
                ) {
                    composable(moviesListNavigation) {
                        MoviesListScreen { movie ->
                            navController.navigate(
                                MovieDetailsScreenNavigation(
                                    title = movie.title,
                                    description = movie.description,
                                    releaseYear = movie.releaseYear,
                                    rating = movie.rating,
                                    posterUrl = movie.posterUrl,
                                    trailerUrl = YouTubeUrlExtractor.extractVideoId(movie.trailerUrl).orEmpty(),
                                    duration = movie.duration
                                )
                            )
                        }
                    }

                    composable<MovieDetailsScreenNavigation> {
                        val routeArgs: MovieDetailsScreenNavigation = it.toRoute()
                        MovieDetailsScreen(movie = routeArgs) {
                            navController.navigate(moviesListNavigation)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MoviesNowTheme {
    }
}
