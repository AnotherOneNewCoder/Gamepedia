package com.zhogin.search.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhogin.common.domain.model.Game
import com.zhogin.search.domain.useCases.SearchGameNextOrPreviousPageUseCase
import com.zhogin.search.domain.useCases.SearchGamesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchGamesUseCase: SearchGamesUseCase,
    private val searchGameNextOrPreviousPageUseCase: SearchGameNextOrPreviousPageUseCase,
) : ViewModel() {
    private val _query = MutableStateFlow("")
    fun updateQuery(q: String) {
        _query.update { q }
    }

    private val _uiState = MutableStateFlow(SearchScreen.UiState())
    val uiState = _uiState.asStateFlow()
//        .onStart {
//            _query
//                .filter { it.isNotBlank() }
//                .distinctUntilChanged()
//                .debounce(500)
//                .collectLatest { query ->
//                    search(query)
//                }
//        }.stateIn(
//            scope = viewModelScope,
//            started = SharingStarted.WhileSubscribed(5_000L),
//            initialValue = SearchScreen.UiState()
//        )
    init {
        viewModelScope.launch {
            _query
                .filter { it.isNotBlank() && it.length >= 4 }
                .distinctUntilChanged()
                .debounce(500)
                .collectLatest { query->
                    search(query)
                }
        }
    }


    internal fun search(q: String) = searchGamesUseCase.invoke(q)
        .onStart {
            _uiState.update { SearchScreen.UiState(isLoading = true) }
        }.onEach { result ->
            result.onSuccess { data ->
                _uiState.update { SearchScreen.UiState(
                    data = data.games,
                    count = data.count,
                    next = data.next ?: "",
                    previous = data.previous ?: "",
                ) }
            }.onFailure { error ->
                _uiState.update { SearchScreen.UiState(error = error.message.toString()) }
            }
        }.launchIn(viewModelScope)

    internal fun searchNextOrPreviousPage(url: String) = searchGameNextOrPreviousPageUseCase.invoke(url)
        .onStart {
            SearchScreen.UiState(
                isLoading = true,
                currentPage = url
            )
        }.onEach { result ->
            result.onSuccess { data ->
                _uiState.update {
                    SearchScreen.UiState(
                        data = data.games,
                        count = data.count,
                        currentPage = url,
                        next = data.next ?: "",
                        previous = data.previous ?: "",
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    SearchScreen.UiState(
                        error = error.message.toString(),
                        currentPage = url,
                    )
                }
            }

        }.launchIn(viewModelScope)

}

data object SearchScreen {
    data class UiState(
        val isLoading: Boolean = false,
        val error: String = "",
        val data: List<Game>? = null,
        val next: String = "",
        val previous: String = "",
        val currentPage: String = "",
        val count: Int = 0,
    )
}