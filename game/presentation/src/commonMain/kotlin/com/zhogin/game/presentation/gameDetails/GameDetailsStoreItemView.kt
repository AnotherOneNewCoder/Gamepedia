package com.zhogin.game.presentation.gameDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
internal fun GameDetailsStoreItemView(
    modifier: Modifier = Modifier,
    storeImageUrl: String,
    storeName: String,
    storeDomain: String,
    storeGameCount: Int,
) {

        Row(
            modifier = modifier
                .padding(horizontal = 12.dp)
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
        ) {
            AsyncImage(
                model = storeImageUrl,
                contentDescription = "store image",
                modifier = Modifier
                    .size(120.dp)
                    .background(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(12.dp),
                )
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = storeName,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = storeDomain,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(end = 8.dp),
                    textDecoration = TextDecoration.Underline,
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = "Game count: $storeGameCount",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

        }

}