package com.zhogin.favorite.data.repostory

import com.zhogin.common.domain.model.Game
import com.zhogin.core.database.AppDatabase
import com.zhogin.favorite.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.map


class FavoriteRepositoryImpl(
    private val appDatabase: AppDatabase
): FavoriteRepository {
    override fun getAllGames(): Flow<List<Game>> {
        return appDatabase.appDatabaseQueries
            .getAllGames()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list ->
                list.map {
                    Game(
                        id = it.id.toInt(),
                        name = it.name,
                        imageUrl = it.image,
                        rating = 0.00,
                        released = "it.released",
                        shortScreenshots = emptyList()
                    )
                }

            }



    }

    override suspend fun upsert(id: Int, name: String, image: String) {
        appDatabase.appDatabaseQueries.upsert(
            id = id.toLong(),
            image = image,
            name = name,
        )
    }

    override suspend fun delete(id: Int) {
        appDatabase.appDatabaseQueries.delete(id.toLong())
    }
}