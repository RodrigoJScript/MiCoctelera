package com.rodrigojscript.micoctelera.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

@Composable
fun BaseAppTheme(content: @Composable () -> Unit) {
    MiCocteleraTheme() {
        Surface(color = MaterialTheme.colors.background)
        {
            content()
        }
    }
}
