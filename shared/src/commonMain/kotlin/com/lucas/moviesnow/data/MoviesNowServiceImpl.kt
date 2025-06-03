package com.lucas.moviesnow.data

import com.apollographql.apollo.ApolloClient
import com.lucas.moviesnow.MoviesQuery
import com.lucas.moviesnow.data.getwayBuilder.BuilderHttpRequestMocked
import com.lucas.moviesnow.data.getwayBuilder.mockedMoviesJson
import com.lucas.moviesnow.data.service.MoviesNowService
import com.lucas.moviesnow.domain.Movie


class MoviesNowServiceImpl : MoviesNowService {
    override suspend fun getMovies(): Result<List<Movie>> {
        val apolloClient = getApolloClientWithMock(mockedMoviesJson)
        val response = apolloClient.query(MoviesQuery()).execute()

        val result = if (response.data != null) {
            Result.success(
                response.data!!.movies.map {
                    Movie(
                        id = it.id,
                        title = it.title,
                        description = it.description.orEmpty(),
                        releaseYear = it.releaseYear,
                        duration = it.durationMinutes/60.0,
                        rating = it.rating,
                        posterUrl = it.posterUrl,
                        trailerUrl = it.trailerUrl.orEmpty(),
                    )
                }
            )

        } else Result.failure(
            response.exception ?: Throwable("Unexpected error: request a data by apollo")
        )

        return result
    }


    private fun getApolloClientWithMock(jsonResponse: String): ApolloClient {
        return ApolloClient.Builder()
            .httpEngine(BuilderHttpRequestMocked(jsonResponse))
            .serverUrl("https://your.graphql.api/graphql")
            .build()
    }
}