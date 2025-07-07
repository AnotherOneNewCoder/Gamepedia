package com.zhogin.search.domain.di

import com.zhogin.search.domain.useCases.SearchGameNextOrPreviousPageUseCase
import com.zhogin.search.domain.useCases.SearchGamesUseCase
import org.koin.dsl.module

fun getSearchDomainModule() = module {
    factory { SearchGamesUseCase(searRepository = get()) }
    factory { SearchGameNextOrPreviousPageUseCase(searRepository = get()) }
}