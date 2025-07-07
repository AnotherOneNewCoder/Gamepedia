package com.zhogin.favorite.presentation.di

import com.zhogin.favorite.presentation.FavoriteViewModel
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getFavoritePresentationModule(): Module {
    return module {
        viewModel { FavoriteViewModel(
            getAllLocalCachedGamesUseCase = get(),
            deleteUseCase = get(),
        ) }
    }
}