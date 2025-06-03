package com.lucas.moviesnow.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.lucas.moviesnow.domain.Movie

@Composable
fun MovieCard(movie: Movie, onClickAction: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(bottom = 40.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondary)
                .clickable { onClickAction() }
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primary),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = movie.posterUrl,
                    contentDescription = movie.title,
                    contentScale = ContentScale.FillBounds,
                )
                Text(
                    text = movie.title,
                    fontSize = TextUnit(value = 20f, type = TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.tertiary
                )
                Text(
                    modifier = Modifier.padding(bottom = 12.dp),
                    text = "⭐ ${movie.rating}     ◼     ${movie.releaseYear} ",
                    fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
    }
}