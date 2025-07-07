package com.zhogin.game.data.di

import com.zhogin.game.data.repository.GameRepositoryImpl
import com.zhogin.game.domain.repository.GameRepository
import org.koin.dsl.module

fun getGameDataModule() = module {
    factory<GameRepository> { GameRepositoryImpl(
        apiService = get(),
        appDatabase = get(),
    ) }
}