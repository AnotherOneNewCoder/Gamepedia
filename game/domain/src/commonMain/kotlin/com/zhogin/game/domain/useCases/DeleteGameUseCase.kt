package com.zhogin.game.domain.useCases

import com.zhogin.game.domain.repository.GameRepository

class DeleteGameUseCase(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(id: Int) = gameRepository.deleteGame(id)
}