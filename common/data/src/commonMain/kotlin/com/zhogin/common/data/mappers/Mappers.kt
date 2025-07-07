package com.zhogin.common.data.mappers

import com.zhogin.common.domain.model.CommonGameResponse
import com.zhogin.common.domain.model.Game
import com.zhogin.core.network.model.game.GameResponse
import com.zhogin.core.network.model.game.Result

fun GameResponse.toCommonGameResponse(): CommonGameResponse {
    return CommonGameResponse(
        games = this.results.toDomainListOfGames(),
        next = this.next,
        previous = this.previous,
        count = this.count
    )
}
private fun List<Result>.toDomainListOfGames(): List<Game> = map {
    Game(
        id = it.id,
        name = it.name,
        imageUrl = it.backgroundImage ?: "",
        rating = it.rating,
        released = it.released ?: "",
        shortScreenshots = it.shortScreenshots.toListOfScreenshots()
    )
}

private fun List<com.zhogin.core.network.model.game.ShortScreenshot>.toListOfScreenshots(): List<com.zhogin.common.domain.model.ShortScreenshot> = map {
    com.zhogin.common.domain.model.ShortScreenshot(
        id = it.id,
        image = it.image
    )
}