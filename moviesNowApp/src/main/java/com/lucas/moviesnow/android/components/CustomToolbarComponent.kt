package com.lucas.moviesnow.android.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolbar(
    modifier: Modifier = Modifier,
    title: String,
    theme: ColorScheme = MaterialTheme.colorScheme,
    action: (() -> Unit)? = null,
) {
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = theme.primary),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                fontSize = TextUnit(value = 28.sp.value, type = TextUnitType.Sp),
                color = theme.tertiary,
            )
        },
        navigationIcon = {
            if (action != null) {
                IconButton(
                    onClick = { action() }
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        tint = theme.secondary,
                        contentDescription = null,
                    )
                }
            }
        },
    )
}