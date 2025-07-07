package com.zhogin.favorite.domain.useCases

import com.zhogin.favorite.domain.repository.FavoriteRepository

class UpsertUseCase(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(id: Int, name: String, image: String) = favoriteRepository.upsert(
        id = id,
        name = name,
        image = image,
    )
}