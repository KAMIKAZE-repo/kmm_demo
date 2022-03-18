package com.jetbrains.kmm.shared.data.remote

import com.jetbrains.kmm.shared.data.remote.response.NetworkTodo
import com.jetbrains.kmm.shared.helper.Constants
import io.ktor.client.*
import io.ktor.client.request.*

class ApiService {
    //@Throws(Throwable::class)
    suspend fun getRemoteTodos(httpClient: HttpClient): List<NetworkTodo>{
        return httpClient.get(Constants.BASE_URL + Constants.GET_TODOS)
    }
}