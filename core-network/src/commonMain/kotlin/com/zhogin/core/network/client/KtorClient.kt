package com.zhogin.core.network.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {


    fun getInstance(): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    //Log.i(TAG_KTOR_LOGGER, message)
                    println(TAG_KTOR_LOGGER + message)

                }

            }
        }

        install(ResponseObserver) {
            onResponse { response ->
                //Log.i(TAG_HTTP_STATUS_LOGGER, "${response.status.value}")
                println(TAG_HTTP_STATUS_LOGGER + "${response.status.value}")
            }
        }


        install(DefaultRequest) {
            url {
                host = "api.rawg.io"
                protocol = URLProtocol.HTTPS
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }
        install(HttpTimeout) {
            socketTimeoutMillis = 3000L
            connectTimeoutMillis = 3000L
            requestTimeoutMillis = 3000L
        }
    }



    private const val TAG_KTOR_LOGGER = "ktor_logger: "
    private const val TAG_HTTP_STATUS_LOGGER = "http_status: "

}