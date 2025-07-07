package com.zhogin.game.presentation.game

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit,
    onSearchClick: () -> Unit,
    onClickGameInfo: (id:Int) -> Unit,
    sendScreens:(List<String>?) -> Unit,
) {
    val viewModel = koinViewModel<GameViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    GameScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState.value,
        onFavoriteClick = onFavoriteClick,
        onSearchClick = onSearchClick,
        onClickGameInfo = {
            onClickGameInfo(it)
            val game = viewModel.uiState.value.data?.first { game ->
                game.id == it
            }
            val screens = game?.shortScreenshots?.map { it.image }
            sendScreens(screens)
        },
        onRefreshClick = {
            if (uiState.value.currentPage.isBlank()) {
                viewModel.getGames()
            } else {
                viewModel.getNextOrPreviousPage(uiState.value.currentPage)
            }

        },
        onClickNextPage = {
            viewModel.getNextOrPreviousPage(uiState.value.next)
        },
        onClickPreviousPage = { viewModel.getNextOrPreviousPage(uiState.value.previous) },
    )
}

