package com.lucas.moviesnow.android.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FailedContentBody(
    errorMsg: String,
    onClickAction: () -> Unit,
) {
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.secondary)
        .fillMaxSize()
    ) {
        Header()
        Column(
            modifier = Modifier
                .weight(1F)
                .padding(20.dp)
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 12.dp),
                text = "Algo deu errado ao buscar os dados",
                textAlign = TextAlign.Center,
                fontSize = TextUnit(value = 28.sp.value, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                modifier = Modifier
                    .padding(bottom = 24.dp),
                text = errorMsg,
                textAlign = TextAlign.Center,
                fontSize = TextUnit(value = 18.sp.value, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.primary,
            )
        }
        Button(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            onClick = onClickAction
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Tentar novamente",
                fontSize = TextUnit(value = 16.sp.value, type = TextUnitType.Sp),
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }
}