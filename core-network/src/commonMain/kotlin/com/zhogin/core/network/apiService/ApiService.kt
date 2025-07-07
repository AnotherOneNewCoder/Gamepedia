package com.zhogin.core.network.apiService

import com.zhogin.core.network.model.game.GameResponse
import com.zhogin.core.network.model.gameDetail.GameDetailsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(
    val httpClient: HttpClient
) {

    // https://api.rawg.io/api/games?key=aad8ac0be20b49fdb9b6cdc88ce960fc
    suspend fun getGames(): Result<GameResponse> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "aad8ac0be20b49fdb9b6cdc88ce960fc")
                }
            }.body<GameResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun searchGame(q: String): Result<GameResponse> {
        return try {
            val response = httpClient.get("api/games") {
                url {
                    parameter("key", "aad8ac0be20b49fdb9b6cdc88ce960fc")
                    parameter("search", q)
                }
            }.body<GameResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    // https://api.rawg.io/api/games/4200?key=aad8ac0be20b49fdb9b6cdc88ce960fc
    suspend fun getDetails(id: Int): Result<GameDetailsResponse> {
        return try {
            val response = httpClient.get("api/games/${id}") {
                url {
                    parameter("key", "aad8ac0be20b49fdb9b6cdc88ce960fc")
                }
            }.body<GameDetailsResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getNextOrPreviousPage(url: String): Result<GameResponse> {
        return try {
            val response = httpClient.get(url).body<GameResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

}