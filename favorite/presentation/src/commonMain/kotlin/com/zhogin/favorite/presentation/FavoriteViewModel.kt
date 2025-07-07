package com.zhogin.favorite.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhogin.favorite.domain.useCases.DeleteUseCase
import com.zhogin.favorite.domain.useCases.GetAllLocalCachedGamesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoriteViewModel(
    private val getAllLocalCachedGamesUseCase: GetAllLocalCachedGamesUseCase,
    private val deleteUseCase: DeleteUseCase,
): ViewModel() {
    val games = getAllLocalCachedGamesUseCase.invoke()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = emptyList()
        )
    fun delete(id: Int) = viewModelScope.launch {
        deleteUseCase.invoke(id)
    }
}