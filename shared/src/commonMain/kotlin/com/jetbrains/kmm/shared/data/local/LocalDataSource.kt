package com.jetbrains.kmm.shared.data.local

import com.jetbrains.kmm.shared.domain.model.Todo
import comexampledb.TodoEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun createTodo(todoEntity: TodoEntity)
    suspend fun deleteTodoById(todoId: Long)
    suspend fun getTodoById(todoId: Long): TodoEntity?
    fun getAllTodos(): Flow<List<TodoEntity>>
}