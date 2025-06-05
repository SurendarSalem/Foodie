package com.example.foodie.android.data.model

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.URLBuilder
import io.ktor.http.takeFrom
import io.ktor.serialization.kotlinx.json.json

class KtorApiClient {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json()
        }



        install(Logging) {
            level = LogLevel.ALL
        }
    }

    suspend fun getMovies(): List<Movie> {
        val url = URLBuilder().apply {
            takeFrom("https://jsonplaceholder.typicode.com/todos/1") // Replace with your API endpoint
        }
        val res = httpClient.get(url.buildString())
        val list =  listOf(res.body() as Movie)
        return list
    }
}