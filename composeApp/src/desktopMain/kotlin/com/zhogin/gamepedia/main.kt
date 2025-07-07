package com.zhogin.gamepedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.zhogin.gamepedia.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Gamepedia",
    ) {
        initKoin()
        App()
    }
}