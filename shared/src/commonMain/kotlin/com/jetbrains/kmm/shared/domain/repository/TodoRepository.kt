package com.jetbrains.kmm.shared.domain.repository

import com.jetbrains.kmm.shared.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun getRemoteTodos(): List<Todo>
    suspend fun createTodo(todo: Todo)
    suspend fun deleteTodoById(todoId: Long)
    suspend fun getTodoById(todoId: Long): Todo?
    fun getAllTodos(): Flow<List<Todo>>
}