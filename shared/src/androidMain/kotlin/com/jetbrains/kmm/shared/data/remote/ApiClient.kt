package com.jetbrains.kmm.shared.data.remote

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import java.util.concurrent.TimeUnit

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient {
    return HttpClient(OkHttp){
        config(this)

        engine {
            config {
                retryOnConnectionFailure(true)
                connectTimeout(3, TimeUnit.SECONDS)
            }
        }
    }
}