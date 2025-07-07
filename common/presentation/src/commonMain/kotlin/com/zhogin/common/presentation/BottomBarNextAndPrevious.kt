package com.zhogin.common.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowLeft
import androidx.compose.material.icons.automirrored.filled.ArrowRight
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomBarNextAndPrevious(
    hasPrevious: Boolean,
    hasNext: Boolean,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit,
    modifier: Modifier = Modifier,

) {
    Row(
        modifier = modifier.fillMaxWidth().padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (hasPrevious) {
            IconButton(
                onClick = onClickPrevious,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                Icon(
                    //imageVector = Icons.AutoMirrored.Filled.ArrowLeft,
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = null
                )

            }
        }

        Spacer(Modifier.weight(1f))
        if (hasNext) {
            IconButton(
                onClick = onClickNext,
                modifier = Modifier.padding(end = 16.dp)
            ) {
                Icon(
                    //imageVector = Icons.AutoMirrored.Filled.ArrowRight,
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = null
                )

            }
        }

    }
}
