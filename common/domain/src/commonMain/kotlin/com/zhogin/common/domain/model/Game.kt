package com.zhogin.common.domain.model

data class Game(
    val id : Int,
    val name: String,
    val imageUrl: String,
    val rating: Double,
    val released: String,
    val shortScreenshots: List<ShortScreenshot>,
)
