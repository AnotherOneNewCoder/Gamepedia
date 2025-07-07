package com.zhogin.game.presentation.di

import com.zhogin.game.presentation.game.GameViewModel
import com.zhogin.game.presentation.gameDetails.GameDetailsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getGamePresentationModule() = module {
    viewModel { GameViewModel(
        gamesUseCase = get(),
        getNextOrPreviousPageUseCase = get(),
    ) }
    viewModel { GameDetailsViewModel(
        getGameDetailsUseCase = get(),
        saveGameUseCase = get(),
        deleteGameUseCase = get(),
    ) }
}