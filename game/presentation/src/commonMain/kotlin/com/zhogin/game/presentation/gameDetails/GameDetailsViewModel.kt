package com.zhogin.game.presentation.gameDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhogin.game.domain.model.GameDetails
import com.zhogin.game.domain.useCases.DeleteGameUseCase
import com.zhogin.game.domain.useCases.GetGameDetailsUseCase
import com.zhogin.game.domain.useCases.SaveGameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameDetailsViewModel(
    private val getGameDetailsUseCase: GetGameDetailsUseCase,
    private val saveGameUseCase: SaveGameUseCase,
    private val deleteGameUseCase: DeleteGameUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(GameDetailsScreen.UiState())
    val uiState = _uiState.asStateFlow()


    fun getGameDetails(id: Int) {
        getGameDetailsUseCase.invoke(id)
            .onStart {
                _uiState.update { GameDetailsScreen.UiState(isLoading = true) }
            }.onEach { result ->
                result.onSuccess { data ->
                    _uiState.update {
                        GameDetailsScreen.UiState(
                            //isLoading = false,
                            data = data
                        )
                    }
                }
                    .onFailure { error ->
                        _uiState.update {
                            GameDetailsScreen.UiState(
                                //isLoading = false,
                                error = error.message.toString()
                            )
                        }
                    }
            }.launchIn(viewModelScope)
    }
    fun save(id: Int, image: String, name: String) = viewModelScope.launch {
        saveGameUseCase.invoke(
            id = id,
            image = image,
            name = name,
            )
    }
    fun delete(id: Int) = viewModelScope.launch {
        deleteGameUseCase.invoke(id)
    }
}

data object GameDetailsScreen {
    data class UiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val data: GameDetails? = null
    )
}