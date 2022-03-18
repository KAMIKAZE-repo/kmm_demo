package com.jetbrains.kmm.shared.data.remote

import com.jetbrains.kmm.shared.data.remote.response.NetworkTodo
import io.ktor.client.*

class RemoteDataSourceImpl(
    private val todoApi: ApiService,
    private val client: HttpClient
): RemoteDataSource {

    @Throws(Throwable::class)
    override suspend fun getRemoteTodos(): List<NetworkTodo>{
        return todoApi.getRemoteTodos(client)
    }

}