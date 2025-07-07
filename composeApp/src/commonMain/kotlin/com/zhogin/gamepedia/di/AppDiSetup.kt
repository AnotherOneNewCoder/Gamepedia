package com.zhogin.gamepedia.di

import com.zhogin.core.database.di.getCoreDatabaseModule
import com.zhogin.core.network.di.getCoreNetworkModule
import com.zhogin.favorite.data.di.getFavoriteDataModule
import com.zhogin.favorite.domain.di.getFavoriteDomainModule
import com.zhogin.favorite.presentation.di.getFavoritePresentationModule
import com.zhogin.game.data.di.getGameDataModule
import com.zhogin.game.domain.di.getGameDomainModule
import com.zhogin.game.presentation.di.getGamePresentationModule
import com.zhogin.search.data.di.getSearchDataModule
import com.zhogin.search.domain.di.getSearchDomainModule
import com.zhogin.search.presentation.di.getSearchPresentationModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

fun initKoin(koinApplication: ((KoinApplication) -> Unit)? = null) {
    startKoin {
        koinApplication?.invoke(this)
        modules(
            getCoreNetworkModule(),
            getGameDataModule(),
            getGameDomainModule(),
            getGamePresentationModule(),
            getSearchDataModule(),
            getSearchDomainModule(),
            getSearchPresentationModule(),
            getCoreDatabaseModule(),
            getFavoriteDataModule(),
            getFavoriteDomainModule(),
            getFavoritePresentationModule(),
            //getMainPresentationModule()
        )
    }
}