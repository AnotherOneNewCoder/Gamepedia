package com.zhogin.core.network.model.game


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortScreenshot(
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String
)