package com.zhogin.search.domain.useCases

import com.zhogin.common.domain.model.CommonGameResponse
import com.zhogin.search.domain.repository.SearRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SearchGameNextOrPreviousPageUseCase(
    private val searRepository: SearRepository
) {
    operator fun invoke(q: String) =  flow<Result<CommonGameResponse>> {
        emit(searRepository.searchNextOrPreviousPage(q))
    }.catch { error ->
        emit(Result.failure(error))
    }.flowOn(Dispatchers.IO)
}