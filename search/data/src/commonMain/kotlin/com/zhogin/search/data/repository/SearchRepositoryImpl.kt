package com.zhogin.search.data.repository

import com.zhogin.common.data.mappers.toCommonGameResponse
import com.zhogin.common.domain.model.CommonGameResponse
import com.zhogin.core.network.apiService.ApiService
import com.zhogin.search.domain.repository.SearRepository

class SearchRepositoryImpl(
    private val apiService: ApiService
) : SearRepository {
    override suspend fun search(q: String): Result<CommonGameResponse> {
        return try {
            val response = apiService.searchGame(q)
            val data = response.getOrThrow().toCommonGameResponse()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    override suspend fun searchNextOrPreviousPage(q: String): Result<CommonGameResponse> {
        return try {
            val response = apiService.getNextOrPreviousPage(q)
            val data = response.getOrThrow().toCommonGameResponse()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}