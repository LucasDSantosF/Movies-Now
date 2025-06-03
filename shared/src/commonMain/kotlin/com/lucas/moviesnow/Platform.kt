package com.lucas.moviesnow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform