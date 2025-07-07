package com.zhogin.favorite.domain.useCases

import com.zhogin.favorite.domain.repository.FavoriteRepository

class DeleteUseCase(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(id: Int) = favoriteRepository.delete(id)
}