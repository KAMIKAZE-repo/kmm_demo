package com.jetbrains.kmm.shared.data.repository

import com.jetbrains.kmm.shared.data.local.LocalDataSource
import com.jetbrains.kmm.shared.data.local.TodoDataBase
import com.jetbrains.kmm.shared.data.mappers.toDbModel
import com.jetbrains.kmm.shared.data.mappers.toDomain
import com.jetbrains.kmm.shared.data.remote.ApiService
import com.jetbrains.kmm.shared.data.remote.RemoteDataSource
import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val apiService: RemoteDataSource,
    private val dataBase: LocalDataSource
): TodoRepository {
    override suspend fun getRemoteTodos(): List<Todo> {
        return apiService.getRemoteTodos().map{it.toDomain()}
    }

    override suspend fun createTodo(todo: Todo) {
        dataBase.createTodo(todo.toDbModel())
    }

    override suspend fun deleteTodoById(todoId: Long) {
        dataBase.deleteTodoById(todoId)
    }

    override suspend fun getTodoById(todoId: Long): Todo? {
        return dataBase.getTodoById(todoId).toDomain()
    }

    override fun getAllTodos(): Flow<List<Todo>> {
        return dataBase.getAllTodos().map { it.toDomain() }
    }
}