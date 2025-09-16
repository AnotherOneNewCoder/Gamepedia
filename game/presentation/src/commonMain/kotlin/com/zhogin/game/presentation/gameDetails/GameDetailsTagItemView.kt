package com.zhogin.game.presentation.gameDetails

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage


@Composable
internal fun GameDetailsTagItemView(
    modifier: Modifier = Modifier,
    tagName: String,
    tagImage: String
) {
    Row(
        modifier = modifier
            .padding(top = 8.dp, end = 12.dp)
            .background(
                color = Color.White,
                shape = RoundedCornerShape(200.dp)
            )
            .border(
                width = .5.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(200.dp)
            )
            .clip(RoundedCornerShape(200.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = tagImage,
            contentDescription = "tag image",
            modifier = Modifier
                .size(35.dp)
                .background(
                    color = Color.Transparent,
                    shape = CircleShape
                )
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = tagName,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}