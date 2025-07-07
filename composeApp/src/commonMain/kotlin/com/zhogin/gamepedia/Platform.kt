package com.zhogin.gamepedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform