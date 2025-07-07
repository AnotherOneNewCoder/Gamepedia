package com.zhogin.core.uikit

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val lightColorScheme = lightColorScheme(
    primary = Primary,
    surface = Surface,
    surfaceContainerLowest = SurfaceLowest,
    onSurface = OnSurface,
    onSurfaceVariant = OnSurfaceVariant,
    background = Background
)

@Composable
fun GamepediaTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = lightColorScheme,
        content = content,
        typography = Typography,
    )
}