package com.zhogin.common.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
fun GameItemView(
    modifier: Modifier = Modifier,
    imageUrl: String,
    gameName: String,
    rating: Double,
    onClickGameInfo: (Int) -> Unit,
    gameID: Int,
    isDeleteShown: Boolean = false,
    onDeleteClick: (Int) -> Unit,
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(350.dp)
            .clickable { onClickGameInfo(gameID) },
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "game image",
                modifier = Modifier.fillMaxWidth()
                    .height(350.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp).background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                ).align(Alignment.BottomCenter),
                //contentAlignment = Alignment.BottomCenter
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = gameName,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).weight(1f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "Rate: $rating",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }
            if (isDeleteShown) {
                IconButton(
                    onClick = {onDeleteClick(gameID)},
                    modifier = Modifier
                        .padding(12.dp)
                        .background(
                            color = Color.White,
                            shape = CircleShape
                        )
                        .align(Alignment.TopEnd)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete from Database",
                        modifier = Modifier.padding(4.dp)
                    )
                }
            }
        }
    }
}
