package com.zhogin.game.domain.model

data class GameDetails(
    val name: String,
    val id: Int,
    val description: String,
    val backgroundImage: String,
    val additionalImage: String?,
    val platforms: List<Platform>,
    val stores: List<Store>,
    val developers: List<Developer>,
    val tags: List<Tag>
)
