package com.zhogin.core.network.model.gameDetail


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StoreDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("store")
    val store: StoreXDTO,
    @SerialName("url")
    val url: String
)