package com.zhogin.search.presentation.di

import com.zhogin.search.presentation.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getSearchPresentationModule() = module {
    viewModel { SearchViewModel(
        searchGamesUseCase = get(),
        searchGameNextOrPreviousPageUseCase = get()
    ) }
}