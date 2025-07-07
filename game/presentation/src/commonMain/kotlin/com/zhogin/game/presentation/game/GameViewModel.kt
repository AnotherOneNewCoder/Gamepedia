package com.zhogin.game.presentation.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhogin.common.domain.model.Game
import com.zhogin.game.domain.useCases.GetGamesUseCase
import com.zhogin.game.domain.useCases.GetNextOrPreviousPageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class GameViewModel(
    private val gamesUseCase: GetGamesUseCase,
    private val getNextOrPreviousPageUseCase: GetNextOrPreviousPageUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(GameScreen.UiState())

    val uiState = _uiState
        .onStart {
//            gamesUseCase.invoke()
//                .onStart { _uiState.update { GameScreen.UiState(isLoading = true) } }
//                .onEach { result ->
//                    result.onSuccess { data ->
//                        _uiState.update { GameScreen.UiState(data = data) }
//                    }.onFailure { error ->
//                        _uiState.update { GameScreen.UiState(error = error.message.toString()) }
//                    }
//                }.launchIn(viewModelScope)
            getGames()
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = GameScreen.UiState()
        )

    internal fun getGames() {
        gamesUseCase.invoke()
            .onStart { _uiState.update { GameScreen.UiState(isLoading = true) } }
            .onEach { result ->
                result.onSuccess { data ->
                    _uiState.update {
                        GameScreen.UiState(
                            data = data.games,
                            next = data.next ?: "",
                            previous = data.previous ?: "",
                        )
                    }
                }.onFailure { error ->
                    _uiState.update { GameScreen.UiState(error = error.message.toString()) }
                }
            }.launchIn(viewModelScope)
    }

    internal fun getNextOrPreviousPage(url: String) {
        getNextOrPreviousPageUseCase.invoke(url = url)
            .onStart {
                _uiState.update {
                    GameScreen.UiState(
                        isLoading = true,
                        currentPage = url
                    )
                }
            }
            .onEach { result ->
                result.onSuccess { data ->
                    _uiState.update {
                        GameScreen.UiState(
                            data = data.games,
                            next = data.next ?: "",
                            previous = data.previous ?: "",
                            currentPage = url,
                        )
                    }
                }.onFailure { error ->
                    _uiState.update {
                        GameScreen.UiState(
                            error = error.message.toString(),
                            currentPage = url
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }
}


object GameScreen {
    data class UiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val data: List<Game>? = null,
        val next: String = "",
        val previous: String = "",
        val currentPage: String = "",
    )
}