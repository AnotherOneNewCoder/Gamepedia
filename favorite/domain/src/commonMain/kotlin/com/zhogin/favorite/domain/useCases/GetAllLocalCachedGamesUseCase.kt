package com.zhogin.favorite.domain.useCases

import com.zhogin.favorite.domain.repository.FavoriteRepository

class GetAllLocalCachedGamesUseCase(
    private val favoriteRepository: FavoriteRepository
) {
    operator fun invoke() = favoriteRepository.getAllGames()
}