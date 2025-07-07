package com.zhogin.favorite.domain.di

import com.zhogin.favorite.domain.useCases.DeleteUseCase
import com.zhogin.favorite.domain.useCases.GetAllLocalCachedGamesUseCase
import com.zhogin.favorite.domain.useCases.UpsertUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

fun getFavoriteDomainModule(): Module {
    return module {
        factory { DeleteUseCase(get()) }
        factory { GetAllLocalCachedGamesUseCase(get()) }
        factory { UpsertUseCase(get()) }
    }
}