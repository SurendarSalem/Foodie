package com.example.foodie

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform