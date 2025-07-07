package com.zhogin.game.domain.useCases

import com.zhogin.common.domain.model.CommonGameResponse
import com.zhogin.game.domain.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetNextOrPreviousPageUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke(url: String) = flow<Result<CommonGameResponse>> {
        emit(gameRepository.getNextOrPreviousPage(url = url))
    }.catch { error ->
        emit(Result.failure(error))
    }.flowOn(Dispatchers.IO)
}