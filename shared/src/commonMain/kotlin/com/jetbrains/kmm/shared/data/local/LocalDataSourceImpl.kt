package com.jetbrains.kmm.shared.data.local

import comexampledb.TodoEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(private val database: TodoDataBase): LocalDataSource {
    override suspend fun createTodo(todoEntity: TodoEntity) {
        database.createTodo(todoEntity)
    }

    override suspend fun deleteTodoById(todoId: Long) {
        database.deleteTodoById(todoId)
    }

    override suspend fun getTodoById(todoId: Long): TodoEntity? {
        return database.getTodoById(todoId)
    }

    override fun getAllTodos(): Flow<List<TodoEntity>> {
        return database.getAllTodos()
    }
}