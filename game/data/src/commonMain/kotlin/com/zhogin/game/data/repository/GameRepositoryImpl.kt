package com.zhogin.game.data.repository

import com.zhogin.common.data.mappers.toCommonGameResponse
import com.zhogin.common.domain.model.CommonGameResponse
import com.zhogin.core.database.AppDatabase
import com.zhogin.core.network.apiService.ApiService
import com.zhogin.game.data.mappers.toDomainGameDetails
import com.zhogin.game.domain.model.GameDetails
import com.zhogin.game.domain.repository.GameRepository

class GameRepositoryImpl(
    private val apiService: ApiService,
    private val appDatabase: AppDatabase
): GameRepository {
    override suspend fun getGames(): Result<CommonGameResponse> {
        val result = apiService.getGames()
        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toCommonGameResponse())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }

    override suspend fun getGameDetails(id: Int): Result<GameDetails> {
        val result = apiService.getDetails(id)
        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toDomainGameDetails())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }

    override suspend fun saveGame(id: Int, image: String, name: String) {
        appDatabase.appDatabaseQueries.upsert(id = id.toLong(), image = image, name = name)
    }

    override suspend fun deleteGame(id: Int) {
        appDatabase.appDatabaseQueries.delete(id.toLong())
    }

    override suspend fun getNextOrPreviousPage(url: String): Result<CommonGameResponse> {
        val  result = apiService.getNextOrPreviousPage(url = url)
        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toCommonGameResponse())
        } else {
            Result.failure(result.exceptionOrNull()!!)
        }
    }
}