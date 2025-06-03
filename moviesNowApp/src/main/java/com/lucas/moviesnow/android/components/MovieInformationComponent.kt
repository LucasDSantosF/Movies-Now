package com.lucas.moviesnow.android.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.lucas.moviesnow.android.screen.MovieDetailsScreenNavigation

@Composable
fun MovieInformationRow(
    movie: MovieDetailsScreenNavigation
) {
    Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp).fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        AsyncImage(
            model = movie.posterUrl,
            contentDescription = movie.title,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .height(220.dp)
                .width(160.dp)
        )
        Column(
            modifier = Modifier.weight(1F),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                textAlign = TextAlign.End,
                modifier = Modifier.padding(bottom = 12.dp),
                text = movie.description,
                fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                textAlign = TextAlign.End,
                modifier = Modifier.padding(bottom = 12.dp),
                text = movie.releaseYear.toString(),
                fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.tertiary
            )

            Text(
                textAlign = TextAlign.End,
                modifier = Modifier.padding(bottom = 12.dp),
                text = "${String.format("%.2f", movie.duration)} horas",
                fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                textAlign = TextAlign.End,
                modifier = Modifier.padding(bottom = 12.dp),
                text = "⭐ ${movie.rating}/10",
                fontSize = TextUnit(value = 16f, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}