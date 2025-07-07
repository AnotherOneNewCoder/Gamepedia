package com.zhogin.common.domain.model

data class CommonGameResponse(
    val games: List<Game>,
    val previous: String? = "",
    val next: String? = "",
    val count: Int,
)