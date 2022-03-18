package com.jetbrains.kmm.shared.data.remote

import io.ktor.client.*

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient