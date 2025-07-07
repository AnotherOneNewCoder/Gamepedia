package com.zhogin.game.domain.useCases

import com.zhogin.game.domain.repository.GameRepository

class SaveGameUseCase(
    private val gameRepository: GameRepository
) {
    suspend operator fun invoke(id: Int, image: String, name: String) = gameRepository.saveGame(id, image, name)
}