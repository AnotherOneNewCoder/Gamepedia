package com.zhogin.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
internal fun SearchGameItemView(
    modifier: Modifier = Modifier,
    onClickSearchedGame: (Int) -> Unit,
    imageUri: String,
    gameId: Int,
    gameName: String,
    rating: Double,
) {
    Box(modifier = modifier.height(250.dp)) {
        AsyncImage(
            model = imageUri, contentDescription = null,
            modifier = Modifier.padding(12.dp).background(
                color = Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ).clip(RoundedCornerShape(12.dp))
                .height(250.dp)
                .clickable(onClick = { onClickSearchedGame(gameId) }),
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
    }
}
