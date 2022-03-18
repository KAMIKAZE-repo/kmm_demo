package com.jetbrains.kmm.shared.domain.use_case.getAllTodo

import com.jetbrains.kmm.shared.domain.model.Todo
import com.jetbrains.kmm.shared.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetAllTodosUseCase(private val repository: TodoRepository) {
    operator fun invoke(): Flow<List<Todo>>{
        return repository.getAllTodos()
    }
}