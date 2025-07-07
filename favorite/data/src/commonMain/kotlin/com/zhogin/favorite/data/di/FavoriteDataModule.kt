package com.zhogin.favorite.data.di

import com.zhogin.core.database.AppDatabase
import com.zhogin.favorite.data.repostory.FavoriteRepositoryImpl
import com.zhogin.favorite.domain.repository.FavoriteRepository
import org.koin.core.module.Module
import org.koin.dsl.module

fun getFavoriteDataModule(): Module {
    return module {
        factory<FavoriteRepository> { FavoriteRepositoryImpl(appDatabase = get<AppDatabase>()) }
    }
}