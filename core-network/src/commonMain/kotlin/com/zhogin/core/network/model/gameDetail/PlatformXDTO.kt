package com.zhogin.core.network.model.gameDetail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PlatformXDTO(
    @SerialName("platform")
    val platform: PlatformXXDTO,
    @SerialName("released_at")
    val releasedAt: String,
)