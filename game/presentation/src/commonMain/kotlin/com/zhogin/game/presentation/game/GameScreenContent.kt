package com.zhogin.game.presentation.game

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zhogin.common.presentation.BottomBarNextAndPrevious
import com.zhogin.common.presentation.GameItemView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun GameScreenContent(
    modifier: Modifier = Modifier,
    uiState: GameScreen.UiState,
    onFavoriteClick: () -> Unit,
    onSearchClick: () -> Unit,
    onClickGameInfo: (id: Int) -> Unit,
    onRefreshClick: () -> Unit,
    onClickPreviousPage: () -> Unit,
    onClickNextPage: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Gamepedia")
                },
                actions = {
                    IconButton(onClick = onSearchClick) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "search")
                    }
                    IconButton(
                        onClick = onFavoriteClick
                    ) {
                        //Icon(painter = painterResource(Res.drawable.favorite), contentDescription = null)
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomBarNextAndPrevious(
                hasPrevious = uiState.previous.isNotBlank(),
                hasNext = uiState.next.isNotBlank(),
                onClickNext = onClickNextPage,
                onClickPrevious = onClickPreviousPage,
            )
        }
    ) { padding ->
        if (uiState.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        if (uiState.error.isNotBlank()) {
            Box(
                modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
            ) {
                //Text(text = uiState.error)
                Column {
                    Text(
                        text = uiState.error
                    )
                    Spacer(Modifier.height(8.dp))
                    IconButton(
                        onClick = onRefreshClick
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null,
                        )
                    }
                }
            }
        }
        uiState.data?.let { data ->
            LazyColumn(
                modifier = modifier.fillMaxSize().padding(padding)
            ) {
                items(items = data, key = {
                    it.id
                }) { game ->
                    GameItemView(
                        modifier = Modifier,
                        imageUrl = game.imageUrl,
                        gameName = game.name,
                        rating = game.rating,
                        onClickGameInfo = { onClickGameInfo(game.id) },
                        gameID = game.id,
                        isDeleteShown = false,
                        onDeleteClick = {}
                    )

                }

            }
        }
    }
}