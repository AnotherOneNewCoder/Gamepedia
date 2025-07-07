package com.zhogin.search.domain.repository

import com.zhogin.common.domain.model.CommonGameResponse

interface SearRepository {

    suspend fun search(q: String): Result<CommonGameResponse>
    suspend fun searchNextOrPreviousPage(q: String): Result<CommonGameResponse>
}