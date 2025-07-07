package com.zhogin.core.network.di
import com.zhogin.core.network.apiService.ApiService
import com.zhogin.core.network.client.KtorClient
import org.koin.dsl.module

fun getCoreNetworkModule() = module {
    single { ApiService(httpClient = KtorClient.getInstance()) }
}