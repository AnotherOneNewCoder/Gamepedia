package com.zhogin.search.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.NavigateBefore
import androidx.compose.material.icons.automirrored.rounded.NavigateNext
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zhogin.common.domain.model.Game
import com.zhogin.common.presentation.BottomBarNextAndPrevious

@Composable
internal fun SearchScreenContent(
    modifier: Modifier = Modifier,
    uiState: SearchScreen.UiState,
    query: String,
    onQueryChange: (String) -> Unit,
    onClickSearchedGame: (Int) -> Unit,
    onBackClicked: () -> Unit,
    onRefreshClick: () -> Unit,
    onClickPreviousPage: () -> Unit,
    onClickNextPage: () -> Unit,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier.padding(4.dp).padding(top = 16.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBackClicked
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back"
                    )
                }
                Spacer(Modifier.width(8.dp))
                TextField(
                    value = query,
                    onValueChange = onQueryChange,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(end = 8.dp)
                    //    .padding(top = 16.dp)
                    ,
                    colors = TextFieldDefaults.colors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White
                    ),
                    placeholder = {
                        Text("Search: ")
                    }
                )
            }

        },
        bottomBar = {
            BottomBarNextAndPrevious(
                hasNext = uiState.next.isNotBlank(),
                hasPrevious = uiState.previous.isNotBlank(),
                onClickNext =  onClickNextPage,
                onClickPrevious = onClickPreviousPage,
            )
        }
    ) { padding ->
        if (uiState.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }

        }
        if (uiState.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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
            Column(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                Text(
                    text = "Found: ${uiState.count} games",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center

                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize()
                ) {

                    items(data) { item: Game ->
                        SearchGameItemView(
                            onClickSearchedGame = onClickSearchedGame,
                            imageUri = item.imageUrl,
                            gameName = item.name,
                            gameId = item.id,
                            rating = item.rating
                        )
                    }


                }

            }


        }
    }
}
