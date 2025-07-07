package com.zhogin.core.network.model.gameDetail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParentPlatformDTO(
    @SerialName("platform")
    val platform: PlatformDTO
)