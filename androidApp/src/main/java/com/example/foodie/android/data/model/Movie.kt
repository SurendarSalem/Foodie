package com.example.foodie.android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)