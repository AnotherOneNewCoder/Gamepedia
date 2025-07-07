package com.zhogin.gamepedia.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class NavigationViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(NavigationScreen.UiState())
    val uiState = _uiState.asStateFlow()

    internal suspend fun getScreens(screens: List<String>) {
        _uiState.update {
            NavigationScreen.UiState(
                screenshots = screens
            )
        }
    }

}
object NavigationScreen {
    data class UiState(
        val screenshots: List<String>? = null,
        )
}