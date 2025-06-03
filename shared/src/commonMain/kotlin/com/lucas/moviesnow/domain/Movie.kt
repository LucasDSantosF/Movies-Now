package com.lucas.moviesnow.domain

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: String,
    val title: String,
    val description: String,
    val releaseYear: Int,
    val duration: Double,
    val rating: Double,
    val posterUrl: String,
    val trailerUrl: String,
)
