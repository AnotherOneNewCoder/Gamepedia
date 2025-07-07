package com.zhogin.game.data.mappers

import com.zhogin.core.network.model.gameDetail.GameDetailsResponse
import com.zhogin.game.domain.model.Developer
import com.zhogin.game.domain.model.GameDetails
import com.zhogin.game.domain.model.Platform
import com.zhogin.game.domain.model.Store
import com.zhogin.game.domain.model.Tag

fun GameDetailsResponse.toDomainGameDetails(): GameDetails {
    return GameDetails(
        name = name,
        id = id,
        description = description_raw,
        backgroundImage = background_image,
        additionalImage = background_image_additional,
        platforms = platforms.map {
            Platform(
                name = it.platform.name,
                image = it.platform.imageBackground
            )
        },
        stores = stores.map {
            Store(
                name = it.store.name,
                image = it.store.imageBackground,
                gameCount = it.store.gamesCount,
                domain = it.store.domain
            )
        },
        developers = developers.map {
            Developer(
                name = it.name,
                image = it.imageBackground,
                gameCount = it.gamesCount
            )
        },
        tags = tags.map { 
            Tag(
                name = it.name,
                image = it.imageBackground
            )
        },
    )
}