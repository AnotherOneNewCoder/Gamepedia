package com.zhogin.search.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onClickSearchedGame: (Int) -> Unit,
    onBackClicked: () -> Unit,

) {
    val viewModel = koinViewModel<SearchViewModel>()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    var query = rememberSaveable{
        mutableStateOf("")
    }
    SearchScreenContent(
        modifier = modifier.fillMaxSize(),
        uiState = uiState.value,
        query = query.value,
        onQueryChange = {
            query.value = it
            viewModel.updateQuery(query.value)
        },
        onClickSearchedGame = onClickSearchedGame,
        onBackClicked = onBackClicked,
        onRefreshClick = {
            if (uiState.value.currentPage.isBlank()) {
                viewModel.search(query.value)
            } else {
                viewModel.searchNextOrPreviousPage(uiState.value.currentPage)
            }

        },
        onClickPreviousPage = {
            viewModel.searchNextOrPreviousPage(uiState.value.previous)
        },
        onClickNextPage = {
            viewModel.searchNextOrPreviousPage(uiState.value.next)
        }
    )
}