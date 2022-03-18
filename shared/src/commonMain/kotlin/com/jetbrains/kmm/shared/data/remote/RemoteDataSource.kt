package com.jetbrains.kmm.shared.data.remote

import com.jetbrains.kmm.shared.data.remote.response.NetworkTodo
import com.jetbrains.kmm.shared.domain.model.Todo

interface RemoteDataSource {
    @Throws(Throwable::class)
    suspend fun getRemoteTodos(): List<NetworkTodo>
}