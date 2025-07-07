package com.zhogin.core.network.model.game


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("background_image")
    val backgroundImage: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("rating")
    val rating: Double,
    @SerialName("released")
    val released: String?,
    @SerialName("short_screenshots")
    val shortScreenshots: List<ShortScreenshot>,
)