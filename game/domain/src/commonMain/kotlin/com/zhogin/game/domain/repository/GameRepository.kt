package com.zhogin.game.domain.repository

import com.zhogin.common.domain.model.CommonGameResponse
import com.zhogin.common.domain.model.Game
import com.zhogin.game.domain.model.GameDetails


interface GameRepository {
    suspend fun getGames(): Result<CommonGameResponse>
    suspend fun getGameDetails(id: Int): Result<GameDetails>
    suspend fun saveGame(id: Int, image: String, name: String)
    suspend fun deleteGame(id: Int)
    suspend fun getNextOrPreviousPage(url: String): Result<CommonGameResponse>
}