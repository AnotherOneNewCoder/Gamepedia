package com.zhogin.search.data.di

import com.zhogin.search.data.repository.SearchRepositoryImpl
import com.zhogin.search.domain.repository.SearRepository
import org.koin.dsl.module

fun getSearchDataModule() = module {
    factory<SearRepository> { SearchRepositoryImpl(apiService = get()) }
}