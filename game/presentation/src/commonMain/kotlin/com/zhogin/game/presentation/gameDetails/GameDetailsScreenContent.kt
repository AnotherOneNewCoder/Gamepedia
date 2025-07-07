package com.zhogin.game.presentation.gameDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlin.String

@Composable
internal fun GameDetailsScreenContent(
    modifier: Modifier = Modifier,
    uiState: GameDetailsScreen.UiState,
    onRemoveFromDatabase: (Int) -> Unit,
    onSaveToDatabase: (id: Int, title: String, image: String) -> Unit,
    onBackClick: () -> Unit,
    screenshots: List<String>?,
) {
    if (uiState.isLoading) {
        Box(
            modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
    if (uiState.error.isNotBlank()) {
        Box(
            modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Text(text = uiState.error)
        }
    }
    uiState.data?.let { data ->
        GameDetailsItemView(
            modifier = modifier,
            backgroundImage = data.backgroundImage,
            gameName = data.name,
            description = data.description,
            platforms = data.platforms,
            stores = data.stores,
            tags = data.tags,
            developers = data.developers,
            onRemoveFromDatabase = onRemoveFromDatabase,
            onSaveToDatabase = onSaveToDatabase,
            onBackClick = onBackClick,
            gameId = data.id,
            screenshots = screenshots,
        )

    }
}