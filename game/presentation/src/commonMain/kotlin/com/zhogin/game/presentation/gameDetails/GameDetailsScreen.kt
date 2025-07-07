package com.zhogin.game.presentation.gameDetails

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun GameDetailsScreen(
    modifier: Modifier = Modifier,
    id: String,
    onBackClick: () -> Unit,
    screenshots: List<String>?,
){
    val viewModel = koinViewModel<GameDetailsViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    LaunchedEffect(id) {
        viewModel.getGameDetails(id.toInt())
    }
    GameDetailsScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState.value,
        onRemoveFromDatabase = {
            viewModel.delete(it)
        },
        onSaveToDatabase = {id,title, image -> viewModel.save(id = id, image = image, name = title)},
        onBackClick = onBackClick,
        screenshots = screenshots,
    )
}

