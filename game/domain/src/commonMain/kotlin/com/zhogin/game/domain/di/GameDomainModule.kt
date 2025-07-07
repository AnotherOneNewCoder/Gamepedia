package com.zhogin.game.domain.di

import com.zhogin.game.domain.useCases.DeleteGameUseCase
import com.zhogin.game.domain.useCases.GetGameDetailsUseCase
import com.zhogin.game.domain.useCases.GetGamesUseCase
import com.zhogin.game.domain.useCases.GetNextOrPreviousPageUseCase
import com.zhogin.game.domain.useCases.SaveGameUseCase
import org.koin.dsl.module

fun getGameDomainModule() = module {
    factory { GetGamesUseCase(gameRepository = get()) }
    factory { GetGameDetailsUseCase(gameRepository = get()) }
    factory { DeleteGameUseCase(gameRepository = get()) }
    factory { SaveGameUseCase(gameRepository = get()) }
    factory { GetNextOrPreviousPageUseCase(gameRepository = get()) }
}