package com.zhogin.game.presentation.gameDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.zhogin.game.domain.model.Developer
import com.zhogin.game.domain.model.Platform
import com.zhogin.game.domain.model.Store
import com.zhogin.game.domain.model.Tag

@Composable
internal fun GameDetailsItemView(
    modifier: Modifier = Modifier,
    backgroundImage: String,
    gameName: String,
    description: String,
    platforms: List<Platform>,
    stores: List<Store>,
    tags: List<Tag>,
    developers: List<Developer>,
    onRemoveFromDatabase: (Int) -> Unit,
    onSaveToDatabase: (id: Int, title: String, image: String) -> Unit,
    onBackClick: () -> Unit,
    gameId: Int,
    screenshots: List<String>?,
    ) {
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                AsyncImage(
                    model = backgroundImage,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(350.dp),
                    contentScale = ContentScale.Crop
                )
            }

            item {
                Text(
                    modifier = Modifier.padding(6.dp).fillMaxWidth(),
                    text = gameName,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp).fillMaxWidth(),
                    text = description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Platforms",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp)
                    )
                    LazyRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(platforms) { platform ->
                            GameDetailsPlatformItemView(
                                platformName = platform.name,
                                platformImageUrl = platform.image,
                            )
                        }
                    }
                }
            }
            item {
                Text(
                    text = "Stores",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 24.dp,
                        bottom = 12.dp
                    )
                )
            }
            items(stores) { store ->
                GameDetailsStoreItemView(
                    modifier = Modifier,
                    storeName = store.name,
                    storeDomain = store.domain,
                    storeImageUrl = store.image,
                    storeGameCount = store.gameCount
                )
            }
            item {
                Text(
                    text = "Tags",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp, top = 24.dp)
                )
            }
            item {
                FlowRow(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth(),
                ) {
                    tags.forEach { tag ->
                        GameDetailsTagItemView(
                            tagName = tag.name,
                            tagImage = tag.image
                        )
                    }
                }
            }
            item {
                Text(
                    text = "Developers",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(
                        start = 12.dp,
                        end = 12.dp,
                        top = 24.dp,
                        bottom = 12.dp
                    )
                )
            }
            items(developers) { developer ->
                GameDetailsDeveloperItemView(
                    developerName = developer.name,
                    developerImageUrl = developer.image,
                    developerGameCount = developer.gameCount,
                )
            }
            if (!screenshots.isNullOrEmpty()) {
                item {
                    Text(
                        text = "Screenshots",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(
                            start = 12.dp,
                            end = 12.dp,
                            top = 24.dp,
                            bottom = 12.dp
                        )
                    )
                }
                item {
                    FlowRow(
                        modifier = Modifier
                            .padding(horizontal = 12.dp)
                            .fillMaxWidth(),
                    ) {
                        screenshots.forEach { screen ->
                            Box(modifier = Modifier.size(152.dp),
                                contentAlignment = Alignment.Center) {
                                AsyncImage(
                                    model = screen,
                                    contentDescription = null,
                                    modifier = Modifier.size(150.dp),
                                    contentScale = ContentScale.Crop
                                )
                            }

                        }
                    }
                }

            }

        }

        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
            Spacer(Modifier.weight(1f))
            IconButton(
                onClick = {
                    onSaveToDatabase(gameId, gameName, backgroundImage)
                },
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
            Spacer(Modifier.width(12.dp))
            IconButton(
                onClick = {
                    onRemoveFromDatabase(gameId)
                },
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = null,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}