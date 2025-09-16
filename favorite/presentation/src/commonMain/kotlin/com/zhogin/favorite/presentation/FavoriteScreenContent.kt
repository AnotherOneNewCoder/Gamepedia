package com.zhogin.favorite.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.zhogin.common.domain.model.Game
import com.zhogin.common.presentation.GameItemView


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FavoriteScreenContent(
    modifier: Modifier = Modifier,
    games: List<Game>,
    onBackClick: () -> Unit,
    onDetails: (Int) -> Unit,
    onDelete: (Int) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Favorites")
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "back",
                        modifier = Modifier.clickable { onBackClick() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                )
            )
        },
    ) { padding ->
        if (games.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Nothing found")
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding)
            ) {
                items(games, key = {it.id}) { game ->
                    GameItemView(
                        isDeleteShown = true,
                        imageUrl = game.imageUrl,
                        gameName = game.name,
                        rating = game.rating,
                        gameID = game.id,
                        onDeleteClick = onDelete,
                        onClickGameInfo = onDetails,
                    )
                }
            }
        }
    }
}